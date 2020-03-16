package tryer.refactoring.chapter1;

import org.junit.Test;
import tryer.refactoring.chapter1.movie.ChildernsMovie;
import tryer.refactoring.chapter1.movie.NewReleaseMovie;
import tryer.refactoring.chapter1.movie.RegularMovie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Test
    public void test() {
        List<Person> persons = new ArrayList<Person>();
        Set<String> hobbySet1 = new HashSet<String>();
        hobbySet1.add("H1");
        hobbySet1.add("H2");
        hobbySet1.add("H3");

        Set<String> hobbySet2 = new HashSet<String>();
        hobbySet2.add("H2");
        hobbySet1.add("H4");

        Set<String> hobbySet3 = new HashSet<String>();
        hobbySet2.add("H3");

        Set<String> hobbySet4 = new HashSet<String>();
        hobbySet2.add("H4");

        persons.add(new Person("P1", hobbySet1));
        persons.add(new Person("P2", hobbySet2));
        persons.add(new Person("P3", hobbySet3));
        persons.add(new Person("P4", hobbySet4));

        Set<String> searchHobby = new HashSet<String>();
        searchHobby.add("H1");
        searchHobby.add("H3");

//        List<Person> res = persons.stream()
//                .filter(p -> p.getHobbies().contains())
//
//
//
//                )
//                        .collect(Collectors.toList());



    }






}




class Person {
    String name;
    Set<String> hobbies;

    public Person(String name, Set<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    public String getName(){
        return name;
    }

    public Set<String> getHobbies(){
        return hobbies;
    }
}