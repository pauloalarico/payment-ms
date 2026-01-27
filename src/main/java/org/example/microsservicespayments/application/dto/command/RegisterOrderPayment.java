package org.example.microsservicespayments.application.dto.command;

import org.example.microsservicespayments.application.dto.request.RegisterOrderPaymentDTO;

import java.math.BigDecimal;
import java.util.UUID;

public record RegisterOrderPayment(
        UUID correlationId,
        BigDecimal amount
) {
    public RegisterOrderPayment(RegisterOrderPaymentDTO dto) {
        this(dto.correlationId(), dto.amount());
    }
}
