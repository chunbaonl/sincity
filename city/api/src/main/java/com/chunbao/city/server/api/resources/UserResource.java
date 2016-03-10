package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.api.providers.Exceptions;
import com.chunbao.city.server.api.responses.MessageResponse;
import com.chunbao.city.server.api.responses.user.UserListResponse;
import com.chunbao.city.server.api.responses.user.UserProfileResponse;
import com.chunbao.city.server.common.constant.HttpRequestConstant;
import com.chunbao.city.server.common.constant.MessageByLanguage;
import com.chunbao.city.server.common.constant.Sql;
import com.chunbao.city.server.common.constant.UserRoles;
import com.chunbao.city.server.common.db.json.JsonFactory;
import com.chunbao.city.server.common.db.json.UserJson;
import com.chunbao.city.server.common.db.json.UserOpinionJson;
import com.chunbao.city.server.common.db.po.Activity;
import com.chunbao.city.server.common.db.po.User;
import com.chunbao.city.server.common.service.ActivityService;
import com.chunbao.city.server.common.service.UserService;
import com.chunbao.city.server.common.util.StringUtil;
import com.chunbao.city.server.common.util.UUIDUtil;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
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
    @Path("/get")
    public String getUser(@QueryParam("userId") final String userId) {

        Exceptions.BadRequestIf(UUIDUtil.isValidId(userId),"Invalid userId="+userId);

        UserProfileResponse data = new UserProfileResponse();

        data.user = JsonFactory.makeUserJson(UserService.getUserById(userId));

        data.opinion = new UserOpinionJson();

        return makeJson(data);
    }

    @GET
    @RolesAllowed(UserRoles.Guest)
    @Produces({ HttpRequestConstant.CHINESE_JSON_CHARSET })
    @Path("/listbyactivity")
    public String getUserListByActivity(@QueryParam("page") @DefaultValue("1") final int page,
                                        @QueryParam("activityId") final String activityId) {

        Exceptions.BadRequestIf(UUIDUtil.isValidId(activityId),"Invalid userId="+activityId);

        UserListResponse data = new UserListResponse();

        List<UserJson> userList = new ArrayList<UserJson>();
        userList.add(JsonFactory.makeUserJson(new User()));
        userList.add(JsonFactory.makeUserJson(new User()));
        data.userList = userList;

        return makeJson(data);
    }

    @POST
    @RolesAllowed(UserRoles.User)
    @Produces({ HttpRequestConstant.CHINESE_JSON_CHARSET })
    @Path("/language")
    public String setLanguage(@QueryParam("language") final String language) {

        Exceptions.BadRequestIf(StringUtil.isNullOrEmpty(language),"Invalid language="+language);

        MessageResponse data = new MessageResponse(MessageByLanguage.getOK(getUser().deviceLanguage));

        return makeJson(data);
    }
}
