package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.api.providers.Exceptions;
import com.chunbao.city.server.api.responses.comment.ListCommentResponse;
import com.chunbao.city.server.common.constant.HttpRequestConstant;
import com.chunbao.city.server.common.constant.UserRoles;
import com.chunbao.city.server.common.db.json.JsonFactory;
import com.chunbao.city.server.common.db.po.Comment;
import com.chunbao.city.server.common.service.ActivityService;
import com.chunbao.city.server.common.service.CommentService;
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
 * Created by anchunyang on 06/03/16.
 * Description:
 */
@Path("/comment")
public class CommentResource extends MyResource {
    private static final Logger mLogger = LoggerFactory.getLogger(CommentResource.class);

    //list the comment for activity, if the user has the right to view it.
    @GET
    @RolesAllowed(UserRoles.Guest)
    @Produces({ HttpRequestConstant.CHINESE_JSON_CHARSET })
    @Path("/list")
    public String getCommentList(@PathParam("page") @DefaultValue("1") final int page,
                                 @PathParam("activityId") final String activityId,
                                 @PathParam("userId") final String userId) {

        Exceptions.BadRequestIf(UUIDUtil.isValidId(activityId),"Invalid activityId="+activityId);
        Exceptions.BadRequestIf(UUIDUtil.isValidId(userId),"Invalid userId="+userId);

        List<Comment> list = CommentService.getCommentList(page,activityId,getUser().id);

        ListCommentResponse data = new ListCommentResponse();
        for(Comment element : list){
            data.list.add(JsonFactory.makeCommentJson(element));
        }
        data.totalComments = ActivityService.getActivityById(activityId).totalComments;
        return makeJson(data);
    }
}
