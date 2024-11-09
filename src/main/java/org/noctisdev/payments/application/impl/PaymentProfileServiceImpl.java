package org.noctisdev.payments.application.impl;

import org.noctisdev.payments.application.IPaymentProfileService;
import org.noctisdev.payments.application.dto.BaseResponse;
import org.noctisdev.payments.application.dto.request.PaymentProfileRequest;
import org.noctisdev.payments.application.dto.response.PaymentProfileResponse;
import org.noctisdev.payments.domain.models.PaymentProfile;
import org.noctisdev.payments.domain.repository.IPaymentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentProfileServiceImpl implements IPaymentProfileService {

    @Autowired
    private IPaymentProfileRepository repository;

    @Override
    public BaseResponse createPaymentProfile(PaymentProfileRequest request) {
        PaymentProfile paymentProfile = new PaymentProfile();
        paymentProfile.setPaymentProfileUuid(UUID.randomUUID());
        paymentProfile.setProfileName(request.profileName());
        paymentProfile.setAccountEmail(request.accountEmail());
        paymentProfile.setPhoneNumber(request.phoneNumber());

        repository.save(paymentProfile);

        PaymentProfileResponse response = new PaymentProfileResponse(
            paymentProfile.getPaymentProfileUuid(),
            paymentProfile.getProfileName(),
            paymentProfile.getAccountEmail()
        );

        return BaseResponse.builder()
            .data(response)
            .message("Payment profile created successfully")
            .success(Boolean.TRUE)
            .httpStatus(HttpStatus.OK)
            .status(200).build();
    }

    @Override
    public PaymentProfile findByUuid(UUID uuid) {
        return repository.findByUuid(uuid);
    }
}
