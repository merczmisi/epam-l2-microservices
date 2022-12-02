package com.epam.l2.microservices.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueueConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueConsumer.class);

    @Value("${queue.name}")
    private String queueName;

    private final RabbitTemplate rabbitTemplate;
    private final MessageService messageService;

    public QueueConsumer(RabbitTemplate rabbitTemplate, MessageService messageService) {
        this.rabbitTemplate = rabbitTemplate;
        this.messageService = messageService;
    }

    @Scheduled(fixedDelayString = "${schedule.fixedDelay}")
    public void collectMessages() {
        LOGGER.debug("Message check starts");
        List<String> messages = new ArrayList<>();
        try {

            String message = getMessageFromQueue();
            while (message != null) {
                LOGGER.info("Message arrived [{}]", message);
                messages.add(message);
                message = getMessageFromQueue();
            }

            if (!messages.isEmpty()) {
                LOGGER.info("Collected all messages");
                messageService.saveMessages(messages);
            }

        } catch (AmqpException exception) {
            LOGGER.warn("Connection error: {}", exception.getMessage());
        }
    }

    public String getMessageFromQueue() {
        return (String) rabbitTemplate.receiveAndConvert(queueName);
    }
}
