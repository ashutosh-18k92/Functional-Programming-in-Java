package chapter2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class IteratingThroughList {
    public static void main(String[] args) {
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");


        /*External Iterators
        * --------------------
        * */
        System.err.println("External Iterator - Imperative style");

        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        System.out.println("Iterator interface explicit");
        Iterator<String> iterator = friends.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        /*Under the hood: uses the iterator interface
        * and calls its hasNext() and next() Methods */
        System.out.println("Iterator interface implicit");
        System.out.println();
        for (String friend : friends) {
            System.out.println(friend);
        }




        /*Internal Iterators
        ---------------------------
        * with internal iterations we willfully turn over
        * the most of the hows to underlying
        * libraries and focus on the essential whats
        * the Iterator interface has been enhanced in java 8
        * with a new method forEach().
        * forEach() accepts a type of Consumer that consumes
        * through its accept() method.
        * */


        /* we invoke for each on friends
        * forEach invokes accept() for given Consumer
        * for each element in the collection
        * and let it do whatever it wants to do with it.
        * */
        System.out.println("Internal Iterators - Declarative Style");
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        /* As for the benefit, we went from specifying how to iterate
        * to focusing on what to do for each element.
        *
        * Further we can replace the anonymous inner class with
        * a Lambda expression*/

        /* The forEach() is a higher-order function that accepts a
        * a lambda expression or a block of code to execute in the
        * context of each element in the list. */

        /*Lambda Expressions
        * --------------------
        * lambdas help us to concisely iterate over a collection
        * help remove mutability and make the code more concise
        * when transforming a collections.*/

        friends.forEach((name) -> System.out.println(name));

        //for a single variable lambda allows us to omit parens
        friends.forEach(name -> System.out.println(name));

        //using method reference
        friends.forEach(System.out::println);
    }
}
