package com.chunbao.city.server.common.service;

import com.chunbao.city.server.common.db.po.ActivityOpinion;
import com.chunbao.city.server.common.db.po.Category;

import java.util.List;

/**
 * Created by anchunyang on 07/03/16.
 * Description:
 */

public class OpinionService extends MyService {
    public static ActivityOpinion getActivityOpinion(final String userId,final String activityId){
        ActivityOpinion activityOpinion = new ActivityOpinion();
        activityOpinion.isAttended =true;
        activityOpinion.isLiked =false;
        return activityOpinion;
    }
}
