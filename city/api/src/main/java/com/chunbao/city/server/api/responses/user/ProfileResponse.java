package com.chunbao.city.server.api.responses.user;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.json.ActivityJson;
import com.chunbao.city.server.common.db.json.UserJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class ProfileResponse  extends MyResponse {
    public UserJson user;
    public List<ActivityJson> activityList;
    public ProfileResponse(){
        activityList = new ArrayList<ActivityJson>();
    }
}
