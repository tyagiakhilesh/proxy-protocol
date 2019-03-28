package com.akhilesh.learning;

import com.akhilesh.learning.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ApplicationApplication extends Application<ApplicationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ApplicationApplication().run(args);
    }

    @Override
    public String getName() {
        return "Application";
    }

    @Override
    public void initialize(final Bootstrap<ApplicationConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ApplicationConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new HelloResource());
    }

}
