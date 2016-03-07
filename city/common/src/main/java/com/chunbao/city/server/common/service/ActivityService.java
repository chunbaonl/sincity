package com.chunbao.city.server.common.service;

import com.chunbao.city.server.common.db.po.Activity;
import com.chunbao.city.server.common.db.po.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class ActivityService extends MyService {

    /**
     * get activity list, based on the user and category
     * @param page
     * @param categoryId
     * @param cityId
     * @return
     */
    public static List<Activity> getActivityList(final int page,
                                                 final String categoryId,
                                                 final String cityId){
        ArrayList<Activity> list = new ArrayList<>();
        Activity element;
        for(int i=0;i<10;i++){
            list.add(makeActivity(i));
        }
        return list;
    }

    /**
     * get activity list, based on the user
     * @param page
     * @param userId
     * @return
     */
    public static List<Activity> getActivityListByUser(final int page,
                                                 final String userId){
        ArrayList<Activity> list = new ArrayList<>();
        Activity element;
        for(int i=0;i<10;i++){
            list.add(makeActivity(i));
        }
        return list;
    }

    /**
     * get activity list, based on the user
     * @param activityId
     * @return
     */
    public static Activity getActivityById(final String activityId){
        return makeActivity(1);
    }

    private static Activity makeActivity(int i){
        Activity element =new Activity();
        element.title = "活动"+i;
        element.bigPotoId = "/pic-api-test/2016-03-07_08-01-12_5BFDEA90-E557-4C84-9003-F8E203BB6F3D.jpg";
        element.description = "描述" + i;
        element.costPerDay = 100 - i;
        element.totalComments = 100 - i;
        element.totalLikes = 20 - i;
        element.ownerName = "Micheal Jackson";
        return element;
    }
}
