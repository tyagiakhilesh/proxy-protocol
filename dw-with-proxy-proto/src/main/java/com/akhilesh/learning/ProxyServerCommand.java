package com.akhilesh.learning;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.cli.EnvironmentCommand;
import io.dropwizard.setup.Environment;
import net.sourceforge.argparse4j.inf.Namespace;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.ProxyConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyServerCommand<T extends Configuration> extends EnvironmentCommand<T> {

    private final static Logger logger = LoggerFactory.getLogger(ProxyServerCommand.class);

    protected ProxyServerCommand(final Application<T> application, final String name, final String description) {
        super(application, name, description);
    }

    @Override
    protected void run(final Environment environment, final Namespace namespace, final T configuration) throws Exception {
        final Server server = configuration.getServerFactory().build(environment);
        try {
            server.addLifeCycleListener(new LifeCycleListener());
            cleanupAsynchronously();

            for (Connector connector : server.getConnectors()) {
                if (connector instanceof ServerConnector) {
                    ServerConnector serverConnector = (ServerConnector) connector;
                    logger.info("proxy protocol parsing enabled on {} port {}", serverConnector.getName(), serverConnector.getLocalPort());
                    serverConnector.addFirstConnectionFactory(new ProxyConnectionFactory());
                }
            }

            server.start();
        } catch (Exception e) {
            server.stop();
            cleanup();
        }
    }

    private class LifeCycleListener extends AbstractLifeCycle.AbstractLifeCycleListener {
        @Override
        public void lifeCycleStopped(LifeCycle event) {
            cleanup();
        }
    }
}
