package chapter4.exceptions;

import java.io.File;
import java.util.stream.Stream;

public class HandleExceptions {

    /*In order to handle checked exceptions in lambdas we
    * could replace the return within the catch with a
    * throw new RuntimeException(ex); and propagate the
    * exceptions
    * we can improve code readability quite a bit by
    * creating static helpers for the catch and rethrow.*/


    /*If X were to throw one of many exceptions such as
    * IOException or SQLException, then the parametric type
    * X would need to be modeled as the least upper-bound  */
    private interface UseInstance<T,X extends Throwable> {
        void accept(T instance) throws X;
    }



    public static void main(String[] args) {

//        Stream.of("/usr")
//                .map(dir->new File(dir).getCanonicalPath())
//                .forEach(System.out::println);
    }




}
