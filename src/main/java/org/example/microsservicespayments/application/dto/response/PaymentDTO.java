package org.example.microsservicespayments.application.dto.response;

import org.example.microsservicespayments.model.entitie.Payment;
import org.example.microsservicespayments.model.enums.Status;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentDTO(
        UUID paymentId,
        UUID correlationId,
        BigDecimal amount,
        Status status
) {
    public PaymentDTO(Payment payment) {
        this(payment.getPaymentId(), payment.getCorrelationId(), payment.getAmount(), payment.getStatus());
    }
}
