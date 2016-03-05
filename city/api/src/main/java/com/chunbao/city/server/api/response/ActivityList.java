package com.chunbao.city.server.api.response;

import java.util.ArrayList;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class ActivityList extends ChunbaoResponse {
    public ArrayList<Activity> activityList;
    public ActivityList(){
        activityList= new ArrayList<Activity>();
    }
}
