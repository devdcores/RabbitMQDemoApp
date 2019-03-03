package com.devd.rabbitmq.rabbitmqdemo.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQPublisherConfig {

    @Value("${exchange-name}")
    private String exchangeName;

    @Bean
    Exchange createExchange() {
        return ExchangeBuilder
                .topicExchange(exchangeName)
                .autoDelete()
                .durable(true)
                .build();
    }

}
