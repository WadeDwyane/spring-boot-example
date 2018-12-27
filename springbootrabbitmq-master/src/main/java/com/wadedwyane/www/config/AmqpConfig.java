package com.wadedwyane.www.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

    public static final String MESSAGE = "topic.message";
    public static final String MESSAGES = "topic.messages";
    public static final String TOPIC = "topic.#";

    @Bean
    public Queue helloQueue() {
        return new Queue("hello", true);
    }

    @Bean
    public Queue userQueue() {
        return new Queue("user", true);
    }

    @Bean
    public Queue messageQueue() {
        return new Queue(MESSAGE, true);
    }

    @Bean
    public Queue messagesQueue() {
        return new Queue(MESSAGES, true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    public Binding bindingExchangeMessage(Queue messageQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(messageQueue).to(topicExchange).with(MESSAGE);
    }

    @Bean
    public Binding bindingExchangeMessages(Queue messagesQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(messagesQueue).to(topicExchange).with(TOPIC);
    }

    @Bean
    public Queue AQueue() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BQueue() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CQueue() {
        return new Queue("fanout.C");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue AQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AQueue).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BQueue).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CQueue).to(fanoutExchange);
    }


}
