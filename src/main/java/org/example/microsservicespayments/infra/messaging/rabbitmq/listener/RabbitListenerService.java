package org.example.microsservicespayments.infra.messaging.rabbitmq.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.microsservicespayments.application.dto.request.RegisterOrderPaymentDTO;
import org.example.microsservicespayments.application.usecase.ProcessPaymentCreatedUseCase;
import org.example.microsservicespayments.infra.messaging.rabbitmq.publisher.EventPublisherUseCase;
import org.example.microsservicespayments.utils.CommandMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitListenerService {
    private final ProcessPaymentCreatedUseCase process;
    private final EventPublisherUseCase publisher;

    @RabbitListener(queues = "payment-created.queue")
    public void realizePayment(RegisterOrderPaymentDTO dto) {
        var command = CommandMapper.buildToCommand(dto);
        var result = process.execute(command);
        publisher.publish(result);
    }
}
