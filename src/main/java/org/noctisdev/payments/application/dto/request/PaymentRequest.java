package org.noctisdev.payments.application.dto.request;

import java.util.UUID;

public record PaymentRequest(
    UUID paymentProfileId,
    Double amount
) { }
