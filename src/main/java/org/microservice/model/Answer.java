package org.microservice.model;

import java.util.List;

public class Answer<T>
{
    private List<T> items;

    public Answer(String status, List<T> histories)
    {
        this.items = histories;
    }

    public List<T> getItems()
    {
        return items;
    }

    public void setItems(List<T> items)
    {
        this.items = items;
    }
}
