package org.microservice.processings;

import org.microservice.credithistory.HistoryRequester;
import org.microservice.model.Answer;
import org.microservice.model.History;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.microservice.handlers.MainServlet.logMainServlet;


public interface HistoryProcessing extends ResponseProcessing {

    default void searchHistory(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (request != null) {
            String id = request.getParameter("id");
            if (id == null || tryParse(id) == null) {
                logMainServlet.error("Error on id, value not provided or is of bad type. The received id: " + id);
                setRespParam(response, HttpServletResponse.SC_BAD_REQUEST, new Answer("BAD_HISTORY_REQUEST",
                        "No or bad id provided", null));
            } else {
                search(response, id);
            }
        } else {
            logMainServlet.error("Empty request.");
            setRespParam(response, HttpServletResponse.SC_BAD_REQUEST, new Answer("EMPTY_HISTORY_REQUEST",
                    "The request provided was empty", null));
        }
    }

    default void search(HttpServletResponse response, String id) throws IOException {
        try {
            int clientId = Integer.parseInt(id);
            HistoryRequester historyRequester = new HistoryRequester();
            List<History> histories = historyRequester.getHistory(clientId);
            logMainServlet.error("Object found. Provided id: " + id);
            setRespParam(response, HttpServletResponse.SC_OK, new Answer("OK", "The request was successful",
                    histories));
        } catch (Exception e) {
            setRespParam(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    new Answer("INTERNAL_HISTORY_SERVER_ERROR", "An internal Error occurred on CreditHistory server.",
                            null));
            logMainServlet.error("Error. " + e.getMessage());
        }
    }

    static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
