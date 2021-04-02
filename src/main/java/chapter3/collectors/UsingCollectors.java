package chapter3.collectors;

import chapter3.comparator.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsingCollectors {

    public static void main(String[] args) {

        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Becky", 18),
                new Person("Mona", 17),
                new Person("Kate", 15),
                new Person("Sara", 45),
                new Person("Jane", 21),
                new Person("Greg", 35));

        /*collect() is a reduce operation that helps in tranforming a collection
        * into another form, often mutable collection*/

        final List<Person> olderThan20 =new ArrayList<>();
                people.stream()
                .filter(person -> person.getAge()>20)
                .forEach(person -> olderThan20.add(person));
        System.out.println(olderThan20);

        /*collect() takes a stream of elements and gathers them
        * into a result container.
        * For that collect() needs to know 3 things
        * 1. how to make result container eg. ArrayList::new (Factory or Supplier)
        * and Operations to accumulate and combine.
        * 2. How to add single element to result container eg. ArrayList::add (accumulator)
        * 3. How to merge one result container into another (combiner)*/

        List<Person> adults = people.stream()
                .filter(person-> person.getAge()>20)
                //the first argument should be factory - how to make result container
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(adults);

        /*
        * One of the overloaded method collect()
        * takes in a Collectors as parameter
        * which can provide - supplier, accumulator,and combiner
        * at once for ease and resue.
        * Collectors provides a toList() convenience method that
        * creates an implementation of the Collector interface to
        * accumulate elements into an ArrayList.
        * */

        List<Person> early20s = people.stream()
                .filter(person -> person.getAge()>20)
                .collect(Collectors.toList());
        System.out.println(early20s);

        /*in addition to toList() there is
        * toSet() to accumulate in a set,
        * toMap() to gather in key-value pair,
        * joining() to concatenate the elements into a string*/


        /*Example of using toMap()*/
        Map<Integer,String> nameAgeMap =
                people.stream()
                .collect(Collectors.toMap(Person::getAge,Person::getName));

        /*Traversing*/
        nameAgeMap.forEach((key,value)-> System.out.println(key+"->"+value));

        /*Sorting a map based on key*/
       nameAgeMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach((entry)-> System.out.println(entry.getKey()+" "+entry.getValue()));


       /*Example joining()*/
        String allNames = people.stream()
                .map(Person::toString)
                .collect(Collectors.joining(","));
        System.out.println(allNames);
    }
}
