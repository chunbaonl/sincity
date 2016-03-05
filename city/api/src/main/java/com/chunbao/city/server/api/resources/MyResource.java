package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.po.User;
import com.chunbao.city.server.common.util.Utils;
import org.glassfish.jersey.server.oauth1.internal.OAuthServerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class MyResource {

    private static final Logger mLogger = LoggerFactory.getLogger(MyResource.class);

    public final static String PARAMETER_NAME_USERNAME = "username";
    public final static String PARAMETER_NAME_PASSWORD = "password";
    public final static String PARAMETER_NAME_DEVICE_ID = "deviceId";
    public final static String PARAMETER_NAME_LONGITUDE = "longitude";
    public final static String PARAMETER_NAME_LATITUDE = "latitude";

    @Context
    protected SecurityContext mSecurityContext;

    @Context
    protected HttpServletResponse response;

    @Context
    protected HttpServletRequest request;

    public int timeout;
    public String readMe;
    public User user;

    public String makeJson(Object object){
        MyResponse response = new MyResponse(readMe,timeout,getUser().hasNewMessage(),object);
        String data = Utils.toJson(response);
        mLogger.info(data);
        return data;
    }

    protected User getUser(){
        User user = (User)mSecurityContext.getUserPrincipal();
        return user;
    }

    public String readMeStart(){
        StringBuffer sb = new StringBuffer();
        sb.append("首页访问地址").append(Utils.getSeparatorDot());
        sb.append("路径: /start").append(Utils.getSeparatorDot());
        sb.append("输入参数无").append(Utils.getSeparatorDot());
        return sb.toString();
    }
}
