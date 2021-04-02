package chapter5;

public class Notes_WorkingWithResources {
    /*Garbage Collection
    * ==================================
    * GC works when we working with internal resources
    * But when work with external resources GC is our responsibility
    * external resources such as databases, open files etc.
    *
    * JVM runs GC only when it doesn't have sufficient memory*/

    /*EAM pattern - execute around method - implement using lambdas*/


    /*AutoCloseable  - use try-with-resources
    * ----------------------------------------
    * I/O classes by default implement AutoCloseable
    * implement AutoCloseable if you are using anything that needs
    * a clean up after use
    * */

    /*Using lambdas to Clean up Resources
    * ------------------------------------------
    * It'd be great if the API we design could guide the programmers
    * and, with the compiler's help, point them in the right direction.

    * Lets write a FileWriterEAM*/


    /*Managing Locks
    * ---------------------------------------------
    * */




}
