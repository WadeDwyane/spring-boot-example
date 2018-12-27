package com.wadedwyane.www.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender2 {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendMessage(String content) {
        System.out.println("Sender2 send :" + content);
        amqpTemplate.convertAndSend("hello", content);
    }


}
