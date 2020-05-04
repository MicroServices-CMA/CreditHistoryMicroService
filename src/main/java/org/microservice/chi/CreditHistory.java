package org.microservice.chi;

import org.microservice.model.History;

import java.io.IOException;
import java.util.List;

public interface CreditHistory
{
    List<History> getHistory(int clientId) throws IOException;
}
