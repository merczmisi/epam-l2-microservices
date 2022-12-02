package com.epam.l2.microservices.repository;

import com.epam.l2.microservices.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

}
