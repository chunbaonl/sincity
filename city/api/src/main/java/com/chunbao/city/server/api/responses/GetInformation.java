package com.chunbao.city.server.api.responses;

import com.chunbao.city.server.api.responses.activity.GetActivityByIdResponse;
import com.chunbao.city.server.api.responses.activity.ListActivityByUserResponse;
import com.chunbao.city.server.api.responses.activity.ListActivityResponse;
import com.chunbao.city.server.api.responses.category.ListCategoryResponse;
import com.chunbao.city.server.api.responses.city.ListCityResponse;
import com.chunbao.city.server.api.responses.comment.ListCommentResponse;
import com.chunbao.city.server.api.responses.root.LoadPageResponse;
import com.chunbao.city.server.api.responses.root.PingResponse;
import com.chunbao.city.server.api.responses.user.UserProfileResponse;
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
        } else if (myResponse instanceof ListActivityResponse) {
            timeout = TimeOut.listActivity;
        } else if (myResponse instanceof ListActivityByUserResponse) {
            timeout = TimeOut.listActivityByUser;
        } else if (myResponse instanceof UserProfileResponse) {
            timeout = TimeOut.userProfile;
        } else if (myResponse instanceof GetActivityByIdResponse) {
            timeout = TimeOut.activityDetail;
        } else if (myResponse instanceof ListCommentResponse) {
            timeout = TimeOut.listComment;
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
        } else if (myResponse instanceof UserProfileResponse) {
            readMe = getReadMeUserProfile();
        } else if (myResponse instanceof GetActivityByIdResponse) {
            readMe = getReadMeActivityDetail();
        } else if (myResponse instanceof ListCommentResponse) {
            readMe = getReadMeListComment();
        } else if (myResponse instanceof ListCategoryResponse) {
            readMe = getReadMeListCategoryResponse();
        } else if (myResponse instanceof ListCityResponse) {
            readMe = getReadMeListCityResponse();
        }


        return readMe;
    }

    private static String getReadMeStart() {
        StringBuffer sb = new StringBuffer();
        sb.append("        ==========").append(StringUtil.getSeparatorDot());
        sb.append("输入header必带参数:").append(StringUtil.getSeparatorDot());
        sb.append("username").append(StringUtil.getSeparatorDot());
        sb.append("password").append(StringUtil.getSeparatorDot());
        sb.append("deviceId").append(StringUtil.getSeparatorDot());
        sb.append("utctime").append(StringUtil.getSeparatorDot());
        sb.append("longitude").append(StringUtil.getSeparatorDot());
        sb.append("latitude").append(StringUtil.getSeparatorDot());
        sb.append("appVersion").append(StringUtil.getSeparatorDot());
        sb.append("返回对象,guest用户(账户和密码)").append(StringUtil.getSeparatorDot());
        sb.append("        ==========").append(StringUtil.getSeparatorDot());
        sb.append("id 格式:8-4-4-4-12").append(StringUtil.getSeparatorDot());
        sb.append("id 例子:5BFDEA90-E557-4C84-9003-F8E203BB6F3D").append(StringUtil.getSeparatorDot());
        sb.append("        ==========").append(StringUtil.getSeparatorDot());
        sb.append("完成接口").append(StringUtil.getSeparatorDot());
        sb.append("/").append(StringUtil.getSeparatorDot());
        sb.append("/system").append(StringUtil.getSeparatorDot());
        sb.append("/category/list").append(StringUtil.getSeparatorDot());
        sb.append("/city/list").append(StringUtil.getSeparatorDot());
        sb.append("/comment/list").append(StringUtil.getSeparatorDot());
        sb.append("/activity/list").append(StringUtil.getSeparatorDot());
        sb.append("/activity/listuser").append(StringUtil.getSeparatorDot());
        sb.append("/activity/detail").append(StringUtil.getSeparatorDot());
        sb.append("/user/profile").append(StringUtil.getSeparatorDot());

        sb.append("        ==========").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }

    private static String getReadMeLoadPage() {
        StringBuffer sb = new StringBuffer();
        sb.append("首页访问地址").append(StringUtil.getSeparatorDot());
        sb.append("路径: /start").append(StringUtil.getSeparatorDot());
        sb.append("输入参数:").append(StringUtil.getSeparatorDot());
        sb.append("        ==========").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }

    private static String getReadMeActivityList() {
        StringBuffer sb = new StringBuffer();
        sb.append("取到当前栏目内容列表:").append(StringUtil.getSeparatorDot());
        sb.append("路径: /activity/list").append(StringUtil.getSeparatorDot());
        sb.append("输入参数: page,categoryId,cityId").append(StringUtil.getSeparatorDot());
        sb.append("        ==========").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }

    private static String getReadMeActivityListByUser() {
        StringBuffer sb = new StringBuffer();
        sb.append("取到当前栏目内容列表:").append(StringUtil.getSeparatorDot());
        sb.append("路径: /activity/listuser").append(StringUtil.getSeparatorDot());
        sb.append("输入参数: page,userId").append(StringUtil.getSeparatorDot());
        sb.append("        ==========").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }

    private static String getReadMeUserProfile() {
        StringBuffer sb = new StringBuffer();
        sb.append("得到当前用户档案:").append(StringUtil.getSeparatorDot());
        sb.append("路径: /user/profile").append(StringUtil.getSeparatorDot());
        sb.append("输入参数: userId").append(StringUtil.getSeparatorDot());
        sb.append("        ==========").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }

    private static String getReadMeActivityDetail() {
        StringBuffer sb = new StringBuffer();
        sb.append("得到活动细节:").append(StringUtil.getSeparatorDot());
        sb.append("路径: /activity/detail").append(StringUtil.getSeparatorDot());
        sb.append("输入参数: activityId").append(StringUtil.getSeparatorDot());
        sb.append("        ==========").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }

    private static String getReadMeListComment() {
        StringBuffer sb = new StringBuffer();
        sb.append("得到活动评论:").append(StringUtil.getSeparatorDot());
        sb.append("路径: /comment/list").append(StringUtil.getSeparatorDot());
        sb.append("输入参数: page,activityId").append(StringUtil.getSeparatorDot());
        sb.append("        ==========").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }

    private static String getReadMeListCategoryResponse() {
        StringBuffer sb = new StringBuffer();
        sb.append("得到栏目列表:").append(StringUtil.getSeparatorDot());
        sb.append("路径: /category/list").append(StringUtil.getSeparatorDot());
        sb.append("输入参数: 无").append(StringUtil.getSeparatorDot());
        sb.append("        ==========").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }

    private static String getReadMeListCityResponse() {
        StringBuffer sb = new StringBuffer();
        sb.append("得到城市列表:").append(StringUtil.getSeparatorDot());
        sb.append("路径: /city/list").append(StringUtil.getSeparatorDot());
        sb.append("输入参数: 无").append(StringUtil.getSeparatorDot());
        sb.append("        ==========").append(StringUtil.getSeparatorDot());
        return sb.toString();
    }


}
