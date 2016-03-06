package com.chunbao.city.server.api.responses;

import com.chunbao.city.server.api.responses.root.LoadPageResponse;
import com.chunbao.city.server.api.responses.root.PingResponse;
import com.chunbao.city.server.common.constant.TimeOut;
import com.chunbao.city.server.common.util.StringUtil;

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
        sb.append("输入header必带参数:").append(StringUtil.getSeparatorDot());
        sb.append("username").append(StringUtil.getSeparatorDot());
        sb.append("password").append(StringUtil.getSeparatorDot());
        sb.append("deviceId").append(StringUtil.getSeparatorDot());
        sb.append("deviceLanguage").append(StringUtil.getSeparatorDot());
        sb.append("longitude").append(StringUtil.getSeparatorDot());
        sb.append("latitude").append(StringUtil.getSeparatorDot());
        sb.append("appVersion").append(StringUtil.getSeparatorDot());
        sb.append("返回对象,guest用户(账户和密码)").append(StringUtil.getSeparatorDot());
        sb.append("完成接口说明").append(StringUtil.getSeparatorDot());
        sb.append("/start").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }
    //override

    private static String getReadMeLoadPage() {
        StringBuffer sb = new StringBuffer();
        sb.append("首页访问地址").append(StringUtil.getSeparatorDot());
        sb.append("路径: /start").append(StringUtil.getSeparatorDot());
        sb.append("输入参数:").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }
}
