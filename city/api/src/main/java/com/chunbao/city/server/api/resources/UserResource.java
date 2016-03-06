package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.api.providers.Exceptions;
import com.chunbao.city.server.api.responses.user.UserProfileResponse;
import com.chunbao.city.server.common.constant.Sql;
import com.chunbao.city.server.common.constant.UserRoles;
import com.chunbao.city.server.common.db.json.JsonFactory;
import com.chunbao.city.server.common.db.po.Activity;
import com.chunbao.city.server.common.service.ActivityService;
import com.chunbao.city.server.common.service.UserService;
import com.chunbao.city.server.common.util.UUIDUtil;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
@Path("/user")
public class UserResource extends MyResource {

    //show the homepage for user.
    @GET
    @RolesAllowed(UserRoles.Guest)
    @Produces({ CHINESE_JSON_CHARSET })
    @Path("/profile")
    public String getActivityList(@PathParam("userId") final String userId) {

        Exceptions.BadRequestIf(UUIDUtil.isValidId(userId),"Invalid userId");

        List<Activity> list = ActivityService.getActivityListByUser(Sql.ROWS_PER_PAGE_ACTIVITY_PROFILE,userId);

        UserProfileResponse data = new UserProfileResponse();
        for(Activity element : list){
            data.activityList.add(JsonFactory.makeActivityJson(element));
        }
        data.user = JsonFactory.makeUserJson(UserService.getUserById(userId));

        return makeJson(data);
    }
}
