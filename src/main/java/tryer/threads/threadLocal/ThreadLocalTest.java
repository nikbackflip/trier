package tryer.threads.threadLocal;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

    private final Set<String> set = new HashSet();

    private void tryModifyFinalMap() {
        set.add("string");
    }

    private ThreadLocal<String> stringsPerThread = new ThreadLocal<>()
            .withInitial(() -> {
                Random ran = new Random();
                return String.valueOf(ran.nextInt());
            });

}


class Holder {
    private int n;
    public Holder(int n) { this.n = n; }
    public void assertSanity() {
        if (n != n)
            throw new AssertionError("This statement is false.");
    }
}
