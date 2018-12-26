package tryer.threads.notifyTry;

import static tryer.threads.lockOnThis.Utils.sleepSeconds;
import static tryer.threads.lockOnThis.Utils.waitIt;
import static tryer.threads.lockOnThis.Utils.waitItForAMinute;

@SuppressWarnings("all")
public class Service {

    public synchronized void method1(String info) {

        System.out.println(info + " from method1()");

        sleepSeconds(1);
        System.out.println(info + " did stuff one");

        sleepSeconds(1);
        System.out.println(info + " did stuff two");

        sleepSeconds(1);
        System.out.println(info + " did stuff three");

        waitItForAMinute(this);

        sleepSeconds(1);
        System.out.println(info + " did stuff four");

        sleepSeconds(1);
        System.out.println(info + " did stuff five");

        sleepSeconds(1);
        System.out.println(info + " did stuff six");

        System.out.println(info + " leaving method1()");

    }

    public synchronized void method2(String info) {

        System.out.println(info + " from method2()");

        sleepSeconds(1);
        System.out.println(info + " did stuff one");

        sleepSeconds(1);
        System.out.println(info + " did stuff two");

        sleepSeconds(1);
        System.out.println(info + " did stuff three");

        notify();

        sleepSeconds(1);
        System.out.println(info + " did stuff four");

        sleepSeconds(1);
        System.out.println(info + " did stuff five");

        sleepSeconds(1);
        System.out.println(info + " did stuff six");

        System.out.println(info + " leaving method2()");

    }


    public synchronized void method3(String info) {

        System.out.println(info + " from method3()");

        sleepSeconds(1);
        System.out.println(info + " did stuff one");

        sleepSeconds(1);
        System.out.println(info + " did stuff two");

        sleepSeconds(1);
        System.out.println(info + " did stuff three");

        sleepSeconds(1);
        System.out.println(info + " did stuff four");

        sleepSeconds(1);
        System.out.println(info + " did stuff five");

        sleepSeconds(1);
        System.out.println(info + " did stuff six");

        System.out.println(info + " leaving method3()");

    }


}
