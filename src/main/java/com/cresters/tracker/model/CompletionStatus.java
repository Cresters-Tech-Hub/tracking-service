package com.cresters.tracker.model;

import lombok.Data;


public enum CompletionStatus {

    STARTED("started"),
    COMPLETED("completed"),
    CANCELED("canceled");

    String status;
    CompletionStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
