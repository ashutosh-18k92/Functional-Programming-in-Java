package chapter_2_using_collections;

/*Removing Duplication with Lexical Scoping*/


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LexicalScoping {
    /*Lexical Scoping
     * ----------------
     * is a powerful technique that lets us cache value from one
     * context to be used in other context*/

    //checkIfStartsWith() is a higher-order function that return a function
    //avoid this use - Lexical scoping results in race conditions
    public static Predicate<String> checkIfStartsWith(final String letter) {
        return str -> str.startsWith(letter); //lambda expr is said to be in closure of checkIfStartsWith
    }


    public static void main(String[] args) {


        /*Predicate<T> takes one parameter T and returns
        * a boolean result */

        /*Function<T,R> takes parameter of type T
        * and returns a result of type R*/

        // startsWithLetter refers a function that takes a String and returns a Predicate
        final Function<String, Predicate<String>> startsWithLetter1 =
                (String letter) -> {
                    return (String name) -> name.startsWith(letter);
                };

        // collapse the return statement
        final Function<String, Predicate<String>> startsWithLetter2 =
                (String letter) -> (String name) -> name.startsWith(letter);


        //let go the parens
        final Function<String, Predicate<String>> startsWithLetter3 =
                letter -> name -> name.startsWith(letter);

       /*
       * Overall we have created
       * - a function inside a function
       * - passed a function to a function
       * - returned a function from within a function
       * */


        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        long count = friends.stream()
                .filter(startsWithLetter3.apply("N"))  //Function.apply(parameter to predicate);
                .count();
        System.out.println(String.format("count %d", count));
    }


}
