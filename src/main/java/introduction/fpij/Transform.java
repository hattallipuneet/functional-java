package introduction.fpij;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {

    private static final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public static void main(String[] args) {

    }

    private static void forEachSyntaxTransform() {
        for (String name: friends) {
            System.out.println(name.toUpperCase());
        }
    }

    private static void foreachMethodTransform() {
        final List<String> uppercaseName = new ArrayList<>();
        friends.forEach((name) -> uppercaseName.add(name.toUpperCase()));
        System.out.println(uppercaseName);
    }

    private static void streamAPILambdaTransform() {
        friends.stream()
                .map((name) -> name.toUpperCase())
                .forEach(name -> System.out.println(name));
    }

    private static void streamApiMethodReferenceTransform() {
        friends.stream()
                .map(String::toUpperCase)
                .forEach(System.out::print);
    }
}
