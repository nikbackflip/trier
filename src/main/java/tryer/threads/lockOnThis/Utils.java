package tryer.threads.lockOnThis;

import java.util.concurrent.TimeUnit;

public class Utils {

    public static void sleepSeconds(long time) {
        try { TimeUnit.SECONDS.sleep(time);} catch (InterruptedException ex) {}
    }

    public static void sleepMiliSeconds(long time) {
        try { TimeUnit.MILLISECONDS.sleep(time);} catch (InterruptedException ex) {}
    }

    public static void waitIt(Object lock) {
        try { lock.wait();} catch (InterruptedException ex) {}
    }

    public static void waitItForAMinute(Object lock) {
        try { lock.wait(60000);} catch (InterruptedException ex) {}
    }

}
