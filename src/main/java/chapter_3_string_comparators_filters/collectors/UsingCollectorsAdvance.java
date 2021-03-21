package chapter_3_string_comparators_filters.collectors;

import chapter_3_string_comparators_filters.comparator.Person;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class UsingCollectorsAdvance {
    /*We can also join multiple combine operations using
     * mapping(), collectingAndThen(), minBy(), maxBy(), groupingBy()
     * */

    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Becky", 18),
                new Person("Mona", 20),
                new Person("Kate", 18),
                new Person("Sara", 45),
                new Person("Jane", 20),
                new Person("Greg", 35));

        /*groupingBy() lets group people by their age*/

        Map<Integer, List<Person>> peopleByAge =
                people.stream()
                        .collect(groupingBy(Person::getAge));
        peopleByAge.entrySet().forEach(System.out::println);

        /*simple groupingBy() takes a lambda expression called as classifier funciton
         * that returns property on which we want to do the grouping.*/

        /*another variation , general groupingBy() collector, can apply yet
         * another collector to each bucket*/

        /*Example: group people by first letter of their name
         * further select the person of maximum age */

        Function<Person, Character> byFirstCharacter = person -> person.getName().charAt(0);
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);
        Map<Character, Optional<Person>> orderByFirstLetter =
                people.stream()
                        .collect(groupingBy(byFirstCharacter, reducing(BinaryOperator.maxBy(byAge))));

        orderByFirstLetter.entrySet().forEach(System.out::println);

    }
}
