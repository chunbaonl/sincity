package com.chunbao.city.server.api.responses.user;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.json.ActivityJson;
import com.chunbao.city.server.common.db.json.ActivityOpinionJson;
import com.chunbao.city.server.common.db.json.UserJson;
import com.chunbao.city.server.common.db.json.UserOpinionJson;
import com.chunbao.city.server.common.db.po.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class UserProfileResponse extends MyResponse {
    public UserOpinionJson opinion;
    public UserJson user;
    public UserProfileResponse(){
    }
}
