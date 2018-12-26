package tryer.threads.lockOnThis;

import static tryer.threads.lockOnThis.Utils.sleepSeconds;
import static tryer.threads.lockOnThis.Utils.waitIt;

@SuppressWarnings("all")
public class Service {

    public void someSynchronizedMethod(String info) {

        System.out.println(info + " from someMethod()");

        synchronized (this) {
            System.out.println(info + " entered synchronized block");

            sleepSeconds(1);
            System.out.println(info + " did stuff one");

            sleepSeconds(1);
            System.out.println(info + " did stuff two");

            if (info.contains("wait")) {
                System.out.println(info + " is waiting");
                waitIt(this);
                System.out.println(info + " stoped waiting");
            }

            sleepSeconds(1);
            System.out.println(info + " did stuff three");

            sleepSeconds(1);
            System.out.println(info + " did stuff four");

            if (info.contains("notif")) {
                System.out.println(info + " notifies");
                this.notify();
            }

            sleepSeconds(1);
            System.out.println(info + " did stuff five");

            sleepSeconds(1);
            System.out.println(info + " did stuff six");

            System.out.println(info + " leaving synchronized block");
        }

    }

    public void someSynchronizedMethod2(String info) {

        System.out.println(info + " from someMethod()");

        synchronized (this) {
            System.out.println(info + " entered synchronized block");

            sleepSeconds(1);
            System.out.println(info + " did stuff one");

            sleepSeconds(1);
            System.out.println(info + " did stuff two");

            if (info.contains("wait")) {
                System.out.println(info + " is waiting");
                waitIt(this);
                System.out.println(info + " stoped waiting");
            }

            sleepSeconds(1);
            System.out.println(info + " did stuff three");

            sleepSeconds(1);
            System.out.println(info + " did stuff four");

            if (info.contains("notif")) {
                System.out.println(info + " notifies");
                this.notify();
            }

            sleepSeconds(1);
            System.out.println(info + " did stuff five");

            sleepSeconds(1);
            System.out.println(info + " did stuff six");

            System.out.println(info + " leaving synchronized block");
        }

    }




    public void someUnsynchronizedMethod(String info) {

        System.out.println(info + " entered unsynchronized method");

        sleepSeconds(1);
        System.out.println(info + " did stuff one");

        sleepSeconds(1);
        System.out.println(info + " did stuff two");

        if (info.contains("wait")) {
            System.out.println(info + " is waiting");
            waitIt(this);
            System.out.println(info + " stoped waiting");
        }

        sleepSeconds(1);
        System.out.println(info + " did stuff three");

        sleepSeconds(1);
        System.out.println(info + " did stuff four");

        if (info.contains("notif")) {
            System.out.println(info + " notifies");
            this.notify();
        }

        sleepSeconds(1);
        System.out.println(info + " did stuff five");

        sleepSeconds(1);
        System.out.println(info + " did stuff six");

        System.out.println(info + " leaving unsynchronized method");

    }


}
