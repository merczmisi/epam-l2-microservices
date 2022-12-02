package com.epam.l2.microservices.service;

import com.epam.l2.microservices.model.MessageDTO;
import com.epam.l2.microservices.model.MessageEntity;
import com.epam.l2.microservices.model.mapper.MessageMapper;
import com.epam.l2.microservices.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageMapper messageMapper;

    public void saveMessage(MessageDTO messageDTO) {
        MessageEntity messageEntity = messageMapper.convert(messageDTO);
        messageRepository.save(messageEntity);
    }
}
