public class Main
{
    public static void main(String args[])
    {
        process(true ? 1 : 2l);
    }

    static void process(Object object)
    {
        System.out.println(object instanceof Integer);
    }
}