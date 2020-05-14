package org.microservice.model;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryTest {

    @Test
    public void setOrderId() throws ParseException {
        Date date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( "12.12.2020" );
        List<Pay> pays = new ArrayList<Pay>();
        History history = new History(1, "Bank1", 3000000, date,  12, pays, 1000);
        history.setOrderId(3);
        org.junit.Assert.assertEquals(3, history.getOrderId());
    }

    @Test
    public void setNameBank() throws ParseException {
        Date date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( "12.12.2020" );
        List<Pay> pays = new ArrayList<Pay>();
        History history = new History(1, "Bank1", 3000000, date,  12, pays, 1000);
        history.setNameBank("Bank2");
        org.junit.Assert.assertEquals("Bank2", history.getNameBank());
    }
    @Test
    public void setSum() throws ParseException {
        Date date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( "12.12.2020" );
        List<Pay> pays = new ArrayList<Pay>();
        History history = new History(1, "Bank1", 3000000, date,  12, pays, 1000);
        history.setSum(10);
        org.junit.Assert.assertEquals(10, history.getSum(), 0.001);
    }

    @Test
    public void setDate() throws ParseException {
        Date date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( "12.12.2020" );
        List<Pay> pays = new ArrayList<Pay>();
        History history = new History(1, "Bank1", 3000000, date,  12, pays, 1000);
        Date date2 = new SimpleDateFormat( "dd.MM.yyyy" ).parse( "27.12.2020" );
        history.setDate(date2);
        org.junit.Assert.assertEquals(date2, history.getDate());
    }

    @Test
    public void setTime() throws ParseException {
        Date date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( "12.12.2020" );
        List<Pay> pays = new ArrayList<Pay>();
        History history = new History(1, "Bank1", 3000000, date,  12, pays, 1000);
        history.setTime(11);
        org.junit.Assert.assertEquals(11, history.getTime());
    }

    @Test
    public void setPays() throws ParseException {
        Date date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( "12.12.2020" );
        List<Pay> pays = new ArrayList<Pay>();
        History history = new History(1, "Bank1", 3000000, date,  12, pays, 1000);
        List<Pay> pays2 = new ArrayList<Pay>();
        pays2.add(new Pay(date, 10));
        history.setPays(pays2);
        org.junit.Assert.assertEquals(pays2, history.getPays());
    }

    @Test
    public void setDebt() throws ParseException {
            Date date = new SimpleDateFormat( "dd.MM.yyyy" ).parse( "12.12.2020" );
            List<Pay> pays = new ArrayList<Pay>();
            History history = new History(1, "Bank1", 3000000, date,  12, pays, 1000);
            history.setDebt(20);
            org.junit.Assert.assertEquals(20, history.getDebt(), 0.001);
    }
}