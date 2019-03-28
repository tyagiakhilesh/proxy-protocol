package com.akhilesh.learning;

import io.dropwizard.Configuration;

public class ApplicationConfiguration extends Configuration {
    // TODO: implement service configuration

    /*@Override
    public ServerFactory getServerFactory() {
        return new DefaultServerFactory() {
            @Override
            protected Server buildServer(LifecycleEnvironment lifecycle,
                                         ThreadPool threadPool) {
                Server server = super.buildServer(lifecycle, threadPool);
                if (server.getConnectors().length > 0) {
                    ((ServerConnector) (server.getConnectors()[0])).addFirstConnectionFactory(new ProxyConnectionFactory());
                }
                return server;
            }
        };
    }*/

}
