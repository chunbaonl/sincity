package com.chunbao.city.server.api.resources;


import com.chunbao.city.server.api.providers.Exceptions;
import com.chunbao.city.server.api.responses.activity.GetActivityByIdResponse;
import com.chunbao.city.server.api.responses.activity.ListActivityByUserResponse;
import com.chunbao.city.server.api.responses.activity.ListActivityResponse;
import com.chunbao.city.server.common.constant.HttpRequestConstant;
import com.chunbao.city.server.common.constant.UserRoles;
import com.chunbao.city.server.common.db.json.JsonFactory;
import com.chunbao.city.server.common.db.po.Activity;
import com.chunbao.city.server.common.db.po.ActivityOpinion;
import com.chunbao.city.server.common.service.ActivityService;
import com.chunbao.city.server.common.service.OpinionService;
import com.chunbao.city.server.common.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @Produces({ HttpRequestConstant.CHINESE_JSON_CHARSET })
    @Path("/list")
    public String getActivityList(@QueryParam("page") @DefaultValue("1") final int page,
                                  @QueryParam("categoryId") final String categoryId,
                                  @QueryParam("cityId") final String cityId) {

        Exceptions.BadRequestIf(UUIDUtil.isValidId(categoryId),"Invalid categoryId="+categoryId);

        List<Activity> list = ActivityService.getActivityList(page,categoryId,cityId);

        ListActivityResponse data = new ListActivityResponse();

        for(Activity element : list){
            data.activityList.add(JsonFactory.makeActivityJson(element));
        }

        return makeJson(data);
    }

    //list the activity for one user
    @GET
    @RolesAllowed(UserRoles.Guest)
    @Produces({ HttpRequestConstant.CHINESE_JSON_CHARSET })
    @Path("/listuser")
    public String getActivityListByUser(@QueryParam("page") @DefaultValue("1") final int page,
                                  @QueryParam("userId") final String userId) {

        Exceptions.BadRequestIf(UUIDUtil.isValidId(userId),"Invalid userId="+userId);

        List<Activity> list = ActivityService.getActivityListByUser(page,userId);

        ListActivityByUserResponse data = new ListActivityByUserResponse();

        for(Activity element : list){
            data.activityList.add(JsonFactory.makeActivityJson(element));
        }

        return makeJson(data);
    }

    //detail
    @GET
    @RolesAllowed(UserRoles.Guest)
    @Produces({ HttpRequestConstant.CHINESE_JSON_CHARSET })
    @Path("/detail")
    public String getCommentById(@QueryParam("activityId") final String activityId) {

        Exceptions.BadRequestIf(UUIDUtil.isValidId(activityId),"Invalid activityId="+activityId);

        GetActivityByIdResponse data = new GetActivityByIdResponse();

        Activity element = ActivityService.getActivityById(activityId);
        data.activity = JsonFactory.makeActivityJson(element);

        ActivityOpinion activityOpinion = OpinionService.getActivityOpinion(getUser().id,activityId);
        data.opinion = JsonFactory.makeActivityOpinionJson(activityOpinion);

        return makeJson(data);
    }
}
