package org.microservice.handlers;

import org.microservice.model.Answer;
import org.microservice.processings.ResponseProcessing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeartbeatServlet extends HttpServlet implements ResponseProcessing {

    private static Logger logHeartbeatServlet = LoggerFactory.getLogger(HeartbeatServlet.class.getSimpleName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            setRespParam(resp, HttpServletResponse.SC_OK, new Answer("OK", null, null)
            );
        } catch (Exception e) {
            logHeartbeatServlet.error("Error. " + e.getMessage());
        }
    }
}
