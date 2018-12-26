package tryer.regex;

public class RegexMatcherTryer {

    public static void main(String[] args) {

        String str = "25570012,390001,910006,9710062,210116,12960017,3800008,2160016,9410004,13880130,73375,103603,5440055,5910002,43605,1660083,312305,4061665,236001 ";

        boolean matches = str.matches("(\\d+(,|))+");

        System.out.println(matches);


        int[] inte = new int[]{1,2,3};

    }



}
