package tryer.refactoring.chapter1;

import tryer.refactoring.chapter1.movie.Movie;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public Double getPrice() {
        return movie.getTotalPrice(daysRented);
    }

    public Integer getFrequentRentalPoints() {
        return movie.getFrequentPoints(daysRented);
    }

}
