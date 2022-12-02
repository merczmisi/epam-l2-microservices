package com.epam.l2.microservices.model.mapper;

import com.epam.l2.microservices.model.MessageEntity;
import com.epam.l2.microservices.model.MessageVO;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public MessageVO convert(MessageEntity messageEntity){
        return new MessageVO(messageEntity.getCreated(), messageEntity.getMessage());
    }
}
