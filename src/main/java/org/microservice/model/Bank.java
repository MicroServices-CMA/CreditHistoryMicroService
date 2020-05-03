package org.microservice.model;

public class Bank
{
    int id;
    String name;

    public Bank(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public void setId()
    {
        this.id = id;
    }

    public void setName()
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
}
