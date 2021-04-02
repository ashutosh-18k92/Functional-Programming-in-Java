package chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

public class Reduction {

    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 16, 7, 8, 9, 10);

        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());

        //print the largest of the numbers
        Optional<Integer> largest = numbers
                .stream()
                .reduce((n1, n2) -> n1 >= n2 ? n1 : n2);
        largest.ifPresent(System.out::println);
        System.out.println(numbers.stream().max(Integer::compareTo));

        //join all numbers
        System.out.println(numbers
                .stream()
                .map(String::valueOf)
                .collect(joining(", ")));
    }
}
