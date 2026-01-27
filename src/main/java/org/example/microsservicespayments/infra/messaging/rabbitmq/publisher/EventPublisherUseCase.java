package org.example.microsservicespayments.infra.messaging.rabbitmq.publisher;

import org.example.microsservicespayments.application.dto.result.ResultPaymentOrder;

public interface EventPublisherUseCase {
    void publish(ResultPaymentOrder result);
}
