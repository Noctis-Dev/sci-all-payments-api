package org.noctisdev.payments.domain.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class PaymentProfile {
    private Long id;

    @NotNull
    @org.hibernate.validator.constraints.UUID
    private UUID paymentProfileUuid;

    @NotBlank
    private String profileName;

    @NotBlank
    private String accountEmail;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String oauthUrl;

    @NotBlank
    private String oauthToken;
}
