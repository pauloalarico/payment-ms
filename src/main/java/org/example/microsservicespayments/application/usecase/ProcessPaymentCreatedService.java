package org.example.microsservicespayments.application.usecase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.microsservicespayments.application.dto.command.RegisterOrderPayment;
import org.example.microsservicespayments.application.dto.result.ResultPaymentOrder;
import org.example.microsservicespayments.domain.entitie.Payment;
import org.example.microsservicespayments.infra.respository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ProcessPaymentCreatedService implements ProcessPaymentCreatedUseCase {

    private final PaymentRepository repository;

    @Override
    public ResultPaymentOrder execute(RegisterOrderPayment command) {
        if(!(command.amount().doubleValue() > 0.0)) {
            throw new RuntimeException("Amount of payment cannot be less than 0");
        }
        if(repository.hasPaymentForId(command.correlationId())) {
            throw new RuntimeException("Payment already realized");
        }
        var payment = new Payment(command);
        if (Math.random() > 0.802) {
            payment.declineTransaction();
        }
        repository.save(payment);
        return new ResultPaymentOrder(
                payment.getPaymentId(),
                payment.getCorrelationId(),
                payment.getAmount(),
                payment.getStatus()
        );
    }
}
