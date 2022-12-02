package com.epam.l2.microservices.controller;

import com.epam.l2.microservices.model.MessageVO;
import com.epam.l2.microservices.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/saved-messages")
    public List<MessageVO> getMessages(){
        LOGGER.info("Get all saved message query arrived");
        return messageService.getSavedMessages();
    }
}
