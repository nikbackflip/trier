package tryer.refactoring.chapter1.movie;

public class NewReleaseMovie extends Movie {

    private static final int EACH_DAY_PRICE = 3;
    private final int FREQUENT_POINTS_ONE_DAY_RENT = 1;
    private final int FREQUENT_POINTS_LONG_RENT = 2;

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public Double getTotalPrice(int daysInRent) {
        return (double) daysInRent * EACH_DAY_PRICE;

    }

    @Override
    public Integer getFrequentPoints(int daysInRent) {
        if (1 == daysInRent) {
            return FREQUENT_POINTS_ONE_DAY_RENT;
        }
        return FREQUENT_POINTS_LONG_RENT;
    }

}
