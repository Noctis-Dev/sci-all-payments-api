package org.noctisdev.payments.domain.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

@Getter @Setter
public class Payment {

    @NotNull
    private Long id;

    @NotBlank
    @UUID
    private java.util.UUID paymentUuid;

    @NotNull
    private Double amount;

    @NotBlank
    private String payerName;

    @NotBlank
    private String payerEmail;

    @NotBlank
    private String payerPhone;
    
    private PaymentProfile paymentProfile;
}
