package tryer.refactoring.chapter1;

import org.junit.Test;
import tryer.refactoring.chapter1.movie.ChildernsMovie;
import tryer.refactoring.chapter1.movie.NewReleaseMovie;
import tryer.refactoring.chapter1.movie.RegularMovie;

import static org.junit.Assert.*;

public class CustomerTest {

    private final String CUSTOMER_EXAMPLE = "default_customer";
    private final String MOVIE_EXAMPLE = "some_movie";
    private final String STATEMENT_EXAMPLE = "Rental Record for default_customer\n\tsome_movie\t2.0\n\tsome_movie\t1.5\n\tsome_movie\t9.0\nAmount owed is 12.500000\nYou earned 4 frequent renter points";


    @Test
    public void createStatementTest() {
        Customer newCustomer = new Customer(CUSTOMER_EXAMPLE);
        newCustomer.addRental(new Rental(new RegularMovie(MOVIE_EXAMPLE), 1));
        newCustomer.addRental(new Rental(new ChildernsMovie(MOVIE_EXAMPLE), 2));
        newCustomer.addRental(new Rental(new NewReleaseMovie(MOVIE_EXAMPLE), 3));

        String statement = newCustomer.statement();

        assertEquals(STATEMENT_EXAMPLE, statement);

    }



}
