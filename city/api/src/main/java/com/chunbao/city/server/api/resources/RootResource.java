package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.api.responses.root.LoadPageResponse;
import com.chunbao.city.server.api.responses.root.PingResponse;
import com.chunbao.city.server.common.constant.Server;
import com.chunbao.city.server.common.db.po.UserRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The base resource for the API.
 */
@Path("/")
public class RootResource extends MyResource {

    private static final Logger mLogger = LoggerFactory.getLogger(RootResource.class);

    @GET
    @PermitAll
    @Produces({ Server.CHINESE_JSON_CHARSET})
    public String ping() {
        PingResponse ping= new PingResponse();
        return makeJson(ping);
    }

    @GET
    @RolesAllowed(UserRoles.Admin)
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ Server.CHINESE_JSON_CHARSET})
    @Path("/start")
    public String getStart() {

        LoadPageResponse loadPage = new LoadPageResponse();
        return makeJson(loadPage);
    }
}
