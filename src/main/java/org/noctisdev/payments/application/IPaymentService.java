package org.noctisdev.payments.application;

import org.noctisdev.payments.application.dto.BaseResponse;
import org.noctisdev.payments.application.dto.request.PaymentRequest;

public interface IPaymentService {
    BaseResponse generatePayment(PaymentRequest payment);
}
