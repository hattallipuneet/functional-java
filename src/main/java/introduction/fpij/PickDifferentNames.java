package introduction.fpij;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PickDifferentNames {

    private static final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    private static final Predicate<String> STARTS_WITH_N = name -> name.startsWith("N");

    private static final Predicate<String> STARTS_WITH_B = name -> name.startsWith("B");

    private static final Function<String, Predicate<String>> STARTS_WITH_VERSION_1 = new Function<String, Predicate<String>>() {
        @Override
        public Predicate apply(String letter) {
            return new Predicate<String>() {
                @Override
                public boolean test(String o) {
                    return o.startsWith(letter);
                }
            };
        }
    };

    private static final Function<String, Predicate<String>> STARTS_WITH_VERSION_2 =
            (String letter) -> {
                Predicate<String> startsWith = (String name) -> {
                   return name.startsWith(letter);
                };
                return startsWith;
            };

    private static final Function<String, Predicate<String>> STARTS_WITH_VERSION_3 =
            (String letter) -> {
                return (String name) -> {
                    return name.startsWith(letter);
                };
            };

    private static final Function<String, Predicate<String>> STARTS_WITH_VERSION_4 =
            (String letter) -> (String name) -> name.startsWith(letter);

    private static final Function<String, Predicate<String>> STARTS_WITH_VERSION_5 =
            letter -> name -> name.startsWith(letter);

    public static void main(String[] args) {
        duplicateLambdaExpressions();
        usingHighOrderFunctionThatReturnsLambdaExpression();
        usingHigherOrderFunctionThatReturnsFunction();

    }

    private static void duplicateLambdaExpressions() {
        final long countFriendsStartN = friends.stream()
                .filter(STARTS_WITH_N)
                .count();

        System.out.println(countFriendsStartN);

        final long countFriendsStartB = friends.stream()
                .filter(STARTS_WITH_B)
                .count();

        System.out.println(countFriendsStartB);

    }

    private static void usingHighOrderFunctionThatReturnsLambdaExpression() {
        final long countFriendsStartN = friends.stream()
                .filter(checkIfStartsWith("N"))
                .count();

        System.out.println(countFriendsStartN);

        final long countFriendsStartB = friends.stream()
                .filter(checkIfStartsWith("B"))
                .count();

        System.out.println(countFriendsStartB);
    }

    private static void usingHigherOrderFunctionThatReturnsFunction() {
        final long countFriendsStartN =
                friends.stream()
                        .filter(STARTS_WITH_VERSION_5.apply("N")).count();
        final long countFriendsStartB =
                friends.stream()
                        .filter(STARTS_WITH_VERSION_3.apply("B")).count();
    }

    private static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }
}
