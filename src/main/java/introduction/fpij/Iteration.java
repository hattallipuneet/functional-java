package introduction.fpij;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Iteration {

    private static final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public static void main(String[] args) {
        iterateExternallyByIndex();
        iterateExternallyByForEach();
        iterateInternallyByForEach();
        iterateInternallyExplicitTypeParamLambda();
        iterateInternallyImplicitTypeParamLambda();
        iterateInternallyMethodReferenceLambda();
    }

    private static void iterateExternallyByIndex() {
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }
    }

    private static void iterateExternallyByForEach() {
        for (String name : friends) {
            System.out.println(name);
        }
    }

    private static void iterateInternallyByForEach() {
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(final String name) {
                System.out.println(name);
            }
        });
    }

    private static void iterateInternallyExplicitTypeParamLambda() {
        friends.forEach((final String name) -> System.out.println(name));
    }

    private static void iterateInternallyImplicitTypeParamLambda() {
        friends.forEach((name) -> System.out.println(name));
    }

    private static void iterateInternallyMethodReferenceLambda() {
        friends.forEach(System.out::println);
    }
}
