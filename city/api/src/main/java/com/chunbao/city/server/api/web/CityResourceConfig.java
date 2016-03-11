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

    public CityResourceConfig() {
        //Get a set of root resource, provider and feature classes.
        //provider OAuthAuthenticationFilter
        packages("com.chunbao.city.server.api.providers");
        //resource
        packages("com.chunbao.city.server.api.resources");

        //json
        register(JacksonFeature.class);
        //upload file
        register(MultiPartFeature.class);
        //oauth
        register(OAuth1SignatureFeature.class);
        //roles
        register(RolesAllowedDynamicFeature.class);

        //
        setApplicationName("api");
    }
}
