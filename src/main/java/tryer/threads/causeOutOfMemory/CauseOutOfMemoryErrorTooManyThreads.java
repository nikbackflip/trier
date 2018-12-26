package tryer.threads.causeOutOfMemory;

public class CauseOutOfMemoryErrorTooManyThreads {

    public static void main(String[] args) {

        System.out.println("CREATING A LOOOOOT OF THREADS");

        for (int i = 0; i < 1000000; i++) {
            System.out.println("Creating thread " + i);  //managed 11377 threads
            new Thread(() -> {
                try {
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                }
            }).start();
        }


    }


}
