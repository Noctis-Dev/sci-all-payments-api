package org.noctisdev.payments.application;

import org.noctisdev.payments.application.dto.BaseResponse;
import org.noctisdev.payments.application.dto.request.PaymentProfileRequest;
import org.noctisdev.payments.domain.models.PaymentProfile;

import java.util.UUID;

public interface IPaymentProfileService {
    BaseResponse createPaymentProfile(PaymentProfileRequest request);
    PaymentProfile findByUuid(UUID uuid);
}
