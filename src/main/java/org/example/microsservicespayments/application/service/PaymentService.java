package org.example.microsservicespayments.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.microsservicespayments.application.dto.request.NewPaymentDTO;
import org.example.microsservicespayments.domain.entitie.Payment;
import org.example.microsservicespayments.infra.respository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;


    @Transactional
    public Payment createNewPayment(NewPaymentDTO dto) {
        if(!(dto.amount().doubleValue() > 0.0)) {
            throw new RuntimeException("Amount of payment cannot be less than 0");
        }
        if(repository.hasPaymentForId(dto.correlationId())) {
            throw new RuntimeException("Payment already realized");
        }
        var payment = new Payment(dto);
        if (Math.random() > 0.802) {
            payment.declineTransaction();
        }
        return repository.save(payment);
    }

    public Payment getPayment(String id) {
        return repository.findPaymentById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException(
                "Can not find the payment id."));
    }
}
