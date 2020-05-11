package org.microservice.model;

import java.util.List;

public class Answer
{
    private String status;
    private String details;
    private List<History> items;

    public Answer(String status, String details, List<History> items) {
        this.items = items;
        this.status = status;
        this.details = details;
    }

    public List<History> getItems() {
        return items;
    }

    public void setItems(List<History> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
