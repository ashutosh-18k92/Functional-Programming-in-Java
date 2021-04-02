package chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TransformingList {
    public static void main(String[] args) {
        /*suppose: we need to print all the names to uppercase*/

        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        /*We can use forEach() to iterate and do the trasnformation using an auxilary list
         * to store the result */
        friends.forEach(name -> System.out.print(name.toUpperCase() + " "));
        /*This works but we are not interested. why? because I have to introduce maps

         * */
        System.out.println();


        /*
         * Stream Interface
         * ----------------------
         * A Stream is much like an iterator on a collection of objects and
         * provides some nice fluent functions.
         * Using the methods of Stream we can compose a sequence of calls so
         * that the code reads and flows in the way we'd state problems
         * making it much easier to read.
         * */

        friends.stream()
                .map(name -> name.toUpperCase() + " ")
                .forEach(System.out::print);
        System.out.println();
        /*
         * stream() => is available on all collections in java 8
         * map() => applies given lambda expression or block of code
         * to each item in the collection - collects the result and
         * returns the result collection.
         * forEach() => prints the elements of the result collections*/

        /*map() -
         * -----------
         * => the transformation is arbitrary and
         * is applied on each element.
         * "Element type of the input doesn't have to
         * match the element type of output collection."
         */

        friends.stream()
                .map(name -> name.length() + " ")
                .forEach(System.out::print);
        System.out.println();


        /*Using Method Reference
         * -----------------------
         * If lambda expressions merely pass their parameters through,
         * we can replace them with method references.
         * i.e if lambda expressions are short - calls a direct instance
         * or static method on parameter.
         * We can't use method reference when we have to manipulate parameters
         * off the scope of instance or static methods.
         * */

        friends.stream()
                .map(String::toUpperCase)
                .map(name -> name + " ")
                .forEach(System.out::print);
        System.out.println();


        /*Filter
         * ---------
         * pick elements from a collection
         * filter() accepts a lambda expression that returns a boolean
         * filter() returns a subset of the collection it operates on */

        //collect all the names that starts with 'N'
        List<String> namesStartWithN = friends.stream()
                .filter(name -> name.startsWith("N"))
                .collect(Collectors.toList());
        System.out.println(namesStartWithN);

        /*Avoiding Code Duplication
         * -----------------------------
         * avoiding code duplication can also help improve performance
         * We can assign lambda Expressions to variables */

        final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
        final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
        //task count all names from friends , editors, and comrades starting with N

        /*filter() takes a reference of type Predicate  - java.util.function.Predicate*/
        final Predicate<String> startsWithN = name -> name.startsWith("N");

        System.out.println(friends.stream().filter(startsWithN).count());
        System.out.println(editors.stream().filter(startsWithN).count());
        System.out.println(comrades.stream().filter(startsWithN).count());


    }
}
