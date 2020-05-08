package org.microservice.handlers;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.microservice.chi.HistoryRequester;
import org.microservice.model.Answer;
import org.microservice.model.History;
import org.microservice.model.Item;
import org.microservice.model.Request;
import org.microservice.utils.Common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException    {
        try {
            int clientId = Integer.parseInt(request.getParameterValues("id")[0]);
            HistoryRequester historyRequester = new HistoryRequester();
            List<History> histories = historyRequester.getHistory(clientId);
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            if(histories.size()==0){
                Answer answer = new Answer("Client's credit history is empty", null);
                response.getWriter().println(Common.getPrettyGson().toJson(answer));
            }
            else {

                Answer answer = new Answer("OK", histories);
                response.getWriter().println(Common.getPrettyGson().toJson(answer));
            }
        }
        catch(Exception e)
        {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            Answer answer = new Answer("Error: "+e.getMessage().toString(), null);
            response.getWriter().println(Common.getPrettyGson().toJson(answer));
        }
    }

}

