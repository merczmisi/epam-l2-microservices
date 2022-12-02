package com.epam.l2.microservices.model.mapper;

import com.epam.l2.microservices.model.MessageDTO;
import com.epam.l2.microservices.model.MessageEntity;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public MessageEntity convert(MessageDTO dto) {
        return new MessageEntity(dto.getMessage());
    }
}
