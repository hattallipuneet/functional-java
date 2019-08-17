package introduction.fpij;

import java.util.Arrays;
import java.util.List;

public class PrintList {

    private static final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public static void main(String[] args) {
        System.out.println(String.join(", ", friends));
    }
}
