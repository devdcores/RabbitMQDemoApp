package com.devd.rabbitmq.rabbitmqdemo.messaging;

import com.devd.rabbitmq.rabbitmqdemo.model.SimpleMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Value("${exchange-name}")
    private String exchangeName;

    @Value("${routing-key-name}")
    private String routingKeyName;

    @Autowired
    RabbitTemplate rabbitTemplate;

    private Long count = 0L;

    @Scheduled(fixedDelay = 2000, initialDelay = 5000)
    public void publish(){
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setName("MessageNameWithId : "+count);
        simpleMessage.setDescription("MessageDescriptionId : "+count);

        System.out.println("Publishing Message !!!");
        rabbitTemplate.convertAndSend(exchangeName, routingKeyName, simpleMessage);
        count++;
    }
}
