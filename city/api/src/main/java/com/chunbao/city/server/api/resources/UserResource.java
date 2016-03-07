package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.api.providers.Exceptions;
import com.chunbao.city.server.api.responses.user.UserProfileResponse;
import com.chunbao.city.server.common.constant.HttpRequestConstant;
import com.chunbao.city.server.common.constant.Sql;
import com.chunbao.city.server.common.constant.UserRoles;
import com.chunbao.city.server.common.db.json.JsonFactory;
import com.chunbao.city.server.common.db.json.UserOpinionJson;
import com.chunbao.city.server.common.db.po.Activity;
import com.chunbao.city.server.common.service.ActivityService;
import com.chunbao.city.server.common.service.UserService;
import com.chunbao.city.server.common.util.UUIDUtil;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
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
    @Produces({ HttpRequestConstant.CHINESE_JSON_CHARSET })
    @Path("/profile")
    public String getActivityList(@QueryParam("userId") final String userId) {

        Exceptions.BadRequestIf(UUIDUtil.isValidId(userId),"Invalid userId="+userId);

        UserProfileResponse data = new UserProfileResponse();

        data.user = JsonFactory.makeUserJson(UserService.getUserById(userId));

        data.opinion = new UserOpinionJson();

        return makeJson(data);
    }
}
