package com.chunbao.city.server.common.constant;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class TimeOut {
    public static int DEFAULT_TIMEOUT_LEVEL_SHORT_A = 2;
    public static int DEFAULT_TIMEOUT_LEVEL_SHORT_B = 5;
    public static int DEFAULT_TIMEOUT_LEVEL_SHORT_C = 10;
    public static int DEFAULT_TIMEOUT_LEVEL_SHORT_D = 1*60;
    public static int DEFAULT_TIMEOUT_LEVEL_MIDDEN_A = 2*60;
    public static int DEFAULT_TIMEOUT_LEVEL_MIDDEN_B = 5*60;
    public static int DEFAULT_TIMEOUT_LEVEL_MIDDEN_C = 10*60;
    public static int DEFAULT_TIMEOUT_LEVEL_MIDDEN_D = 30*60;
    public static int DEFAULT_TIMEOUT_LEVEL_LONG_A = 1*60*60;
    public static int DEFAULT_TIMEOUT_LEVEL_LONG_B = 5*60*60;
    public static int DEFAULT_TIMEOUT_LEVEL_LONG_C = 24*60*60;
    public static int DEFAULT_TIMEOUT_LEVEL_LONG_D = 7*24*60*60;

    //timeout
    public static int ping = DEFAULT_TIMEOUT_LEVEL_SHORT_A;
    public static int loadPage = DEFAULT_TIMEOUT_LEVEL_SHORT_A;
    public static int listActivity = DEFAULT_TIMEOUT_LEVEL_SHORT_A;
    public static int listActivityByUser = DEFAULT_TIMEOUT_LEVEL_SHORT_A;
    public static int userProfile = DEFAULT_TIMEOUT_LEVEL_SHORT_A;
}
