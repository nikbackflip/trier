package tryer.asserter;

public class AssertBehavior {

    static int sum(int a, int b) {
        assert (Integer.MAX_VALUE - a >= b) : "Value of " + a + " + " + b + " is too large to add.";
        final int result = a + b;
        assert (result - a == b) : "Sum of " + a + " + " + b + " returned wrong sum " + result;
        return result;
    }

    public static void main(String[] args) {

        int s = sum(Integer.MAX_VALUE, 1);

        System.out.println(s);

    }

}
