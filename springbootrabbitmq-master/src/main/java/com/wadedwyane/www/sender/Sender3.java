package com.wadedwyane.www.sender;

import com.wadedwyane.www.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender3 {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendUser(User user) {
        System.out.println("Sender object: " + user.toString());
        amqpTemplate.convertAndSend("user", user);
    }


}
