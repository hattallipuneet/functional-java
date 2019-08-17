package introduction.fpij;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PickNames {

    private static final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public static void main(String[] args) {

    }

    private static void forEachSyntaxVersion() {
        final List<String> startsWithN = new ArrayList<>();
        for (String name : friends) {
            if(name.startsWith("N")) {
                startsWithN.add(name);
            }
        }
    }

    private static void lambdaVersion() {
        friends.stream()
                .filter(name -> name.startsWith("N"))
                .collect(Collectors.toList());
    }
}
