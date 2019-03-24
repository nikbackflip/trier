package tryer.threads.interruption;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BadTimedInterruption {

    public static void timedRun(
            Runnable r, long timeout, TimeUnit unit, ScheduledExecutorService cancelExec) {

        final Thread taskThread = Thread.currentThread();
        cancelExec.schedule(() -> taskThread.interrupt(), timeout, unit);
        r.run();

    }

    public static void main(String[] args) {

        timedRun(
                (Runnable) () -> System.out.println("wtf"),
                10, TimeUnit.SECONDS,
                new ScheduledThreadPoolExecutor(2)
        );

    }

}
