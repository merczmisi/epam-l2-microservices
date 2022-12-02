package com.epam.l2.microservices.model;

import java.util.Date;

public class MessageVO {
    private Date created;
    private String message;

    public MessageVO(Date created, String message) {
        this.created = created;
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
