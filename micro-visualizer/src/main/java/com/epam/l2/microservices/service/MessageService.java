package com.epam.l2.microservices.service;

import com.epam.l2.microservices.model.MessageEntity;
import com.epam.l2.microservices.model.MessageVO;
import com.epam.l2.microservices.model.mapper.MessageMapper;
import com.epam.l2.microservices.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageMapper messageMapper;

    public List<MessageVO> getSavedMessages(){
        List<MessageEntity> messages = messageRepository.findAll();
        return messages.stream().map(messageMapper::convert).collect(Collectors.toList());
    }
}
