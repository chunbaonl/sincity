package com.chunbao.city.server.common.util;

/**
 * Created by anchunyang on 10/03/16.
 * Description:
 */
public class SystemUtil {

    public static class SystemProperty {

        private final String mKey;

        public SystemProperty(final String key) {
            mKey = key;
        }

        public String getValue() {
            return System.getProperty(mKey);
        }

        public String getKey() {
            return mKey;
        }
    }

    public static String getSystemByName(String name){
        return new SystemProperty(name).getValue();
    }
}
