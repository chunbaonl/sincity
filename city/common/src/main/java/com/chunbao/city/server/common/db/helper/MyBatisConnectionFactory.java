package com.chunbao.city.server.common.db.helper;

import com.chunbao.city.server.common.util.SystemUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

public class MyBatisConnectionFactory {

    public final static boolean AUTO_COMMIT = true;
    public final static boolean NOT_AUTO_COMMIT = false;
    private final static String DB_URL_NAME = "database.url";
    private final static String DB_USERNAME = "database.username";
    private final static String DB_PASSWORD = "database.password";

    private static final Logger mLog = LoggerFactory.getLogger(MyBatisConnectionFactory.class);

    private static SqlSessionFactory mSqlSessionFactory = null;

    private MyBatisConnectionFactory() {
    }

    static {
        try {
            String resource = "mybatis.xml";
            String environment = SystemUtil.getSystemByName("DEPLOYMENT_ENVIRONMENT");

            Properties properties = getProperties();

            Reader reader = Resources.getResourceAsReader(resource);
            if (mSqlSessionFactory == null) {
                mSqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, environment, properties);
            }
        } catch (FileNotFoundException e) {
            mLog.error("File not found: {}", e.getMessage());
        } catch (IOException e) {
            mLog.error("I/O exception: {}", e.getMessage());
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return mSqlSessionFactory;
    }

    private static Properties getProperties(){
        Properties dbProps = new Properties();
        // access
        dbProps.setProperty(DB_URL_NAME, SystemUtil.getSystemByName(DB_URL_NAME));
        dbProps.setProperty(DB_USERNAME, SystemUtil.getSystemByName(DB_USERNAME));
        dbProps.setProperty(DB_PASSWORD, SystemUtil.getSystemByName(DB_PASSWORD));

        // utf-8 (utf8mb4) support
        dbProps.setProperty("characterEncoding", "utf8mb4");
        dbProps.setProperty("useUnicode", "true");

        // connection defaults
        dbProps.setProperty("maxActive", "50");
        dbProps.setProperty("maxIdle", "10");
        dbProps.setProperty("maxWait", "5000");
        dbProps.setProperty("removeAbandoned", "true");
        dbProps.setProperty("removeAbandonedTimeout", "20");
        dbProps.setProperty("testOnBorrow", "true");
        dbProps.setProperty("validationQuery", "SELECT 1");
        dbProps.setProperty("timeBetweenEvictionRunsMillis", "20000");
        dbProps.setProperty("abandonWhenPercentageFull", "50");
        dbProps.setProperty("autoReconnect","true");

        return dbProps;
    }
}

