package com.ashok;

import com.ashok.guice.MyGuiceModule;
import com.ashok.health.DefaultCheck;
import com.ashok.resources.CounterResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.dropwizard.DropwizardExports;
import io.prometheus.client.exporter.MetricsServlet;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class MyApplication extends Application<MyAppConfig> {

    public static void main(final String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public String getName() {
        return "User Mgmt App";
    }

    @Override
    public void initialize(final Bootstrap<MyAppConfig> bootstrap) {
        GuiceBundle guiceBundle =  GuiceBundle.builder().
                modules(new MyGuiceModule()).build();
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(final MyAppConfig configuration,
                    final Environment environment) {
        final CounterResource counterResource = new CounterResource(configuration.getApplicationName());
        environment.jersey().register(counterResource);
        final DefaultCheck defaultCheck = new DefaultCheck();
        environment.healthChecks().register("default", defaultCheck);
        registerMetrics(environment);
    }

    private void registerMetrics(Environment environment) {
        CollectorRegistry collectorRegistry = new CollectorRegistry();
        collectorRegistry.register(new DropwizardExports(environment.metrics()));
        environment.admin().addServlet("metrics", new MetricsServlet(collectorRegistry))
                .addMapping("/metrics");
    }

}
