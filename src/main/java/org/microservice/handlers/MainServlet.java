package org.microservice.handlers;

import com.google.common.primitives.Ints;
import org.microservice.credithistory.HistoryRequester;
import org.microservice.model.Answer;
import org.microservice.model.History;
import org.microservice.utils.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet
{
    private static Logger logMainServlet = LoggerFactory.getLogger(MainServlet.class.getSimpleName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException    {
        response.setContentType("application/json");
        if (request != null) {
            String id = request.getParameter("id");
            if (id == null || Ints.tryParse(id)==null) {
                logMainServlet.error("Error on id, value not provided.");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(Common.getPrettyGson().toJson(
                        new Answer("BAD_HISTORY_REQUEST", "No id provided", null)));
                return;
            }
            try {
                int clientId = Integer.parseInt(id);
                HistoryRequester historyRequester = new HistoryRequester();
                List<History> histories = historyRequester.getHistory(clientId);
                if (histories.size()!=0) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.getWriter().println(Common.getPrettyGson().toJson(
                            new Answer("OK", "The request was successful", histories)));
                    logMainServlet.error("Object found. Provided id: " + id);
                } else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().println(Common.getPrettyGson().toJson(
                            new Answer("HISTORY_NOT_FOUND","Credit History Not Found", null)));
                    logMainServlet.error("Object not found. Provided id: " + id);
                }
            } catch (Exception e) {

                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().println(Common.getPrettyGson().toJson(
                        new Answer("INTERNAL_HISTORY_SERVER_ERROR","An internal Error occurred on server UsersMicroService", null)));
                logMainServlet.error("Error. " + e.getMessage());
            }
        } else {
            logMainServlet.error("Empty request.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println(Common.getPrettyGson().toJson(
                    new Answer("EMPTY_HISTORY_REQUEST", "The request provided was empty", null)));
        }
    }

}

