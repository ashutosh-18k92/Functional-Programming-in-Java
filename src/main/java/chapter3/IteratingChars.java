package chapter3;

public class IteratingChars {
    public static void main(String[] args) {

        /*
         * Iterating over a each character*/
        final String str = "ashutosh.18k92@outlook.com";
        str.chars()
                .mapToObj(ch -> (char) ch)
                .forEach(System.out::println);
    }
}
