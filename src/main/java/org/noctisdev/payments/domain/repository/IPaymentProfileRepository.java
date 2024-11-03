package org.noctisdev.payments.domain.repository;

import org.noctisdev.payments.domain.models.PaymentProfile;

import java.util.UUID;

public interface IPaymentProfileRepository {
    PaymentProfile save(PaymentProfile paymentProfile);
    PaymentProfile findByUuid(UUID uuid);
}
