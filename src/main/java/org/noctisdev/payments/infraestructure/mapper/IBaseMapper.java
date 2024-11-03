package org.noctisdev.payments.infraestructure.mapper;

public interface IBaseMapper <D, E> {
    D toDomain(E entity);
    E toEntity(D domain);
}
