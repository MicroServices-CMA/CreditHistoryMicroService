package org.microservice.handlers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.microservice.Main;
import org.microservice.model.Answer;
import org.microservice.model.History;
import org.microservice.utils.Common;

import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

public class MainServletTest {

    @Before
    public void init()
    {
        Main.runServer(8500, "/");
    }

    @Test
    public void doGetFound() throws Exception
    {
        String url = "http://localhost:8500/creditHistory?id=1";
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
        org.junit.Assert.assertEquals(HttpServletResponse.SC_NO_CONTENT, response.getStatusLine().getStatusCode());
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
    public void entTest()
    {
        Main.stopServer();
    }

}