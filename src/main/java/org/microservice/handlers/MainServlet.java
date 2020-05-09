package org.microservice.handlers;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.microservice.Main;
import org.microservice.chi.HistoryRequester;
import org.microservice.model.Answer;
import org.microservice.model.History;
import org.microservice.model.Item;
import org.microservice.model.Request;
import org.microservice.utils.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainServlet extends HttpServlet
{
    private static Logger logMainServlet = LoggerFactory.getLogger(MainServlet.class.getSimpleName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException    {
        if (request != null) {
            String id = request.getParameter("id");
            if (id == null) {
                logMainServlet.error("Error on id, value not provided.");
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(Common.getPrettyGson().toJson("{ 'details' : 'Bad request' }"));

                return;
            }
            try {
                int clientId = Integer.parseInt(id);
                HistoryRequester historyRequester = new HistoryRequester();
                List<History> histories = historyRequester.getHistory(clientId);
                if (histories.size()!=0) {
                    response.setContentType("application/json");
                    response.setStatus(HttpServletResponse.SC_FOUND);
                    response.getWriter().println(Common.getPrettyGson().toJson(histories));
                    logMainServlet.error("Object found. Provided id: " + id);
                } else {
                    response.setContentType("application/json");
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().println(Common.getPrettyGson().toJson("{ 'details' : 'History Not found' }"));
                    logMainServlet.error("Object not found. Provided id: " + id);
                }
            } catch (Exception e) {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().println(Common.getPrettyGson().toJson("{ 'details': 'Internal Error in History Client Server.' }"));
                logMainServlet.error("Error. " + e.getMessage());
            }
        } else {
            logMainServlet.error("Empty request.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println(Common.getPrettyGson().toJson("{ 'details' : 'Bad request' }"));
        }
    }

}

