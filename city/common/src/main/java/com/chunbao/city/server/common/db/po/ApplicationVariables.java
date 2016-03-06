package com.chunbao.city.server.common.db.po;

/**
 * Created by anchunyang on 03/03/16.
 * Description: 从数据库中读取,并且有线程定时更新
 */
public class ApplicationVariables {
    public final static int DEFAULT_TIMEOUT = 10;
    public final static String API_SERVER_URL="http://sincityapi.eu-west-1.elasticbeanstalk.com/";
    public final static String API_PING_URL="/";
    //管理设备id
    public final static String ADMIN_DEVICE_ID="090939";

    //timeout
    public static int expirationForCategory=DEFAULT_TIMEOUT;
    public static int expiration_start=DEFAULT_TIMEOUT;
}
