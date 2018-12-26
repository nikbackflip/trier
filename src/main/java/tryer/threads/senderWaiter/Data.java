package tryer.threads.senderWaiter;


@SuppressWarnings("all")
public class Data {

    private String packet;

    // True if receiver should wait, sender is working
    // False if sender should wait, reciever is working
    private boolean transfer = true;

    private boolean senderIsWorking() {
        return transfer ? true : false;
    }

    private boolean recieverIsWorking() {
        return transfer ? false : true;
    }

    private void senderFinished() {
        transfer = false;
    }

    private void recieverFinished() {
        transfer = true;
    }

    public synchronized void send(String packet) {
//        while (recieverIsWorking()) {
//            try {
//                System.out.println("    sender is waiting for reciever to finish work");
//                wait();
//            } catch (InterruptedException e)  {
//                Thread.currentThread().interrupt();
//                System.out.println("Thread interrupted");
//                e.printStackTrace();
//            }
//        }
//
//        senderFinished();

        this.packet = packet;
//        notifyAll();
    }

    public synchronized String receive() {
//        while (senderIsWorking()) {
//            try {
//                System.out.println("    reciever is waiting for sender to finish work");
//                wait();
//            } catch (InterruptedException e)  {
//                Thread.currentThread().interrupt();
//                System.out.println("Thread interrupted");
//                e.printStackTrace();
//            }
//        }
//
//        recieverFinished();

//        notifyAll();
        return packet;
    }

}
