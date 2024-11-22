package org.noctisdev.payments.application;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import org.noctisdev.payments.application.dto.BaseResponse;
import org.noctisdev.payments.application.dto.request.PaymentProfileRequest;
import org.noctisdev.payments.domain.models.PaymentProfile;

import java.util.UUID;

public interface IPaymentProfileService {
    BaseResponse createPaymentProfile(PaymentProfileRequest request);
    BaseResponse completePaymentProfile(UUID uuid, String code) throws MPException, MPApiException;
    PaymentProfile findByUuid(UUID uuid);
}
