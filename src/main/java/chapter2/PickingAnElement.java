package chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickingAnElement {
    //smelly code
    public static String pickName(final List<String> names, String letter) {
        for (String name : names)
            if (name.startsWith(letter)) return name;
        return "No Match Found";
    }

    //better way
    public static String pickNameV2(final List<String> names, String letter) {
        final Optional<String> foundName =
                names.stream()
                        .filter(name -> name.startsWith(letter))
                        .findFirst();
        return foundName.orElse("was not Found");
    }


    public static void main(String[] args) {
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final String letter = "d";
        System.out.println(String.format("A Name starting with %s : %s",letter,pickNameV2(friends,letter)));

    }

}
