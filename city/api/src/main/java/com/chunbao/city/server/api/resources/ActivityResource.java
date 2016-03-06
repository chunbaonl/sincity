package com.chunbao.city.server.api.resources;


import com.chunbao.city.server.api.providers.Exceptions;
import com.chunbao.city.server.api.responses.activity.ActivityList;
import com.chunbao.city.server.api.responses.root.LoadPageResponse;
import com.chunbao.city.server.common.constant.UserRoles;
import com.chunbao.city.server.common.db.json.JsonFactory;
import com.chunbao.city.server.common.db.po.Category;
import com.chunbao.city.server.common.service.CategoryService;
import com.chunbao.city.server.common.service.SystemService;
import com.chunbao.city.server.common.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
@Path("/activity")
public class ActivityResource extends MyResource {

    private static final Logger mLogger = LoggerFactory.getLogger(CategoryResource.class);

    //list the activity for one category
    @GET
    @RolesAllowed(UserRoles.Guest)
    @Produces({ CHINESE_JSON_CHARSET})
    @Path("/list")
    public String getActivityList(@PathParam("page") @DefaultValue("1") final int page,
                                  @PathParam("categoryId") final String categoryId) {

        Exceptions.BadRequestIf(UUIDUtil.isValidId(categoryId),"Invalid categoryId");

        LoadPageResponse loadPage = new LoadPageResponse();
        loadPage.serverInfoJson = JsonFactory.makeServerInfoJson(SystemService.getServerInfo(getUser().id));
        List<Category> list = CategoryService.getCategoryListById(getUser().id);
        for(Category category : list){
            loadPage.categoryList.add(JsonFactory.makeCategoryJson(category));
        }
        return makeJson(loadPage);
    }
}
