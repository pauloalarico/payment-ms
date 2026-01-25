package org.example.microsservicespayments.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.microsservicespayments.application.dto.request.NewPaymentDTO;
import org.example.microsservicespayments.application.dto.response.PaymentDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitListenerService {
    private final PaymentService service;
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "payment-created.queue")
    public void realizePayment(NewPaymentDTO dto) {
        var payment = service.createNewPayment(dto);
        var paymentDto = new PaymentDTO(payment);
        rabbitTemplate.convertAndSend("orders-payed.ex", "", paymentDto);
        log.info("Message sent to correlationId: {}, and paymentId: {}", paymentDto.correlationId(),
                paymentDto.paymentId());
    }
}
