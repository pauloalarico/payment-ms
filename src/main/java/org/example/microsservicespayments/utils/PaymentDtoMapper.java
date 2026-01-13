package org.example.microsservicespayments.utils;

import org.example.microsservicespayments.dto.response.CompletePaymentDTO;
import org.example.microsservicespayments.dto.response.PaymentDTO;
import org.example.microsservicespayments.entitie.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentDtoMapper {
    public CompletePaymentDTO create(Payment payment) {
        var paymentDto = createPaymentDto(payment);
        return new CompletePaymentDTO(paymentDto);
    }

    public PaymentDTO createPaymentDto(Payment payment) {
        return new PaymentDTO(payment);
    }
}

