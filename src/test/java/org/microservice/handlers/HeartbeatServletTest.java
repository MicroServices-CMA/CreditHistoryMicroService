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

public class HeartbeatServletTest {
    @Before
    public void init()
    {
        Main.runServer(8500, "/");
    }

    @Test
    public void doGet() throws Exception
    {
        String url = "http://localhost:8500/heart";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        org.junit.Assert.assertEquals(HttpServletResponse.SC_OK, response.getStatusLine().getStatusCode());
    }

    @After
    public void entTest()
    {
        Main.stopServer();
    }
}