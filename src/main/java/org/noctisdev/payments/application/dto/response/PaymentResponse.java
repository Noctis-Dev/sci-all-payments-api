package org.noctisdev.payments.application.dto.response;

import java.time.LocalDate;

public record PaymentResponse(
    String paymentUrl,
    LocalDate createdAt
) { }
