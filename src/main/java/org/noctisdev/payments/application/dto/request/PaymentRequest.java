package org.noctisdev.payments.application.dto.request;

import org.noctisdev.payments.domain.events.EventType;

import java.util.UUID;

public record PaymentRequest(
    EventType notifyChannel,
    String payerName,
    String payerEmail,
    String payerPhoneNumber,
    UUID paymentProfileId,
    Double amount
) { }
