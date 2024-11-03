package org.noctisdev.payments.application.dto.response;

import java.util.UUID;

public record PaymentProfileResponse(
    UUID paymentProfileUuid,
    String profileName,
    String accountEmail
) { }
