package org.example.microsservicespayments.infra.messaging.rabbitmq.publisher;

import lombok.RequiredArgsConstructor;
import org.example.microsservicespayments.application.dto.result.ResultPaymentOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventPublisherService implements EventPublisherUseCase {
    private final RabbitTemplate rabbitTemplate;
    private final static String PAYMENT_EX = "orders-payed.ex";

    @Override
    public void publish(ResultPaymentOrder result) {
        rabbitTemplate.convertAndSend(PAYMENT_EX, "", result);
    }
}
