package org.example.microsservicespayments.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.microsservicespayments.application.dto.request.RegisterOrderPaymentDTO;
import org.example.microsservicespayments.application.dto.response.CompletePaymentDTO;
import org.example.microsservicespayments.application.dto.response.PaymentDTO;
import org.example.microsservicespayments.application.service.PaymentService;
import org.example.microsservicespayments.utils.PaymentDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentDtoMapper paymentDtoMapper;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPayment(@PathVariable String id) {
        var payment = paymentService.getPayment(id);
        return ResponseEntity.ok(paymentDtoMapper.createPaymentDto(payment));
    }
}
