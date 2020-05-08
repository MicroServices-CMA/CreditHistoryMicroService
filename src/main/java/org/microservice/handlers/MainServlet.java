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
      /*  try {
            int clientId = Integer.parseInt(request.getParameterValues("id")[0]);
            HistoryRequester historyRequester = new HistoryRequester();
            List<History> histories = historyRequester.getHistory(clientId);
            response.setContentType("application/json");

            if(histories.size()==0){
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
              //  Answer answer = new Answer("Client's credit history is empty", null);
                response.getWriter().println(Common.getPrettyGson().toJson(null));
            }
            else {
                response.setStatus(HttpServletResponse.SC_FOUND);
             //   Answer answer = new Answer("OK", histories);
                response.getWriter().println(Common.getPrettyGson().toJson(histories));
            }
        }
        catch(Exception e)
        {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
         //   Answer answer = new Answer("Error: "+e.getMessage().toString(), null);
            response.getWriter().println(Common.getPrettyGson().toJson(null));
        }*/

        if (request != null) {
         //   String id;
            String id = request.getParameter("id");
            if (id == null) {
             //   Main.getLog().error("Error on clientId, value not provided.");
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
               //     Main.getLog().error("Object found. Provided id: " + id);
                } else {
                    response.setContentType("application/json");
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().println(Common.getPrettyGson().toJson("{ 'details' : 'History Not found' }"));
                //    Main.getLog().error("Object not found. Provided id: " + id);
                }
            } catch (Exception e) {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().println(Common.getPrettyGson().toJson("{ 'details': 'Internal Error in History Client Server.' }"));
         //       Main.getLog().error("Error. " + e.getMessage());
            }
        } else {
        //    Main.getLog().error("Empty request.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println(Common.getPrettyGson().toJson("{ 'details' : 'Bad request' }"));
        }
    }

}

