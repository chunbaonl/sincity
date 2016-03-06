package com.chunbao.city.server.api.providers;

import com.chunbao.city.server.api.resources.MyResource;
import com.chunbao.city.server.common.constant.AdminUser;
import com.chunbao.city.server.common.constant.Server;
import com.chunbao.city.server.common.db.po.User;
import com.chunbao.city.server.common.db.po.UserRoles;
import com.chunbao.city.server.common.util.StringUtil;
import org.glassfish.jersey.oauth1.signature.OAuth1Signature;
import org.glassfish.jersey.server.oauth1.internal.OAuthServerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

@PreMatching
@Provider
@Priority(Priorities.AUTHENTICATION)
public class OAuthAuthenticationFilter implements ContainerRequestFilter {
    /**
     * Maximum allowed clock skew in seconds (forward or backward) for OAuth-requests
     */
    private static final int MAX_CLOCK_SKEW_SECONDS = 60 * 20;

    private static final Logger mLogger = LoggerFactory.getLogger(OAuthAuthenticationFilter.class);

    @Inject
    private OAuth1Signature oAuthSignature;

    @Context
    private HttpServletRequest mHttpServletRequest;

    @Override
    public void filter(final ContainerRequestContext containerRequest) {

        //log
        log(containerRequest);
        //OAuth
        doOauth(containerRequest);
        //read parameter
        User user = getAndUpdateUser(containerRequest);
        //临时设置,给用户最高权限
        user.setAdminRole();
        containerRequest.setSecurityContext(new ApiSecurityContext(user));
    }

    private void log(final ContainerRequestContext containerRequest){
        String requestUrl = (new OAuthServerRequest(containerRequest)).getRequestURL().getPath();
        mLogger.info(requestUrl);
    }

    private void doOauth(final ContainerRequestContext containerRequest){
/*
        // Read the OAuth parameters from the request
        final OAuthServerRequest request = new OAuthServerRequest(containerRequest);
        final OAuth1Parameters params = new OAuth1Parameters();
        params.readRequest(request);
        OAuth1Secrets secrets = new OAuth1Secrets().consumerSecret("secret");
        //verify
        try {
            if (!oAuthSignature.verify(request, params, secrets)) {
                throw new WebApplicationException(401);
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(401);
        }
        see link https://github.com/ad1tya/jersey-oauth-simple
*/
    }

    /**
     * if this user does not exist, throw exception
     * @param containerRequest
     * @return
     */
    private User getAndUpdateUser(final ContainerRequestContext containerRequest){
        final OAuthServerRequest request = new OAuthServerRequest(containerRequest);
        User user = new User();
        user.username= StringUtil.getFirstValueFromStringArray(request.getHeaderValues(MyResource.PARAMETER_NAME_USERNAME));
        user.password=StringUtil.getFirstValueFromStringArray(request.getHeaderValues(MyResource.PARAMETER_NAME_PASSWORD));
        user.deviceId=StringUtil.getFirstValueFromStringArray(request.getHeaderValues(MyResource.PARAMETER_NAME_DEVICE_ID));
        user.deviceLanguage=StringUtil.getFirstValueFromStringArray(request.getHeaderValues(MyResource.PARAMETER_NAME_DEVICE_LANGUAGE));
        user.longitude=StringUtil.getFirstValueFromStringArray(request.getHeaderValues(MyResource.PARAMETER_NAME_LONGITUDE));
        user.latitude=StringUtil.getFirstValueFromStringArray(request.getHeaderValues(MyResource.PARAMETER_NAME_LATITUDE));

        //如果用户不能存在
        //throw new WebApplicationException(401);
        if(StringUtil.isNullOrEmpty(user.username) || StringUtil.isNullOrEmpty(user.password)){
            //for ping only, the rest denied
            if(!Server.API_PING_URL.equals(new OAuthServerRequest(containerRequest).getRequestURL().getPath())){
                throw new ForbiddenException("Invalid consumer");
            }
        }
        //admin check the device id
        if(user.hasRole(UserRoles.Admin)){
            if(!AdminUser.ADMIN_DEVICE_ID.equals(user.deviceId)){
                throw new WebApplicationException(401);
            }
        }
        //更新用户信息,经纬度,登陆时间,设备信息

        return user;
    }
}
