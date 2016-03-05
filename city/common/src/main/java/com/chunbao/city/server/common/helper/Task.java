package com.chunbao.city.server.common.helper;

import org.slf4j.Logger;

public abstract class Task implements Runnable {
    private final Logger mLogger;

    public Task(Logger logger) {
        mLogger = logger;
    }

    /**
     * A second in milliseconds.
     */
    public static final int ONE_SECOND = 1000;

    /**
     * A minute in milliseconds.
     */
    public static final int ONE_MINUTE = ONE_SECOND * 60;

    /**
     * An hour in milliseconds.
     */
    public static final int ONE_HOUR = ONE_MINUTE * 60;

    /**
     * A day in milliseconds.
     */
    public static final int ONE_DAY = ONE_HOUR * 24;

    /**
     * Wait at max this amount of milliseconds before executing the task to spread the load on the system. <br/>
     * To set a non default value, override this method in the inheriting child Task class.
     *
     * @return The amount of seconds somewhere between the task execution period with.
     */
    public int getInitialDelay() {
        // Nice idea but really breaks the timing of tasks with long periods.
//        final int mod = getPeriod();
//        if (mod > 0) {
//            return getClass().hashCode() % mod;
//        }
//        return 0;
        return Task.ONE_SECOND;
    }

    @Override
    public void run() {
        try {
            mLogger.trace("-[[ RUNNING TASK ]]-  ::  " + getName());
            runTask();
        } catch (final RuntimeException e) {
            mLogger.error("RuntimeException in run(): {}", e.getMessage());
            mLogger.error("caused by: {}", e.getCause());
            mLogger.error("Stack trace: ", e);
            e.printStackTrace();
        } catch (final Throwable t) {
            mLogger.error("Throwable in run(): {}", t.getMessage());
            mLogger.error("caused by: {}", t.getCause());
            mLogger.error("Stack trace: ", t);
            t.printStackTrace();
        }
    }

    protected abstract void runTask();

    protected abstract String getName();

    /**
     * Get minimum period in ms between successive runs of this task. If < 0, this task is assumed not to run
     * repeatedly.
     *
     * @return delay in milliseconds
     */
    public abstract int getPeriod();

    /**
     * Get the time at which this task should run (Hours/Minutes). Used in conjunction with getPeriod (e.g. 24 hours).
     * If this method returns a non-null value, this values takes precedence over {@see getInitialDelay}.
     *
     * @return String  specifying running time (HH:mm:ss) or null if not applicable
     */
    public abstract String getRunningTime();
}
