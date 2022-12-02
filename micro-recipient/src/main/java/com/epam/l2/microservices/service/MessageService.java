package com.epam.l2.microservices.service;

import com.epam.l2.microservices.repository.MessageRepository;
import com.epam.l2.microservices.repository.model.MessageDTO;
import com.epam.l2.microservices.repository.model.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    private final MessageConverter messageConverter;

    @Autowired
    public MessageService(MessageRepository messageRepository, MessageConverter messageConverter) {
        this.messageRepository = messageRepository;
        this.messageConverter = messageConverter;
    }

    public void saveMessages(List<String> messages) {
        messageRepository.saveAll(messages.stream()
                .map(messageConverter::createMessageDO).collect(Collectors.toList()));
    }

    public MessageDTO getMessage() {
        MessageEntity messageEntity = messageRepository.findFirstByOrderByIdAsc();
        MessageDTO message = null;
        if (messageEntity != null) {
            message = new MessageDTO(messageEntity.getMessage());
            messageRepository.delete(messageEntity);
        }
        return message;
    }
}
