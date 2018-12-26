package tryer.nullpointer;

import com.sun.istack.internal.NotNull;

public class NotNullAnnotation {

    private static void iDoNotAllowNulls(@NotNull String notNullString) {

        System.out.println("Length is " + notNullString.length());

    }

    public static void main(String[] args) {

        iDoNotAllowNulls(null);

    }

}
