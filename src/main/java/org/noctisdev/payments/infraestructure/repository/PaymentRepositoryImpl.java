package org.noctisdev.payments.infraestructure.repository;

import org.noctisdev.payments.domain.models.Payment;
import org.noctisdev.payments.domain.repository.IPaymentRepository;
import org.noctisdev.payments.infraestructure.mapper.IPaymentMapper;
import org.noctisdev.payments.infraestructure.repository.jpa.PaymentEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentRepositoryImpl implements IPaymentRepository {

    @Autowired
    private PaymentEntityRepository jpaRepository;

    @Autowired
    private IPaymentMapper mapper;

    @Override
    public Payment save(Payment payment) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(payment)));
    }
}
