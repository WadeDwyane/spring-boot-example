package com.wadedwyane.www.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class Receiver5 {

    @RabbitHandler
    public void process(String content) {
        System.out.println("Receiver5 receive : " + content);
    }
}
