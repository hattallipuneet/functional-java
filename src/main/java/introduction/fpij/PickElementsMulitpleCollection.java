package introduction.fpij;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PickElementsMulitpleCollection {

    private static final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    private static final List<String> editors =
            Arrays.asList("Brian", "Jackie", "John", "Mike");
    private static final List<String> comrades =
            Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

    private static final Predicate<String> startsWithN = name -> name.startsWith("N");

    public static void main(String[] args) {
        duplicateLambdaExpression();
        lambdaExpressoinWithDeclaredPredicate();
    }

    private static void duplicateLambdaExpression() {
        final long countFriendsStartWithN =
                friends.stream()
                    .filter(name -> name.startsWith("N"))
                    .count();

        System.out.println(countFriendsStartWithN);

        final long countEditorsStartWithN =
                editors.stream()
                        .filter(name -> name.startsWith("N"))
                        .count();

        System.out.println(countEditorsStartWithN);

        final long countComradesStartWithN =
                comrades.stream()
                    .filter(name -> name.startsWith("N"))
                    .count();

        System.out.println(countComradesStartWithN);
    }

    private static void lambdaExpressoinWithDeclaredPredicate() {
        final long countFriendsStartN = friends.stream()
                    .filter(startsWithN)
                    .count();

        System.out.println(countFriendsStartN);

        final long countEditorsStartsN = editors.stream()
                    .filter(startsWithN)
                    .count();

        System.out.println(countEditorsStartsN);

        final long countComradesStartN = comrades.stream()
                    .filter(startsWithN)
                    .count();

        System.out.println(countComradesStartN);
    }
}
