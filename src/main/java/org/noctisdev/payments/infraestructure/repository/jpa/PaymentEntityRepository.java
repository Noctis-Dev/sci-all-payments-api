package org.noctisdev.payments.infraestructure.repository.jpa;

import org.noctisdev.payments.infraestructure.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentEntityRepository extends JpaRepository<PaymentEntity, Long> {

    List<PaymentEntity> findByPayerEmail(String email);

}