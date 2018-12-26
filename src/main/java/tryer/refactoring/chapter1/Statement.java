package tryer.refactoring.chapter1;

import tryer.refactoring.chapter1.Customer;
import tryer.refactoring.chapter1.Rental;

import java.util.List;

public class Statement {

    private Double totalPrice;
    private Integer frequentRentalPoints;
    private List<Rental> rentals;
    private String customerName;

    private final String statementTemplate = "Rental Record for %s\n%sAmount owed is %f\nYou earned %d frequent renter points";

    public Statement(Customer customer) {
        this.rentals = customer.getRentals();
        this.customerName = customer.getName();

        this.totalPrice = calculatePriceForRentals(rentals);
        this.frequentRentalPoints = calculateFrequentRenalPointsForRentals(rentals);
    }

    public String getStatementString() {
        return String.format(statementTemplate, customerName, getDetailedList(), totalPrice, frequentRentalPoints);
    }

    private String getDetailedList() {
        StringBuilder builder = new StringBuilder();
        rentals.forEach(rental -> {
            builder.append("\t");
            builder.append(rental.getMovie().getTitle());
            builder.append("\t");
            builder.append(rental.getPrice());
            builder.append("\n");
        });
        return builder.toString();
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Integer getFrequentRentalPoints() {
        return frequentRentalPoints;
    }

    private Double calculatePriceForRentals(List<Rental> rentals) {
        return rentals.stream()
                .mapToDouble(Rental::getPrice)
                .sum();
    }

    private Integer calculateFrequentRenalPointsForRentals(List<Rental> rentals) {
        return rentals.stream()
                .mapToInt(Rental::getFrequentRentalPoints)
                .sum();
    }



}
