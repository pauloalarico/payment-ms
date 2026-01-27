package org.example.microsservicespayments.utils;

import org.example.microsservicespayments.application.dto.request.RegisterOrderPaymentDTO;

public class CommandMapper {
    public static org.example.microsservicespayments.application.dto.command.RegisterOrderPayment buildToCommand(RegisterOrderPaymentDTO dto) {
        return new org.example.microsservicespayments.application.dto.command.RegisterOrderPayment(dto);
    }
}
