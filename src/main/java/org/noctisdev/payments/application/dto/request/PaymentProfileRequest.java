package org.noctisdev.payments.application.dto.request;

public record PaymentProfileRequest(
    String profileName,
    String accountEmail
) { }
