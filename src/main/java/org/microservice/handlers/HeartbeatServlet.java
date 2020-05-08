package org.microservice.handlers;

import org.microservice.chi.HistoryRequester;
import org.microservice.model.Answer;
import org.microservice.model.History;
import org.microservice.utils.Common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HeartbeatServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);
        Answer answer = new Answer("OK", null);
        resp.getWriter().println(Common.getPrettyGson().toJson(answer));
    }
}
