package com.chunbao.city.server.api.providers;

import com.chunbao.city.server.common.constant.AdminUser;
import com.chunbao.city.server.common.constant.HttpRequestConstant;
import com.chunbao.city.server.common.constant.Server;
import com.chunbao.city.server.common.db.po.User;
import com.chunbao.city.server.common.constant.UserRoles;
import com.chunbao.city.server.common.util.DateTimeUtil;
import com.chunbao.city.server.common.util.StringUtil;
import org.glassfish.jersey.oauth1.signature.OAuth1Parameters;
import org.glassfish.jersey.oauth1.signature.OAuth1Secrets;
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
import java.util.Date;

@PreMatching
@Provider
@Priority(Priorities.AUTHENTICATION)
public class OAuthAuthenticationFilter implements ContainerRequestFilter {

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
        mLogger.info("time = {}, path = {}", DateTimeUtil.formatTimeToString(new Date()),requestUrl);
    }

    //set the token secret = ""
    private void doOauth(final ContainerRequestContext containerRequest){
        if(false){
            final OAuthServerRequest request = new OAuthServerRequest(containerRequest);
            final OAuth1Parameters params = new OAuth1Parameters();
            params.readRequest(request);
            OAuth1Secrets secrets = new OAuth1Secrets();
            secrets.setTokenSecret(Server.JERSEY_OAUTH_TOKEN);
            try {
                Exceptions.ForbiddenIf(!oAuthSignature.verify(request, params, secrets));
            }catch(Exception e) {
                e.printStackTrace();
                Exceptions.Forbidden(e.getMessage());
            }
        }
    }

    /**
     * if this user does not exist, throw exception
     * @param containerRequest
     * @return
     */
    private User getAndUpdateUser(final ContainerRequestContext containerRequest){
        final OAuthServerRequest request = new OAuthServerRequest(containerRequest);
        User user = new User();
        user.username= StringUtil.getFirstValueFromStringArray(request.getHeaderValues(HttpRequestConstant.PARAMETER_NAME_USERNAME));
        user.password=StringUtil.getFirstValueFromStringArray(request.getHeaderValues(HttpRequestConstant.PARAMETER_NAME_PASSWORD));
        user.deviceId=StringUtil.getFirstValueFromStringArray(request.getHeaderValues(HttpRequestConstant.PARAMETER_NAME_DEVICE_ID));
        user.deviceLanguage=StringUtil.getFirstValueFromStringArray(request.getHeaderValues(HttpRequestConstant.PARAMETER_NAME_DEVICE_LANGUAGE));
        user.longitude=StringUtil.getFloatByString(StringUtil.getFirstValueFromStringArray(request.getHeaderValues(HttpRequestConstant.PARAMETER_NAME_LONGITUDE)));
        user.latitude=StringUtil.getFloatByString(StringUtil.getFirstValueFromStringArray(request.getHeaderValues(HttpRequestConstant.PARAMETER_NAME_LATITUDE)));
        user.appVersion=StringUtil.getFirstValueFromStringArray(request.getHeaderValues(HttpRequestConstant.PARAMETER_NAME_APP_VERSION));

        //如果用户不存在
        //Exceptions.ForbiddenIf("You are not admin!");
        if(StringUtil.isNullOrEmpty(user.username) || StringUtil.isNullOrEmpty(user.password)){
            //for ping only, the rest denied
            if(!Server.API_PING_URL.equals(new OAuthServerRequest(containerRequest).getRequestURL().getPath())){
                Exceptions.Forbidden();
            }
        }
        //admin check the device id
        if(user.hasRole(UserRoles.Admin)){
            if(!AdminUser.ADMIN_DEVICE_ID.equals(user.deviceId)){
                Exceptions.Forbidden();
            }
        }
        //更新用户信息,经纬度,登陆时间,设备信息

        return user;
    }
}
