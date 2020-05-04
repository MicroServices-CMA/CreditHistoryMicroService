package org.microservice.model;
import java.util.Date;

public class Repayment
{
    int id;
    int orderId;
    Date date;
    double sum;

    public Repayment(int id, int orderId, Date date, double sum)
    {
        this.id = id;
        this.orderId = orderId;
        this.date = date;
        this.sum = sum;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setIdOrder(int orderId)
    {
        this.orderId = orderId;
    }

    public void setSum(double sum)
    {
        this.sum = sum;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public int getId()
    {
        return id;
    }

    public int getIdOrder()
    {
        return orderId;
    }



    public double getSum() {
        return sum;
    }

    public Date getDate() {
        return date;
    }
}
