package org.example.microsservicespayments.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record NewPaymentDTO(
        @NotNull
        UUID correlationId,
        @NotNull
        @Positive
        BigDecimal amount
) {
}
