package org.noctisdev.payments.domain.repository;

import org.noctisdev.payments.domain.models.Payment;

public interface IPaymentRepository {
    Payment save(Payment payment);
}
