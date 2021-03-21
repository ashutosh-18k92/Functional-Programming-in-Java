# Functional Programming in Java

## One of the best feature ever released in java - streams and lambdas. Think of it as SQL of java language. Very declarative, very concise and delivers a lot more than expected.

```java
final List<String> friends =
                Arrays.asList("Inky", "Pinky", "Blinky", "Sue", "Foo", "Bar","Paz");
``` 

### Iterating

#### Now how can we print the names of all our frieds
If you really have worked in java, you would do
```java
//This is the imperative style
for(String fried:friends) System.out.println(friend);

```
Take a look at this 
```java
    //using lambda
    friends.forEach((name) -> System.out.println(name));

    //for a single variable lambda allows us to omit parens
    friends.forEach(name -> System.out.println(name));

    //and finally using method reference
    friends.forEach(System.out::println);


```
Well It doesn't just ends here. A lot more to come...

