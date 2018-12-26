package tryer.threads.lockOnThis;

import static tryer.threads.lockOnThis.Utils.sleepMiliSeconds;

@SuppressWarnings("all")
public class ThreadRunner {

    private Service service = new Service();

    public Runnable getRunnableForSynchronizedMethod(String info) {
        return () -> {
            service.someSynchronizedMethod(info);
            String threadName = Thread.currentThread().getName();
        };

    }

    public Runnable getRunnableForSynchronizedMethod2(String info) {
        return () -> {
            service.someSynchronizedMethod(info);
            String threadName = Thread.currentThread().getName();
        };

    }

    public Runnable getRunnableForUnsynchronizedMethod(String info) {
        return () -> {
            service.someUnsynchronizedMethod(info);
            String threadName = Thread.currentThread().getName();
        };
    }

    /**
        start
     waiter enters synchronized block, notifier waits
     waiter does stuff one, stuff two, then waits
     notifier does stuff one, stuff two, stuff three, stuff four, notifies waiter, does stuff five, stuff six
     waiter does stuff three, stuff four, stuff five, stuff six
        end

     */
    public static void synchronyzedMethodTest() {
        ThreadRunner thisRunner = new ThreadRunner();

        Thread thread0 = new Thread(thisRunner.getRunnableForSynchronizedMethod("waiter"));
        Thread thread1 = new Thread(thisRunner.getRunnableForSynchronizedMethod2("    notifier"));

        thread0.start();
        sleepMiliSeconds(500);
        thread1.start();
    }

    public static void unsynchronyzedMethodTest() {
    }


    public static void main(String[] args) {
        ThreadRunner thisRunner = new ThreadRunner();

        Thread thread0 = new Thread(thisRunner.getRunnableForSynchronizedMethod("sync"));
        Thread thread1 = new Thread(thisRunner.getRunnableForUnsynchronizedMethod("notSync"));
        thread0.start();
        sleepMiliSeconds(500);
        thread1.start();

    }


}
