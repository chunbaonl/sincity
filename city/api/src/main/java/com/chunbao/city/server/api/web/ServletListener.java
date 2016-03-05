package com.chunbao.city.server.api.web;

import com.chunbao.city.server.common.helper.TaskScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {

    private static final Logger mLogger = LoggerFactory.getLogger(ServletListener.class);
    private final TaskScheduler mScheduler;


    /**
     * Register the recurring tasks to the task scheduler
     */
    public ServletListener() {
        mScheduler = new TaskScheduler(mLogger);
    }


    @Override
    public void contextDestroyed(ServletContextEvent event) {
        mLogger.debug("contextDestroyed: context path = {}", event.getServletContext().getContextPath());
        mScheduler.shutdown();
    }


    @Override
    public void contextInitialized(ServletContextEvent event) {
        mLogger.debug("********************************************************");
        mLogger.debug("contextInitialized: service info = {}", event.getServletContext().getServerInfo());
        mLogger.debug("contextInitialized: context path = {}", event.getServletContext().getContextPath());

        mScheduler.scheduleTasks();
    }
}
