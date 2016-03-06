package com.chunbao.city.server.api.responses.activity;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.json.ActivityJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class ListActivityResponse extends MyResponse {
    public List<ActivityJson> activityList;
    public ListActivityResponse(){
        activityList = new ArrayList<ActivityJson>();
    }
}
