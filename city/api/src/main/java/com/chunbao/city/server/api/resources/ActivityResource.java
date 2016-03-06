package com.chunbao.city.server.api.resources;


import com.chunbao.city.server.api.providers.Exceptions;
import com.chunbao.city.server.api.responses.activity.ListActivityByUserResponse;
import com.chunbao.city.server.api.responses.activity.ListActivityResponse;
import com.chunbao.city.server.api.responses.root.LoadPageResponse;
import com.chunbao.city.server.common.constant.UserRoles;
import com.chunbao.city.server.common.db.json.JsonFactory;
import com.chunbao.city.server.common.db.po.Activity;
import com.chunbao.city.server.common.db.po.Category;
import com.chunbao.city.server.common.service.ActivityService;
import com.chunbao.city.server.common.service.CategoryService;
import com.chunbao.city.server.common.service.SystemService;
import com.chunbao.city.server.common.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
@Path("/activity")
public class ActivityResource extends MyResource {

    private static final Logger mLogger = LoggerFactory.getLogger(ActivityResource.class);

    //list the activity for one category, if the user has the right to view it.
    @GET
    @RolesAllowed(UserRoles.Guest)
    @Produces({ CHINESE_JSON_CHARSET })
    @Path("/list")
    public String getActivityList(@PathParam("page") @DefaultValue("1") final int page,
                                  @PathParam("categoryId") final String categoryId) {

        Exceptions.BadRequestIf(UUIDUtil.isValidId(categoryId),"Invalid categoryId");

        List<Activity> list = ActivityService.getActivityList(page,categoryId,getUser().id);

        ListActivityResponse data = new ListActivityResponse();
        for(Activity element : list){
            data.activityList.add(JsonFactory.makeActivityJson(element));
        }

        return makeJson(data);
    }

    //list the activity for one user
    @GET
    @RolesAllowed(UserRoles.Guest)
    @Produces({ CHINESE_JSON_CHARSET })
    @Path("/listuser")
    public String getActivityListByUser(@PathParam("page") @DefaultValue("1") final int page,
                                  @PathParam("userId") final String userId) {

        Exceptions.BadRequestIf(UUIDUtil.isValidId(userId),"Invalid userId");

        List<Activity> list = ActivityService.getActivityListByUser(page,userId);

        ListActivityByUserResponse data = new ListActivityByUserResponse();
        for(Activity element : list){
            data.activityList.add(JsonFactory.makeActivityJson(element));
        }

        return makeJson(data);
    }
}
