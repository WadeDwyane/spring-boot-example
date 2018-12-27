package com.wadedwyane.www.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    AmqpTemplate template;

    public void send() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        template.convertAndSend("fanoutExchange", "", context);
    }
}
