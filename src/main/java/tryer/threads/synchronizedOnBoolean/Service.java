package tryer.threads.synchronizedOnBoolean;

import java.util.Random;

@SuppressWarnings("all")
public class Service {

    private Boolean bool = true;

    private Random rand = new Random();

    public boolean getBool() {
        return bool;
    }

    public void setBool(boolean newBool) {
        bool = newBool;
    }


    public static void main(String[] args) {
        Service service = new Service();

        while (true) {
            new Thread(service.getBoolRunnable(service)).start();
            new Thread(service.setBoolRunnable(service)).start();
        }

    }

    public Runnable getBoolRunnable(Service service) {
        return () -> service.getBool();
    }

    public Runnable setBoolRunnable(Service service) {
        return () -> service.setBool(rand.nextBoolean());
    }



}
