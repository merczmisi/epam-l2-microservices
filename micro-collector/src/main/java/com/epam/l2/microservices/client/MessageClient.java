package com.epam.l2.microservices.client;

import com.epam.l2.microservices.model.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "micro-service", url = "${micro.recipient.url}")
public interface MessageClient {
    @RequestMapping(method = RequestMethod.GET, value = "/message")
    MessageDTO getMessage();
}
