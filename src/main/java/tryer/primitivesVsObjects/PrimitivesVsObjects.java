package tryer.primitivesVsObjects;

public class PrimitivesVsObjects {

    private static void changePrimitives(int a, int b) {
        System.out.println("entering changePrimitives");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        a++; b++;

        System.out.println("exiting changePrimitives");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }

    private static void changeObjects(Integer a, Integer b) {
        System.out.println("entering changeObjects");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        a++; b++;

        System.out.println("exiting changeObjects");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }


    private static void primitivesTest() {
        Integer a = 0;
        Integer b = 0;

        System.out.println("entering primitivesTest");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        changePrimitives(a, b);

        System.out.println("exiting primitivesTest");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }

    private static void objectsTest() {
        Integer a = 0;
        Integer b = 0;

        System.out.println("entering objectsTest");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        changePrimitives(a, b);

        System.out.println("exiting objectsTest");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }

    public static void main(String[] args) {
        primitivesTest();

        System.out.println("===============================================");

        objectsTest();

    }




}
