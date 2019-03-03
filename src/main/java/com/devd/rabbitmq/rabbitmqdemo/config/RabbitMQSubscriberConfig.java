package com.devd.rabbitmq.rabbitmqdemo.config;

import com.devd.rabbitmq.rabbitmqdemo.messaging.Subscriber;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSubscriberConfig {

    @Value("${queue-name}")
    private String queueName;

    @Value("${routing-key-name}")
    private String routingKeyName;

    @Autowired
    Exchange exchange;

    @Autowired
    Subscriber subscriber;

    @Autowired
    ConnectionFactory connectionFactory;

    @Bean
    Queue createQueue(){
        return QueueBuilder.durable(queueName)
                .autoDelete()
                .build();
    }

    @Bean
    Binding createBinding(){
        return BindingBuilder.bind(createQueue())
                .to(exchange)
                .with(routingKeyName)
                .noargs();
    }

    @Bean
    MessageListenerContainer messageListenerContainer(){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setQueueNames(queueName);
        simpleMessageListenerContainer.setMessageListener(subscriber);
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        return simpleMessageListenerContainer;
    }
}
