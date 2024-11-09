package org.noctisdev.payments.application;

import org.noctisdev.payments.application.dto.BaseResponse;
import org.noctisdev.payments.application.dto.request.PaymentRequest;

public interface IPaymentService {
    BaseResponse getPayment(String email);
    BaseResponse generatePayment(PaymentRequest payment);
}
