package com.chunbao.city.server.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class DateTimeUtil {

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
        String strDate = "";
        try {
            strDate = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }
}
