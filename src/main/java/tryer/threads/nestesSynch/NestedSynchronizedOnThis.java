package tryer.threads.nestesSynch;

public class NestedSynchronizedOnThis {


    public synchronized String syncInSync() {

        System.out.println("inside method");


        synchronized (this){
            System.out.println("inside block");
        }

        return "success";
    }


    public static void main(String[] args) {

        NestedSynchronizedOnThis nested = new NestedSynchronizedOnThis();

        System.out.println(nested.syncInSync());

    }



}
