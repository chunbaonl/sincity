package com.chunbao.city.server.common.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class StringUtil {

    private static final Logger mLogger = LoggerFactory.getLogger(StringUtil.class);

    public final static String CHARSET = "UTF-8";

    public static String compress(String str) throws Exception {
        if (str == null || str.length() == 0) {
            return str;
        }
        System.out.println("String length : " + str.length());
        ByteArrayOutputStream obj=new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(obj);
        gzip.write(str.getBytes(CHARSET));
        gzip.close();
        String outStr = obj.toString(CHARSET);
        System.out.println("Output String length : " + outStr.length());
        return outStr;
    }

    /**
     * UTF-8
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String decompress(byte[] bytes) throws Exception {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        System.out.println("Input String length : " + bytes.length);
        GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(bytes));
        BufferedReader bf = new BufferedReader(new InputStreamReader(gis, CHARSET));
        String outStr = "";
        String line;
        while ((line=bf.readLine())!=null) {
            outStr += line;
        }
        System.out.println("Output String length : " + outStr.length());
        return outStr;
    }

    /**
     * return the json string
     *
     * @param o
     * @return
     */
    public static String toJson(Object o) {
        String json = "";

        try {
            json = ObjectMapperContextResolver.getMapper().writeValueAsString(o);
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

    public static float getFloatByString(String str){
        float data = 0;
        try{
            data = Float.valueOf(str);
        }
        catch (Exception e){
            mLogger.warn("{}, {}", e.getMessage(), e.fillInStackTrace());
        }
        return data;
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
            o = ObjectMapperContextResolver.getMapper().readValue(value, clazz);
        } catch (Exception e) {
            mLogger.warn("{}, {}", e.getMessage(), e.fillInStackTrace());
        }
        return o;
    }

    public static boolean isNullOrEmpty(String str){
        return str==null || "".equals(str);
    }

}
