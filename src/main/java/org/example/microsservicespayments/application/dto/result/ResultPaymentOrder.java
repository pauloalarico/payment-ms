package org.example.microsservicespayments.application.dto.result;

import org.example.microsservicespayments.domain.enums.Status;

import java.math.BigDecimal;
import java.util.UUID;

public record ResultPaymentOrder(
        UUID paymentId,
        UUID correlationId,
        BigDecimal amount,
        Status status
) {
}
