package org.noctisdev.payments.domain.repository;

import org.noctisdev.payments.domain.models.Payment;

import java.util.List;

public interface IPaymentRepository {
    Payment save(Payment payment);
    List<Payment> findByEmail(String email);
}
