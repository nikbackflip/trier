package tryer.refactoring.chapter1.movie;

public abstract class Movie {

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public abstract Double getTotalPrice(int daysInRent);

    public abstract Integer getFrequentPoints(int daysInRent);

    public String getTitle() {
        return title;
    }

}
