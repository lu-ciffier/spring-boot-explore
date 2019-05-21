package com.lucifer.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfig.QUEUE)
public class LuciferListener {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver  : " + message);
    }
}
