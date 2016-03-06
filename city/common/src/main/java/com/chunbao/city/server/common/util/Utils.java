package com.chunbao.city.server.common.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

public class Utils {

    private static final Logger mLogger = LoggerFactory.getLogger(Utils.class);

    /**
     * Get specific date from string.
     *
     * @param strDate format is "yyyy-MM-dd"
     * @return
     */
    public static Date generateDate(final String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @param date format is "yyyy,MM,dd"
     * @return
     */
    public static String formatDateToString(final Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd");
        String strDate = "";
        try {
            strDate = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }

    /**
     * @param date format is "hh:mm:ss"
     * @return
     */
    public static String formatTimeToString(final Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss");
        String strDate = "";
        try {
            strDate = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }
    /**
     * return the json string
     *
     * @param o
     * @return
     */
    public static String toJson(Object o) {
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static String getFirstValueFromStringArray(final List<String> array){
        String value=null;
        if(array!=null && array.size()>0){
            value=array.get(0);
        }
        return value;
    }

    public static String getFirstValueFromStringArray(final Enumeration<String> array){
        String value=null;
        if(array!=null && array.hasMoreElements()){
            value=array.nextElement();
        }
        return value;
    }

    public static boolean isNullOrEmpty(String str){
        return str==null || "".equals(str);
    }

    /**
     * Generate a GUID string of 5-segments: 8-4-4-4-12
     *
     * @return a 36-character GUID
     */
    public static String generate() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    public static boolean isValidId(String id){
        if(id==null || id.length()!=36){
            return false;
        }
        return true;
    }

    public static String getSeparator() {
        String separator = System.getProperty( "line.separator" );
        return separator;
    }
    public static String getSeparatorDot() {
        return ",";
    }

    public static <T> T readAsObjectOf(Class<T> clazz, String value){
        T o=null;
        try {
            ObjectMapper MAPPER = new ObjectMapper();
            o = MAPPER.readValue(value, clazz);
        } catch (Exception e) {
            mLogger.error("{}, {}", e.getMessage(), e.fillInStackTrace());
        }
        return o;
    }
}
