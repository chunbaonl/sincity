package com.chunbao.city.server.common.db.po;

/**
 * Created by anchunyang on 03/03/16.
 * Description: 从数据库中读取,并且有线程定时更新
 */
public class ApplicationVariables {
    public static int expirationForCategory=12*60*60;
    public static int expirationForStartPage=12*60*60;
}
