package com.wadedwyane.www.receiver;

import com.wadedwyane.www.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "user")
public class Receiver3 {

    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver3 user : " + user);
    }
}
