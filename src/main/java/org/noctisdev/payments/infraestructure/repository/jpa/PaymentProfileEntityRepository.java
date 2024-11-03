package org.noctisdev.payments.infraestructure.repository.jpa;

import org.noctisdev.payments.infraestructure.entities.PaymentProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentProfileEntityRepository extends JpaRepository<PaymentProfileEntity, Long> {
    Optional<PaymentProfileEntity> findByPaymentProfileUuid(UUID paymentProfileUuid);
}