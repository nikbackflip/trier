package tryer.refactoring.chapter1.movie;

public class RegularMovie extends Movie {

    private final double FIRST_TWO_DAYS_PRICE = 2.0;
    private final double AFTER_TWO_DAYS_PRICE = 1.5;

    private final int FREQUENT_POINTS = 1;

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public Double getTotalPrice(int daysInRent) {
        Double priceForRent = FIRST_TWO_DAYS_PRICE;
        if (daysInRent > 2)
            priceForRent += (daysInRent - 2) * AFTER_TWO_DAYS_PRICE;
        return priceForRent;
    }

    @Override
    public Integer getFrequentPoints(int daysInRent) {
        return FREQUENT_POINTS;
    }
}
