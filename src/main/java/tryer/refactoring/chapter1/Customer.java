package tryer.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public List<Rental> getRentals() {
        return rentals;
    }

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new Statement(this).getStatementString();
    }

}
