package org.microservice.handlers;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.microservice.Main;

import javax.servlet.http.HttpServletResponse;

public class MainServletTest {

    @Before
    public void setUp()
    {
        Main.runServer(8500, "/");
    }

    @Test
    public void doGetFound() throws Exception
    {
        String url = "http://localhost:8500/creditHistory?id=4";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        org.junit.Assert.assertEquals(HttpServletResponse.SC_OK, response.getStatusLine().getStatusCode());
    }

    @Test
    public void doGetNoFound() throws Exception
    {
        String url = "http://localhost:8500/creditHistory?id=81";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        org.junit.Assert.assertEquals(HttpServletResponse.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }

    @Test
    public void doGetBadRequest1() throws Exception
    {
        String url = "http://localhost:8500/creditHistory?id2=81";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        org.junit.Assert.assertEquals(HttpServletResponse.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }

    @Test
    public void doGetBadRequest2() throws Exception
    {
        String url = "http://localhost:8500/creditHistory?id=81sf";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        org.junit.Assert.assertEquals(HttpServletResponse.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }


    @After
    public void tearDown()
    {
        Main.stopServer();
    }

}