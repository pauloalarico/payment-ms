package org.example.microsservicespayments.application.dto.response;

import java.time.ZonedDateTime;

public record CompletePaymentDTO(
        String message,
        ZonedDateTime date,
        PaymentDTO[] payments
) {
    public CompletePaymentDTO(PaymentDTO dto) {
        this("Complete request for: ", ZonedDateTime.now(), new PaymentDTO[] {dto});
    }
}
