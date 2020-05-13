package org.microservice;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.microservice.handlers.HeartbeatServlet;
import org.microservice.handlers.MainServlet;
import org.microservice.utils.Common;
import org.microservice.utils.PropertyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    private static Logger logMain = LoggerFactory.getLogger(Main.class.getSimpleName());

    private static Server server;

    public static void main(String[] args) throws Exception
    {

        PropertyManager.load();
        Common.configure();
        runServer();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {

                stopServer();

            }
        },"Stop Jetty Hook"));

    }


    public static void runServer(int port, String contextStr)
    {
        server = new Server(port);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath(contextStr);
        server.setHandler(context);

        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        handler.addServletWithMapping(MainServlet.class, "/creditHistory");
        handler.addServletWithMapping(HeartbeatServlet.class, "/heart");
        try
        {
            server.start();
            logMain.error("Server has started at port: " + port);
        }catch(Throwable t){
            logMain.error("Error while starting server", t);
        }
    }

    private static void runServer() {
        int port = PropertyManager.getPropertyAsInteger("server.port", 8500);
        String contextStr = PropertyManager.getPropertyAsString("server.context", "/");

        runServer(port, contextStr);
    }

    public static void stopServer() {
        try {
            if(server.isRunning()){
                server.stop();
            }
        } catch (Exception e) {
            logMain.error("Error while stopping server", e);
        }
    }

}
