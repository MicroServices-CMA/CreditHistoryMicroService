package org.microservice.handlers;

import org.microservice.processings.HistoryProcessing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet implements HistoryProcessing
{
    public static Logger logMainServlet = LoggerFactory.getLogger(MainServlet.class.getSimpleName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            searchHistory(request, response);
        } catch (IOException ex) {
            logMainServlet.error("Error in doGet method execution. Msg: ",ex);
        }
    }

}

