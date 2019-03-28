package com.akhilesh.learning;

import io.dropwizard.lifecycle.setup.LifecycleEnvironment;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.server.ServerFactory;
import org.eclipse.jetty.server.ProxyConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.ThreadPool;

public class ProxyProtocolEnabledServerFactory extends DefaultServerFactory {

    @Override
    protected Server buildServer(LifecycleEnvironment lifecycle,
                                 ThreadPool threadPool) {
        Server server = super.buildServer(lifecycle, threadPool);
        ((ServerConnector)(server.getConnectors()[0])).addFirstConnectionFactory(new ProxyConnectionFactory());
        return server;
    }
}
