package org.example.microsservicespayments.infra.messaging.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPayedQueueConfig {

    @Bean
    public Queue createOrdered() {
        return new Queue("orders-payed.queue", false);
    }

    @Bean
    public FanoutExchange createExchange() {
        return new FanoutExchange("orders-payed.ex");
    }

    @Bean
    public Binding createOrderBinding(FanoutExchange exchange) {
        return BindingBuilder.bind(createOrdered()).to(exchange);
    }
}
