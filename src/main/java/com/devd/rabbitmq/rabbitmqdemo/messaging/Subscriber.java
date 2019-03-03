package com.devd.rabbitmq.rabbitmqdemo.messaging;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class Subscriber implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("Received Message !!!");
        System.out.println("message = [" + new String(message.getBody()) + "]");
    }
}
