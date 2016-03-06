package com.chunbao.city.server.api.responses;

import com.chunbao.city.server.api.responses.activity.ListActivityByUserResponse;
import com.chunbao.city.server.api.responses.activity.ListActivityResponse;
import com.chunbao.city.server.api.responses.root.LoadPageResponse;
import com.chunbao.city.server.api.responses.root.PingResponse;
import com.chunbao.city.server.api.responses.user.ProfileResponse;
import com.chunbao.city.server.common.constant.TimeOut;
import com.chunbao.city.server.common.util.StringUtil;
import sun.plugin.util.UserProfile;

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
        } else if (myResponse instanceof ListActivityResponse) {
            timeout = TimeOut.listActivity;
        } else if (myResponse instanceof ListActivityByUserResponse) {
            timeout = TimeOut.listActivityByUser;
        } else if (myResponse instanceof ProfileResponse) {
            timeout = TimeOut.userProfile;
        }
        return timeout;
    }

    public static String getReadMe(MyResponse myResponse) {
        String readMe = "";
        if (myResponse instanceof PingResponse) {
            readMe = getReadMeStart();
        } else if (myResponse instanceof LoadPageResponse) {
            readMe = getReadMeLoadPage();
        } else if (myResponse instanceof ListActivityResponse) {
            readMe = getReadMeActivityList();
        } else if (myResponse instanceof ListActivityByUserResponse) {
            readMe = getReadMeActivityListByUser();
        } else if (myResponse instanceof ProfileResponse) {
            readMe = getReadMeUserProfile();
        }
        return readMe;
    }

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
        sb.append("完成接口").append(StringUtil.getSeparatorDot());
        sb.append("/").append(StringUtil.getSeparatorDot());
        sb.append("/start").append(StringUtil.getSeparatorDot());
        sb.append("/activity/list").append(StringUtil.getSeparatorDot());
        sb.append("/activity/listuser").append(StringUtil.getSeparatorDot());
        sb.append("id 格式:8-4-4-4-12").append(StringUtil.getSeparatorDot());
        sb.append("id 例子:5BFDEA90-E557-4C84-9003-F8E203BB6F3D").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }

    private static String getReadMeLoadPage() {
        StringBuffer sb = new StringBuffer();
        sb.append("首页访问地址").append(StringUtil.getSeparatorDot());
        sb.append("路径: /start").append(StringUtil.getSeparatorDot());
        sb.append("输入参数:").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }

    private static String getReadMeActivityList() {
        StringBuffer sb = new StringBuffer();
        sb.append("取到当前栏目内容列表:").append(StringUtil.getSeparatorDot());
        sb.append("路径: /activity/list").append(StringUtil.getSeparatorDot());
        sb.append("输入参数: page,categoryId").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }

    private static String getReadMeActivityListByUser() {
        StringBuffer sb = new StringBuffer();
        sb.append("取到当前栏目内容列表:").append(StringUtil.getSeparatorDot());
        sb.append("路径: /activity/listuser").append(StringUtil.getSeparatorDot());
        sb.append("输入参数: page,userId").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }

    private static String getReadMeUserProfile() {
        StringBuffer sb = new StringBuffer();
        sb.append("得到当前用户档案:").append(StringUtil.getSeparatorDot());
        sb.append("路径: /user/profile").append(StringUtil.getSeparatorDot());
        sb.append("输入参数: userId").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }
}
