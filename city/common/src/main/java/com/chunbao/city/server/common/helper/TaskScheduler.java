package com.chunbao.city.server.common.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class TaskScheduler {
    private static final Logger mLogger = LoggerFactory.getLogger(TaskScheduler.class);
    private final Collection<Task> mTasks;
    private ScheduledExecutorService mScheduler = null;

    public TaskScheduler(Logger logger) {
        //mLogger = logger;
        mTasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        mLogger.debug("addTask: Adding task '{}'", task.getName());
        mTasks.add(task);
    }

    public void shutdown() {
        if (mScheduler != null) {
            mScheduler.shutdown();
        }
        mLogger.debug("shutdown: Scheduler destroyed");
    }

    /**
     * Schedule all tasks.
     * <p/>
     * Note, this method is a a one-off; calling it subsequently has no effect.
     */
    public void scheduleTasks() {

        if (mScheduler == null) {
            mLogger.debug("scheduleTasks: Scheduling {} task(s)", mTasks.size());

            mScheduler = Executors.newScheduledThreadPool(mTasks.size());

            long initialDelay;
            String runningTime;
            int period;

            for (Task task : mTasks) {
                initialDelay = task.getInitialDelay();
                runningTime = task.getRunningTime();
                period = task.getPeriod();

                mLogger.debug("scheduleTasks: Task name = " + task.getName());
                mLogger.debug("scheduleTasks: Task initialDelay = " + (initialDelay / 1000) + " secs");
                mLogger.debug("scheduleTasks: Task runningTime = " + runningTime);
                mLogger.debug("scheduleTasks: Task period = " + (period / 1000) + " secs");

                if (period <= 0) {
                    mLogger.info("scheduleTasks: Adding one off task - {}. Task will run in [{}] secs.",
                            task.getName(), (initialDelay / 1000));
                    mScheduler.schedule(task, initialDelay, MILLISECONDS);
                } else {
                    mLogger.info("scheduleTasks: Add repeating task - {}. First run in [{}] secs and repeating every [{}] secs.",
                            task.getName(), (initialDelay / 1000), (period / 1000));
                    mScheduler.scheduleAtFixedRate(task, initialDelay, period, MILLISECONDS);
                }
            }
        }
    }

//    private long getDelayFromRunningTime(String runningTime) throws ParseException {
//        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//        String nowString = format.format(new Date());
//        Date now = format.parse(nowString);
//        Date then = format.parse(runningTime);
//        long delay = then.getTime() - now.getTime();
//        return delay;
//    }

}
