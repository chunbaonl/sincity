package com.chunbao.city.server.api.responses.user;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.json.UserJson;

import java.util.List;

/**
 * Created by anchunyang on 09/03/16.
 * Description:
 */
public class UserListResponse extends MyResponse {
    public List<UserJson> userList;
}
