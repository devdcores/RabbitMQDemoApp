package com.devd.rabbitmq.rabbitmqdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMQDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQDemoApplication.class, args);
    }
}

