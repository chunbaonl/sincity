package com.chunbao.city.server.api.responses;

import com.chunbao.city.server.api.responses.root.LoadPageResponse;
import com.chunbao.city.server.api.responses.root.PingResponse;
import com.chunbao.city.server.common.constant.TimeOut;
import com.chunbao.city.server.common.util.Utils;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class GetInformation {

    public static int getTimeout(MyResponse myResponse) {
        int timeout = 0;
        if (myResponse instanceof PingResponse) {
            timeout = TimeOut.ping;
        } else if (myResponse instanceof LoadPageResponse) {
            timeout = TimeOut.loadPage;
        }
        return timeout;
    }

    public static String getReadMe(MyResponse myResponse) {
        String readMe = "";
        if (myResponse instanceof PingResponse) {
            readMe = getReadMeStart();
        } else if (myResponse instanceof LoadPageResponse) {
            readMe = getReadMeLoadPage();
        }
        return readMe;
    }

    //override
    private static String getReadMeStart() {
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
    //override

    private static String getReadMeLoadPage() {
        StringBuffer sb = new StringBuffer();
        sb.append("首页访问地址").append(Utils.getSeparatorDot());
        sb.append("路径: /start").append(Utils.getSeparatorDot());
        sb.append("输入参数无").append(Utils.getSeparatorDot());
        return sb.toString();
    }
}
