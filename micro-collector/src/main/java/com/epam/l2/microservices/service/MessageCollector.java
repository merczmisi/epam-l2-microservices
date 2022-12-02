package com.epam.l2.microservices.service;


import com.epam.l2.microservices.client.MessageClient;
import com.epam.l2.microservices.model.MessageDTO;
import feign.RetryableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MessageCollector {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageCollector.class);

    @Autowired
    private MessageClient messageClient;
    @Autowired
    private MessageService messageService;

    @Scheduled(fixedDelayString = "${collect.fixedDelay}")
    public void collectMessages(){
        LOGGER.info("Collecting messages started");
        try {
            MessageDTO message = messageClient.getMessage();
            if (isNotNull(message) && isNotBlank(message)){
                LOGGER.info("new message: {}", message);
                messageService.saveMessage(message);
            }

        }catch (RetryableException exception){
            LOGGER.warn("Cannot reach message provider: {}", exception.getMessage());
        }catch (Exception exception){
            LOGGER.error("Cannot collect message: {}", exception.getMessage());
        }
    }

    private boolean isNotNull(MessageDTO message){
        return Objects.nonNull(message);
    }

    private boolean isNotBlank(MessageDTO message){
        return !message.getMessage().isBlank();
    }


}
