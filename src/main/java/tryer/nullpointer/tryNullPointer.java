package tryer.nullpointer;

public class tryNullPointer {

    public void one() {
        new tryNullPointer().two();
    }

    public void two() {
        String s = "";
        s = null;
        s.toString();
    }

    public static void main(String[] args) {
        tryNullPointer n = new tryNullPointer();

        try {
            n.one();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }




}
