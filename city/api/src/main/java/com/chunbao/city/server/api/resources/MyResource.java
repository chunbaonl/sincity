package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.api.responses.StandardResponse;
import com.chunbao.city.server.common.db.po.User;
import com.chunbao.city.server.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class MyResource {

    private static final Logger mLogger = LoggerFactory.getLogger(MyResource.class);

    @Context
    protected SecurityContext mSecurityContext;

    @Context
    protected HttpServletResponse response;

    @Context
    protected HttpServletRequest request;

    private User user;

    public String makeJson(MyResponse myResponse){
        StandardResponse response = new StandardResponse(getUser().hasNewMessage(),myResponse);
        String data = StringUtil.toJson(response);
        mLogger.info(data);
        return data;
    }

    protected User getUser(){
        user = (User)mSecurityContext.getUserPrincipal();
        return user;
    }
}
