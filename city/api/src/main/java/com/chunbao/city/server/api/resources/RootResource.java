package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.api.providers.Exceptions;
import com.chunbao.city.server.api.responses.root.LoadPageResponse;
import com.chunbao.city.server.api.responses.root.PingResponse;
import com.chunbao.city.server.common.constant.HttpRequestConstant;
import com.chunbao.city.server.common.constant.UserRoles;
import com.chunbao.city.server.common.db.json.JsonFactory;
import com.chunbao.city.server.common.db.po.User;
import com.chunbao.city.server.common.exception.ServiceException;
import com.chunbao.city.server.common.service.SystemService;
import com.chunbao.city.server.common.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * The base resource for the API.
 */
@Path("/")
public class RootResource extends MyResource {

    private static final Logger mLogger = LoggerFactory.getLogger(RootResource.class);

    @GET
    @PermitAll
    @Produces({ HttpRequestConstant.CHINESE_JSON_CHARSET})
    public String ping() {
        try {
            PingResponse ping= new PingResponse();
            User guest = null;
            guest = UserService.getGuest();
            ping.guest = JsonFactory.makeUserJson(guest,JsonFactory.INFO_FULL);
            ping.guest.password = guest.password;
            return makeJson(ping);
        } catch (ServiceException e) {
            throw new ForbiddenException(e.getMessage());
        }
    }

    //use log in user to get the list.
    @GET
    @RolesAllowed(UserRoles.Guest)
    @Produces({ HttpRequestConstant.CHINESE_JSON_CHARSET})
    @Path("/system")
    public String getSystem() {
        LoadPageResponse loadPage = new LoadPageResponse();
        loadPage.serverInfoJson = JsonFactory.makeServerInfoJson(SystemService.getServerInfo());
        return makeJson(loadPage);
    }
}
