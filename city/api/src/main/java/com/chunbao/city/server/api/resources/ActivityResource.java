package com.chunbao.city.server.api.resources;


import com.chunbao.city.server.api.responses.ActivityList;

import javax.annotation.security.PermitAll;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
@Path("/activity")
public class ActivityResource extends MyResource {
    @GET
    @PermitAll
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/list")
    public String getApplicationVariables(@PathParam("categoryId") final String categoryId,
                                          @PathParam("page") @DefaultValue("1") final int page) {
        ActivityList activityList = new ActivityList();
        return makeJson(activityList);
    }
}
