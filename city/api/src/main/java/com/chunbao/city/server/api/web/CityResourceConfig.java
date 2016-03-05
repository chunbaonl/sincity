package com.chunbao.city.server.api.web;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.oauth1.signature.OAuth1SignatureFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;
import java.util.logging.Logger;

/**
 * Created by anchunyang on 05/03/16.
 * Description:
 */
@ApplicationPath("/")
public class CityResourceConfig extends ResourceConfig {

    private static final boolean ENABLE_REQUEST_RESPONSE_LOGGING = false;

    public CityResourceConfig() {
        // DEBUG: Request & Response logging
        // ***NEVER*** enable on production!
        if (ENABLE_REQUEST_RESPONSE_LOGGING) {

            // Enable LoggingFilter & output entity.
            registerInstances(new LoggingFilter(Logger.getLogger(CityResourceConfig.class.getName()), true));
        }

        packages("com.chunbao.city.server.api.providers");
        packages("com.chunbao.city.server.api.resources");

        register(JacksonFeature.class);
        register(MultiPartFeature.class);
        register(OAuth1SignatureFeature.class);
        register(RolesAllowedDynamicFeature.class);

        setApplicationName("api");
    }
}
