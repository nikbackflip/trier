package tryer.stringformatter;

import java.util.UnknownFormatConversionException;

public class StringFormatter {

    public static void main(String[] args) {

        String template = "blahblah: %Rto";
        try {
            String result = String.format(template, "success");
        } catch (UnknownFormatConversionException ex) {
            System.out.println("\"" + template + "\" cannot be formatted: " + ex.toString());
        }

    }


}
