package com.epam.l2.microservices.service;

import com.epam.l2.microservices.repository.model.MessageEntity;
import org.springframework.stereotype.Component;

@Component
public class MessageConverter {
    public MessageEntity createMessageDO(String message) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage(message);
        return messageEntity;
    }
}
