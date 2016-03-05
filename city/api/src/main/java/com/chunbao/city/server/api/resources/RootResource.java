package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.api.response.StartPage;
import com.chunbao.city.server.common.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * The base resource for the API.
 */
@Path("/")
public class RootResource extends ChunBaoResource {

    private static final Logger mLogger = LoggerFactory.getLogger(RootResource.class);
    @Context
    private HttpServletResponse response;

    @GET
    @PermitAll
    @Produces({ MediaType.APPLICATION_JSON })
    public String ping() {
//        try {
//            response.sendRedirect("");
//        } catch (IOException e) {
//            mLogger.warn("rootRedirect: Encountered Exception = {}", e.getMessage());
//        }
        return Utils.toJson("SinCity API ping test.");
    }

    @GET
    @PermitAll
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/start")
    public String getApplicationVariables() {
        StartPage startPage = new StartPage();
        return makeJson(startPage);
    }
}
