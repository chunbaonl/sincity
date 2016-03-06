package com.chunbao.city.server.api.responses.root;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.po.User;
import com.chunbao.city.server.common.util.Utils;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class PingResponse extends MyResponse {

    public User guest;
    public PingResponse(){
        guest = new User();
    }

    //override
    public String getReadMe(){
        StringBuffer sb = new StringBuffer();
        sb.append("输入header必带参数:").append(Utils.getSeparatorDot());
        sb.append("username:").append(Utils.getSeparatorDot());
        sb.append("password:").append(Utils.getSeparatorDot());
        sb.append("deviceId:").append(Utils.getSeparatorDot());
        sb.append("deviceLanguage:").append(Utils.getSeparatorDot());
        sb.append("longitude:").append(Utils.getSeparatorDot());
        sb.append("latitude:").append(Utils.getSeparatorDot());
        sb.append("完成接口说明:").append(Utils.getSeparatorDot());
        sb.append("/start").append(Utils.getSeparatorDot());
        return sb.toString();
    }
}
