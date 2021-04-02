package com.okta.javakafka.model;

import java.io.Serializable;

public class CreateTeamResponse implements Serializable {

    private boolean successful = false;
    private String message;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
