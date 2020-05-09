package org.microservice.model;

import java.util.List;

public class Answer<T>
{
    private String status;
    private String details;
    private List<T> items;

    public Answer(String status, String details, List<T> items) {
        this.items = items;
        this.status = status;
        this.details = details;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
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
