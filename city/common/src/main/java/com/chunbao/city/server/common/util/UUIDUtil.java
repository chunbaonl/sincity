package com.chunbao.city.server.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;

public class UUIDUtil {

    private static final Logger mLogger = LoggerFactory.getLogger(UUIDUtil.class);
    /**
     * Generate a GUID string of 5-segments: 8-4-4-4-12
     *
     * @return a 36-character GUID
     */
    public static String generate() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    public static boolean isValidId(String id){
        return false;
//        if(id==null || id.length()!=36){
//            return false;
//        }
//        return true;
    }

    /**
     * 格式: 时间_id
     * @return
     */
    public static String generatePicName(){
        String uuid = generate();
        String date = DateTimeUtil.formatTimeToString(new Date());
        return date+"_"+uuid;
    }
}
