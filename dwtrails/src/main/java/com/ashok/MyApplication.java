package com.ashok;

import com.ashok.health.DefaultCheck;
import com.ashok.resources.CounterResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyApplication extends Application<MyAppConfig> {

    public static void main(final String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public String getName() {
        return "Dropwizard Trails";
    }

    @Override
    public void initialize(final Bootstrap<MyAppConfig> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final MyAppConfig configuration,
                    final Environment environment) {
        final CounterResource counterResource = new CounterResource(configuration.getApplicationName());
        environment.jersey().register(counterResource);
        final DefaultCheck defaultCheck = new DefaultCheck();
        environment.healthChecks().register("default", defaultCheck);
    }

}
