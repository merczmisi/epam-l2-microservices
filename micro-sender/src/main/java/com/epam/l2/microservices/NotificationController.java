package com.epam.l2.microservices;

import com.epam.l2.microservices.dto.NotificationRO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);
    @Autowired
    private MessageSender messageSender;

    @PostMapping("/notification")
    public void sendNotification(@RequestBody NotificationRO notificationRO) {
        LOGGER.info(String.format("Sending message... Sender: %s", notificationRO.getUser()));
        messageSender.send(notificationRO.getMessage());
    }
}
