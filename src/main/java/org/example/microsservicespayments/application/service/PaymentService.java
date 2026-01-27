package org.example.microsservicespayments.application.service;

import lombok.RequiredArgsConstructor;
import org.example.microsservicespayments.domain.entitie.Payment;
import org.example.microsservicespayments.infra.respository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;

    public Payment getPayment(String id) {
        return repository.findPaymentById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException(
                "Can not find the payment id."));
    }
}
