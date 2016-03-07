package com.chunbao.city.server.common.service;

import com.chunbao.city.server.common.db.po.Activity;
import com.chunbao.city.server.common.db.po.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class CommentService extends MyService {

    /**
     * get activity list, based on the user and activity,
     * @param page
     * @param activityId
     * @return
     */
    public static List<Comment> getCommentList(final int page,
                                               final String activityId){
        ArrayList<Comment> list = new ArrayList<>();
        Activity element;
        for(int i=0;i<20;i++){
            list.add(makeComment(i,activityId));
        }
        return list;
    }

    private static Comment makeComment(int i,final String activityId){
        Comment element =new Comment();
        element.message = "评论"+i;
        element.activityId = activityId;
        element.userId = "发帖人id"+i;
        return element;
    }
}
