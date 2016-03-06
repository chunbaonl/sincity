package com.chunbao.city.server.common.constant;

import javax.ws.rs.core.MediaType;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class HttpRequestConstant {

    public final static String CHINESE_JSON_CHARSET= MediaType.APPLICATION_JSON + ";charset=" + "UTF-8";

    public final static String PARAMETER_NAME_USERNAME = "username";
    public final static String PARAMETER_NAME_PASSWORD = "password";
    public final static String PARAMETER_NAME_DEVICE_ID = "deviceId";
    public final static String PARAMETER_NAME_DEVICE_LANGUAGE = "deviceLanguage";
    public final static String PARAMETER_NAME_LONGITUDE = "longitude";
    public final static String PARAMETER_NAME_LATITUDE = "latitude";
    public final static String PARAMETER_NAME_APP_VERSION = "appVersion";
}
