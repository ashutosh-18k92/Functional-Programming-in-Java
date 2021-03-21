package chapter_3_string_comparators_filters.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Compare {
    static void printPeople(final String msg, final List<Person> people) {
        System.out.println(msg);
        people.forEach(System.out::println);
    }

    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 45),
                new Person("Jane", 21),
                new Person("Greg", 35));

        List<Person> sortedByAge = people.stream()
                .sorted((p1, p2) -> p1.ageDifference(p2))
                .collect(Collectors.toList());

        printPeople("People sorted by Age", sortedByAge);

        /*The parameter routing in JDK 8 is really really smart
         * Compiler picked two person instances being compared
         * made the first method target and other method parameter*/

        sortedByAge = people.stream()
                .sorted(Person::ageDifference)  //This is a next level parameter routing
                .collect(Collectors.toList());

        printPeople("Sorted Again with advanced parameter routing", sortedByAge);

        /*Creating comparators on the go*/
        Comparator<Person> ascendingOrder = Comparator.comparingInt(Person::getAge);
        Comparator<Person> descendingOrder = ascendingOrder.reversed();

        printPeople("Ascending Order ", people.stream().sorted(ascendingOrder).collect(Collectors.toList()));
        printPeople("Descending Order", people.stream().sorted(descendingOrder).collect(Collectors.toList()));

        /*Picking up the youngest person in list*/
        Person youngestPerson = people.stream()
                .min(Person::ageDifference).get();
        System.out.println("Youngest: " + youngestPerson);

        /*Picking up the eldest person in the list*/
        people.stream()
                .max(Person::ageDifference)
                .ifPresent(person -> System.out.println("Eldest: " + person));

        /*Sort people in alphabetic order */
        Comparator<Person> alphasort = comparing(Person::getName);
        printPeople("alphabetically sorted people",people.stream()
                .sorted(alphasort).collect(Collectors.toList()));

        Function<Person,Integer> byAge = Person::getAge;
        Function<Person,String> byName = Person::getName;
        people.stream()
                .sorted(comparing(byName)
                        .thenComparing(byAge))
                .forEach(System.out::println);
    }
}
