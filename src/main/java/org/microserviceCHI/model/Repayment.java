package org.microserviceCHI.model;
import java.util.Date;

public class Repayment
{
    int id;
    int id_order;
    Date date;
    double sum;

    public Repayment(int id, int id_order, Date date, double sum)
    {
        this.id = id;
        this.id_order = id_order;
        this.date = date;
        this.sum = sum;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setIdOrder(int id_order)
    {
        this.id_order = id_order;
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
        return id_order;
    }



    public double getSum() {
        return sum;
    }

    public Date getDate() {
        return date;
    }
}
