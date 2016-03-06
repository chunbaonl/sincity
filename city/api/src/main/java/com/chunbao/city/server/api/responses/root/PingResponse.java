package com.chunbao.city.server.api.responses.root;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.po.User;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class PingResponse extends MyResponse {

    public User guest;

    public PingResponse(){
        guest = new User();
    }
}
