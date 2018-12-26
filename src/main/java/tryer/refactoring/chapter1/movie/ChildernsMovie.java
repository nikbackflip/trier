package tryer.refactoring.chapter1.movie;

public class ChildernsMovie extends Movie {

    private final double FIRST_THREE_DAYS_PRICE = 1.5;
    private final double AFTER_THREE_DAYS_PRICE = 1.5;

    private final int FREQUENT_POINTS = 1;

    public ChildernsMovie(String title) {
        super(title);
    }

    @Override
    public Double getTotalPrice(int daysInRent) {
        Double priceForRent = FIRST_THREE_DAYS_PRICE;
        if (daysInRent > 3)
            priceForRent += (daysInRent - 3) * AFTER_THREE_DAYS_PRICE;
        return priceForRent;
    }

    @Override
    public Integer getFrequentPoints(int daysInRent) {
        return FREQUENT_POINTS;
    }

}
