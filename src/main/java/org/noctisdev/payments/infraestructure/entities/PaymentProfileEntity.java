package org.noctisdev.payments.infraestructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "payment_profiles")
public class PaymentProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_profile_id", nullable = false)
    private Long id;

    @Size(max = 36)
    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "payment_profile_uuid", nullable = false, length = 36)
    private UUID paymentProfileUuid;

    @Size(max = 100)
    @NotNull
    @Column(name = "profile_name", nullable = false, length = 100)
    private String profileName;

    @Size(max = 100)
    @NotNull
    @Column(name = "account_email", nullable = false, length = 100)
    private String accountEmail;

}