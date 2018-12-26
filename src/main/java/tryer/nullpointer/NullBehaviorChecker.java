package tryer.nullpointer;

public class NullBehaviorChecker {

    private String notInitializedString;

    public static void main(String[] args) {

        NullBehaviorChecker checker = new NullBehaviorChecker();
        System.out.println(checker.notInitializedString);

    }

}
