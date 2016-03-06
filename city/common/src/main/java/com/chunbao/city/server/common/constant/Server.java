package com.chunbao.city.server.common.constant;

import javax.ws.rs.core.MediaType;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class Server {
    public static String API_SERVER_URL="http://sincityapi.eu-west-1.elasticbeanstalk.com";
    public static String API_PING_URL="/";
    public static boolean JSON_IS_ZIPPED=true;
    public static String PIC_SERVER_URL="https://s3-eu-west-1.amazonaws.com";
    public static String DEFAULT_LOAD_PIC_URL ="/pic-api-sys/2016-03-07_08-01-10_4BFDEA90-E557-4C84-9003-F8E203BB6F3D.jpg";
    public static String DEFAULT_BROADCAST_MESSAGE ="你好,Guest.这是动态消息,可以按照个人事件或者广播类容显示.";
}
