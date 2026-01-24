package org.example.microsservicespayments.application.dto.response;

import org.example.microsservicespayments.domain.entitie.Payment;
import org.example.microsservicespayments.domain.enums.Status;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentDTO(
        UUID paymentId,
        UUID orderId,
        BigDecimal amount,
        Status status
) {
    public PaymentDTO(Payment payment) {
        this(payment.getPaymentId(), payment.getOrderId(), payment.getAmount(), payment.getStatus());
    }
}
