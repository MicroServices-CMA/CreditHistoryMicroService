package org.microservice.model;
import java.util.Date;

public class Order
{
    int id;
    int clientId;
    int bankId;
    double sum;
    Date date;
    int time;

    public Order(int id, int clientId, int bankId, double sum, Date date, int time)
    {
        this.id = id;
        this.clientId = clientId;
        this.bankId = bankId;
        this.sum = sum;
        this.date = date;
        this.time = time;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setIdClient(int clientId)
    {
        this.clientId = clientId;
    }

    public void setIdBank(int bankId)
    {
        this.bankId = bankId;
    }

    public void setSum(double sum)
    {
        this.sum = sum;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    public int getId()
    {
        return id;
    }

    public int getIdClient()
    {
        return clientId;
    }

    public int getIdBank()
    {
        return bankId;
    }

    public double getSum()
    {
        return sum;
    }
    public Date getDate()
    {
        return date;
    }

    public int getTime()
    {
        return time;
    }
}
