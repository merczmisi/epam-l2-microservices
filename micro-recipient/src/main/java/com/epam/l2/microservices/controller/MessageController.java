package com.epam.l2.microservices.controller;

import com.epam.l2.microservices.repository.model.MessageDTO;
import com.epam.l2.microservices.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class MessageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/message")
    @Transactional
    public MessageDTO getMessage(){
        LOGGER.info("Picking up a message");
        return messageService.getMessage();
    }
}
