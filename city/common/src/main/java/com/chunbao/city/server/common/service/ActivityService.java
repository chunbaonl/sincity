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
     * @param userId
     * @return
     */
    public static List<Activity> getActivityList(final int page,
                                                 final String categoryId,
                                                 final String userId){
        ArrayList<Activity> list = new ArrayList<>();
        Activity element =new Activity();
        list.add(element);
        element =new Activity();
        list.add(element);
        element =new Activity();
        list.add(element);
        element =new Activity();
        return list;
    }
}
