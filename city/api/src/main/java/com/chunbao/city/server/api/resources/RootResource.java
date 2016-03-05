package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.api.responses.LoadPage;
import com.chunbao.city.server.common.db.po.ApplicationVariables;
import com.chunbao.city.server.common.db.po.UserRoles;
import com.chunbao.city.server.common.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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
    @Produces({ MediaType.APPLICATION_JSON })
    public String ping() {
        StringBuffer sb = new StringBuffer();
        sb.append("输入header必带参数:").append(Utils.getSeparatorDot());
        sb.append("username:").append(Utils.getSeparatorDot());
        sb.append("password:").append(Utils.getSeparatorDot());
        sb.append("deviceId:").append(Utils.getSeparatorDot());
        sb.append("longitude:").append(Utils.getSeparatorDot());
        sb.append("latitude:").append(Utils.getSeparatorDot());
        sb.append("完成接口说明:").append(Utils.getSeparatorDot());
        sb.append("/start").append(Utils.getSeparatorDot());
        readMe = sb.toString();
        return makeJson("Api ping test.");
    }

    @GET
    @RolesAllowed(UserRoles.Admin)
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/start")
    public String getApplicationVariables() {
        timeout = ApplicationVariables.expiration_start;
        readMe = readMeStart();
        LoadPage loadPage = new LoadPage();
        return makeJson(loadPage);
    }
}
