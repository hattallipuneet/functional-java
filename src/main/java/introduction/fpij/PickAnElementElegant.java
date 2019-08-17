package introduction.fpij;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickAnElementElegant {

    public static void main(String[] args) {
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        pickName(friends, "U");
    }

    public static void  pickName(List<String> names, String startsWith) {
        Optional<String> foundName = names.stream()
                                            .filter(name -> name.startsWith(startsWith))
                                            .findFirst();

        System.out.println(String.format("A name starting with %s %s",
                startsWith, foundName.orElse("not found")));

        foundName.ifPresent(name -> System.out.println("Hello" + name));
    }

}
