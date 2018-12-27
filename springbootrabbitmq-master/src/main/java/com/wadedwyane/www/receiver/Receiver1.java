package com.wadedwyane.www.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class Receiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1 receive : " + hello);
    }
}
