package com.dropwizard.gameauth;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dropwizard.gameauth.auth.GameAuthenticator;
import com.dropwizard.gameauth.auth.GameAuthorizer;
import com.dropwizard.gameauth.auth.GameUser;
import com.dropwizard.gameauth.controller.GameUserRESTController;
import com.dropwizard.gameauth.controller.RESTClientController;
import com.dropwizard.gameauth.healthcheck.AppHealthCheck;
import com.dropwizard.gameauth.healthcheck.HealthCheckController;

public class GameAuthApplication extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameAuthApplication.class);

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        // Initialize application settings if needed
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        LOGGER.info("Registering REST resources");

        // Create a JerseyClientBuilder instance and give it the environment reference
        Client demoRESTClient = new JerseyClientBuilder(environment).build("DemoRESTClient");

        // Register GameUserRESTController with a validator from the environment
        environment.jersey().register(new GameUserRESTController(environment.getValidator()));

        // Register RESTClientController with the created client (using demoRESTClient variable)
        environment.jersey().register(new RESTClientController(demoRESTClient));

        // Application health check
        environment.healthChecks().register("APIHealthCheck", new AppHealthCheck(demoRESTClient));

        // Register HealthCheckController
        environment.jersey().register(new HealthCheckController(environment.healthChecks()));

        // Setup Basic Security
        environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<GameUser>()
                .setAuthenticator(new GameAuthenticator())
                .setAuthorizer(new GameAuthorizer())
                .setRealm("App Security")
                .buildAuthFilter()));

        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(GameUser.class));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
    }

    public static void main(String[] args) throws Exception {
        new GameAuthApplication().run(args);
    }
}
