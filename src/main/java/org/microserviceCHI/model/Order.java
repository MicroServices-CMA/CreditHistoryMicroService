package org.microserviceCHI.model;
import java.util.Date;

public class Order
{
    int id;
    int id_client;
    int id_bank;
    double sum;
    Date date;
    int time;

    public Order(int id, int id_client, int id_bank, double sum, Date date, int time)
    {
        this.id = id;
        this.id_client = id_client;
        this.id_bank = id_bank;
        this.sum = sum;
        this.date = date;
        this.time = time;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setIdClient(int id_client)
    {
        this.id_client = id_client;
    }

    public void setIdBank(int id_bank)
    {
        this.id_bank = id_bank;
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
        return id_client;
    }

    public int getIdBank()
    {
        return id_bank;
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
