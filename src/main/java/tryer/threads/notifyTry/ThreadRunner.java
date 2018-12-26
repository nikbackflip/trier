package tryer.threads.notifyTry;

import static tryer.threads.lockOnThis.Utils.sleepMiliSeconds;

@SuppressWarnings("all")
public class ThreadRunner {

    private Service service = new Service();

    public Runnable getRunnableForMETHOD1(String info) {
        return () -> {
            service.method1(info);
            String threadName = Thread.currentThread().getName();
        };

    }

    public Runnable getRunnableForMETHOD2(String info) {
        return () -> {
            service.method2(info);
            String threadName = Thread.currentThread().getName();
        };

    }

    public Runnable getRunnableForMETHOD3(String info) {
        return () -> {
            service.method3(info);
            String threadName = Thread.currentThread().getName();
        };
    }


    public static void test() {
        ThreadRunner thisRunner = new ThreadRunner();

        Thread thread1 = new Thread(thisRunner.getRunnableForMETHOD1("thread_1"));
        Thread thread2 = new Thread(thisRunner.getRunnableForMETHOD2("thread_2"));

        thread1.start();
        sleepMiliSeconds(500);
        thread2.start();
    }

    public static void main(String[] args) {

        test();

    }


}
