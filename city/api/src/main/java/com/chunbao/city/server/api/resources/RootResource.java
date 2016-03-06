package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.api.responses.root.LoadPageResponse;
import com.chunbao.city.server.api.responses.root.PingResponse;
import com.chunbao.city.server.common.db.po.Category;
import com.chunbao.city.server.common.constant.UserRoles;
import com.chunbao.city.server.common.db.json.JsonFactory;
import com.chunbao.city.server.common.service.CategoryService;
import com.chunbao.city.server.common.service.SystemService;
import com.chunbao.city.server.common.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * The base resource for the API.
 */
@Path("/")
public class RootResource extends MyResource {

    private static final Logger mLogger = LoggerFactory.getLogger(RootResource.class);

    @GET
    @PermitAll
    @Produces({ CHINESE_JSON_CHARSET})
    public String ping() {
        PingResponse ping= new PingResponse();
        ping.guest = JsonFactory.makeUserJson(UserService.getGuest());
        return makeJson(ping);
    }

    //use log in user to get the list.
    @GET
    @RolesAllowed(UserRoles.Guest)
    @Produces({ CHINESE_JSON_CHARSET})
    @Path("/start")
    public String getStart() {
        LoadPageResponse loadPage = new LoadPageResponse();
        loadPage.serverInfoJson = JsonFactory.makeServerInfoJson(SystemService.getServerInfo(getUser().id));
        List<Category> list = CategoryService.getCategoryListById(getUser().id);
        for(Category category : list){
            loadPage.categoryList.add(JsonFactory.makeCategoryJson(category));
        }
        return makeJson(loadPage);
    }
}
