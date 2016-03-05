package com.chunbao.city.server.common.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
