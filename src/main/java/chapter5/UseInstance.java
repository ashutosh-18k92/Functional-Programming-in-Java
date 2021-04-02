package chapter5;



/*an ideal candidate for the java compiler to automatically synthesize
* from lambda expressions or method references. */
@FunctionalInterface  // is optional
public interface UseInstance<T,X extends Throwable> {
    public void accept(T instance) throws X;
}
