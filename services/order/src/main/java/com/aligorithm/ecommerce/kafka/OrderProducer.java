package com.aligorithm.ecommerce.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class OrderProducer {

    private final KafkaTemplate<String,OrderConfirmation> kafkaTemplate;
    private static final Logger log = LoggerFactory.getLogger(OrderProducer.class);
    public OrderProducer(KafkaTemplate<String, OrderConfirmation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderConfirmation(OrderConfirmation orderConfirmation) {
        log.info("Sending order confirmation");
        Message<OrderConfirmation> message = MessageBuilder
                .withPayload(orderConfirmation)
                .setHeader(KafkaHeaders.TOPIC,"order-topic")
                .build();
        kafkaTemplate.send(message);
    }

}
