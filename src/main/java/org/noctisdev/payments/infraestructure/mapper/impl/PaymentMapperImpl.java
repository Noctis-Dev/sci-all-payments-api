package org.noctisdev.payments.infraestructure.mapper.impl;

import org.noctisdev.payments.domain.models.Payment;
import org.noctisdev.payments.infraestructure.entities.PaymentEntity;
import org.noctisdev.payments.infraestructure.mapper.IPaymentMapper;
import org.noctisdev.payments.infraestructure.mapper.IPaymentProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapperImpl implements IPaymentMapper {

    @Autowired
    private IPaymentProfileMapper paymentProfileMapper;

    @Override
    public Payment toDomain(PaymentEntity entity) {
        Payment payment = new Payment();

        payment.setId(entity.getId());
        payment.setPaymentUuid(entity.getPaymentUuid());
        payment.setAmount(entity.getAmount());
        payment.setPaymentProfile(paymentProfileMapper.toDomain(entity.getPaymentProfileEntity()));

        return payment;
    }

    @Override
    public PaymentEntity toEntity(Payment domain) {
        PaymentEntity entity = new PaymentEntity();

        entity.setId(domain.getId());
        entity.setPaymentUuid(domain.getPaymentUuid());
        entity.setAmount(domain.getAmount());
        entity.setPaymentProfileEntity(paymentProfileMapper.toEntity(domain.getPaymentProfile()));

        return entity;
    }
}
