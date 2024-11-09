package org.noctisdev.payments.application.impl;

import org.noctisdev.payments.application.IPaymentProfileService;
import org.noctisdev.payments.application.IPaymentService;
import org.noctisdev.payments.application.dto.BaseResponse;
import org.noctisdev.payments.application.dto.request.PaymentRequest;
import org.noctisdev.payments.application.dto.response.PaymentResponse;
import org.noctisdev.payments.application.factory.EventFactory;
import org.noctisdev.payments.domain.broker.IMessageProducer;
import org.noctisdev.payments.domain.external.IPayments;
import org.noctisdev.payments.domain.models.Payment;
import org.noctisdev.payments.domain.models.PaymentProfile;
import org.noctisdev.payments.domain.repository.IPaymentRepository;
import org.noctisdev.payments.utils.ThreadsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private IPayments payments;

    @Autowired
    private IPaymentProfileService paymentProfileService;

    @Autowired
    private IPaymentRepository repository;

    @Autowired
    private IMessageProducer producer;

    @Override
    public BaseResponse getPayment(String email) {
        List<PaymentResponse> payments = repository.findByEmail(email).stream().map(payment -> {
            return new PaymentResponse(
                "url",
                LocalDate.now(),
                payment.getPayerName(),
                payment.getPayerEmail(),
                payment.getPayerPhone()
            );
        }).toList();

        return BaseResponse.builder()
            .data(payments)
            .message("Payments retrieved successfully")
            .success(Boolean.TRUE)
            .httpStatus(HttpStatus.OK)
            .status(200).build();
    }

    @Override
    public BaseResponse generatePayment(PaymentRequest request) {
        PaymentProfile profile = paymentProfileService.findByUuid(request.paymentProfileId());

        Payment payment = new Payment();
        payment.setPaymentUuid(UUID.randomUUID());
        payment.setAmount(request.amount());
        payment.setPaymentProfile(profile);
        payment.setPayerName(request.payerName());
        payment.setPayerEmail(request.payerEmail());
        payment.setPayerPhone(request.payerPhoneNumber());

        repository.save(payment);

        String url = payments.generateDonationPaymentUrl("another", payment.getAmount());
        PaymentResponse response = new PaymentResponse(
            url,
            LocalDate.now(),
            payment.getPayerName(),
            payment.getPayerEmail(),
            payment.getPayerPhone()
        );

        ThreadsUtil.runTask(() -> {
            EventFactory factory = EventFactory.builder()
                    .type(request.notifyChannel())
                    .email(request.payerEmail())
                    .phoneNumber(request.payerPhoneNumber())
                    .subject("SCI-ALL Payments")
                    .message("Your payment order has been created on: " + url)
                    .producer(producer).build();

            factory.getNotification().send();
        });

        return BaseResponse.builder()
            .data(response)
            .message("Payment generated successfully")
            .success(Boolean.TRUE)
            .httpStatus(HttpStatus.OK)
            .status(200).build();
    }
}
