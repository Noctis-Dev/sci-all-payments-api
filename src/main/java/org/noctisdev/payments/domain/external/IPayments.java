package org.noctisdev.payments.domain.external;

public interface IPayments {
    String generateDonationPaymentUrl(String to, Double amount);
}
