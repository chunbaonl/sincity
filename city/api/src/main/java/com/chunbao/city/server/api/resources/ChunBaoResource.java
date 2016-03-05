package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.common.db.po.User;
import com.chunbao.city.server.common.util.Utils;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class ChunBaoResource {
    public User user;
    public String makeJson(Object o){
        return "{data:"+ Utils.toJson(o)+";hasNewMessage:"+user.hasNewMessage()+"}";
    }
}
