package com.akhilesh.learning;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.ProxyConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyServer {
    private Server server;

    public void start() throws Exception {
        server = new Server();
        //ServerConnector connector = new ServerConnector(server, new ProxyConnectionFactory(), new HttpConnectionFactory());
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(5002);

        server.setConnectors(new Connector[] {connector});

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(HelloServlet.class, "/hello");

        server.setHandler(handler);
        server.start();
    }
}
