package org.example.microsservicespayments.application.usecase;

import org.example.microsservicespayments.application.dto.command.RegisterOrderPayment;
import org.example.microsservicespayments.application.dto.result.ResultPaymentOrder;

public interface ProcessPaymentCreatedUseCase {
    ResultPaymentOrder execute(RegisterOrderPayment command);
}
