package com.wadedwyane.www.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender1 implements RabbitTemplate.ConfirmCallback {

    Logger logger = LoggerFactory.getLogger(Sender1.class);

    private RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    public Sender1(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String content) {
        System.out.println("Sender1 send :" + content);
        rabbitTemplate.convertAndSend("hello", content);
    }

    public void send() {
        String context = "Hello " + new Date();
        rabbitTemplate.convertAndSend("hello", context);
    }

    /**
     * 回调
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("回调ID: " + correlationData);
        if (ack) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + cause);
        }
    }
}
