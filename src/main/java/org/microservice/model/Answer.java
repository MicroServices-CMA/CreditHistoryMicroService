package org.microservice.model;

import java.util.List;

public class Answer
{
    private String status;
    private List<History> histories;

    public Answer(String status, List<History> histories)
    {
        this.status = status;
        this.histories = histories;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public List<History> getItems()
    {
        return histories;
    }

    public void setItems(List<History> items)
    {
        this.histories = items;
    }
}
