package com.epam.l2.microservices.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class QueueDeclaration {
    private final static Logger LOGGER = LoggerFactory.getLogger(QueueDeclaration.class);

    @Value("${queue.name}")
    private String queueName;
    @Value("${spring.rabbitmq.connection-try}")
    private int connectionTry;

    private final AmqpAdmin amqpAdmin;

    public QueueDeclaration(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    @PostConstruct
    public void declareQueue() throws InterruptedException {
        boolean connectTry = true;
        int count = 0;
        while (connectTry) {
            try {
                LOGGER.info("Try to connect to rabbitmq");
                tryToConnect();
                connectTry = false;
            } catch (AmqpConnectException amqpConnectException) {
                LOGGER.warn("Connect Rabbitmq {}/{} try failed: {}", count + 1, connectionTry, amqpConnectException.getMessage());
                count++;
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception exception) {
                LOGGER.error("Cannot connect to rabbitmq: {}", exception.getMessage());
            }

            if (count == connectionTry) connectTry = false;
        }
    }

    public void tryToConnect() {
        amqpAdmin.declareQueue(new Queue(queueName, true));
    }
}
