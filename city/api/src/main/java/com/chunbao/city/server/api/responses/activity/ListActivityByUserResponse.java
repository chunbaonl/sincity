package com.chunbao.city.server.api.responses.activity;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.json.ActivityJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class ListActivityByUserResponse extends MyResponse {
    public List<ActivityJson> activityList;
    public ListActivityByUserResponse(){
        activityList = new ArrayList<ActivityJson>();
    }
}

