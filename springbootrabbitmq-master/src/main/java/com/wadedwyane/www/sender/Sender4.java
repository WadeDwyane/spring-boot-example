package com.wadedwyane.www.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender4 {

    @Autowired
    AmqpTemplate template;

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        template.convertAndSend("exchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        template.convertAndSend("exchange", "topic.messages", context);
    }

}
