package com.chunbao.city.server.api.responses.activity;

import com.chunbao.city.server.api.responses.MyResponse;

import java.util.ArrayList;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class ActivityList {
    public ArrayList<Activity> activityList;
    public ActivityList(){
        activityList= new ArrayList<Activity>();
    }
}
