package compare.fpij;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Compare {
    private static final List<Person> people = Arrays.asList( new Person("John", 20),
                                            new Person("Sara", 21),
                                            new Person("Jane", 21),
                                            new Person("Greg", 35));

    private static final Comparator<Person> compareAscending =
            (person1, person2) -> person1.ageDifference(person2);

    private static  final Comparator<Person> compareDescending =
            compareAscending.reversed();


    public static void main(String[] args) {
        ascendingOrderByAgeLambdaExpression();
        ascendingOrderByAgeLambdaExpressionWithRoutingParameters();
        descendingOrderByAgeLambdaExpression();
        ascendingOrderByAgeUsingDefinedComparator();
        descendingOrderByAgeUsingDefinedComparator();
        ascendingOrderByNameLambdaExpression();
        findPersonWithMinimumAgeLambdaExpression();
        findPersonWithMaximumAgeLambdaExpression();
        orderByNameAndAgeLambdaExpression();

    }

    private static void ascendingOrderByAgeLambdaExpression() {
        List<Person> ascendingAge = people.stream()
                .sorted((person1, person2) -> person1.ageDifference(person2))
                .collect(Collectors.toList());
        printPeople("Sorting in ascending order by age :", ascendingAge);
    }

    /**
     * The parameter routing we want here is a bit different. We’ve seen a parameter being used as a
     * target in one case and as an argument in another case.
     *
     * In the current situation, however, we have two parameters and we want those to be split,
     * the first to be used as a target to the method and the second as an argument.
     *
     * The compiler took the parameters, the two person instances being compared,
     * and made the first the ageDifference() method’s target and the second the parameter.
    * */
    private static void ascendingOrderByAgeLambdaExpressionWithRoutingParameters() {
        List<Person> ascendingAge = people.stream()
                                            .sorted(Person::ageDifference)
                                            .collect(Collectors.toList());
        printPeople("Sorting in ascending order by age :", ascendingAge);
    }

    private static void descendingOrderByAgeLambdaExpression() {
        List<Person> descendingAge = people.stream()
                                            .sorted((person1, person2) -> person2.ageDifference(person1))
                                            .collect(Collectors.toList());
        printPeople("Sorting in descending order by age :", descendingAge);
    }

    private static void ascendingOrderByAgeUsingDefinedComparator() {
        List<Person> ascendingAge = people.stream()
                                            .sorted(compareAscending)
                                            .collect(Collectors.toList());
        printPeople("Sorting in ascending order by age :", ascendingAge);
    }

    private static void descendingOrderByAgeUsingDefinedComparator() {
        List<Person> descendingAge = people.stream()
                                            .sorted(compareDescending)
                                            .collect(Collectors.toList());
        printPeople("Sorting in descending order by age :", descendingAge);
    }

    private static void ascendingOrderByNameLambdaExpression() {
        printPeople("Sorting in ascending order by name:",
                people.stream()
                        .sorted((person1, person2) ->
                                person1.getName().compareTo(person2.getName()))
                        .collect(Collectors.toList())
                );
    }

    private static void ascendingOrderByNameComparatorByComparingMethodReference() {
        printPeople("Sorting in ascending order by name:",
                people.stream()
                        .sorted(Comparator.comparing(Person::getName))
                        .collect(Collectors.toList())
                );

        /**
         * The {@link Comparator#comparing(Function)} method takes an {@link Function} type.
         * The following example gives a more verbose version of the above code. In each version of {@link Function}
         * definition we are making the lambda expression more concise.
         * */

        Function<Person, String> nameExtractorVersion1 = new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        };

        Function<Person, String> nameExtractorVersion2 = (Person person) -> { return person.getName(); };

        Function<Person, String> nameExtractorVersion3 = person -> person.getName();

        Function<Person, String> nameExtractorVersion4 = Person::getName;
    }

    private static void findPersonWithMinimumAgeLambdaExpression() {
        people.stream()
                .min(Person::ageDifference)
                .ifPresent(youngest -> System.out.println("Youngest :"+youngest));
    }

    private static void findPersonWithMaximumAgeLambdaExpression() {
        people.stream()
                .max(Person::ageDifference)
                .ifPresent(eldest -> System.out.println("Eldest :" + eldest));
    }

    private static void orderByNameAndAgeLambdaExpression() {
        Function<Person, String> nameExtractor = Person::getName;
        Function<Person, Integer> ageExtractor = Person::getAge;

        List<Person> nameAndAge = people.stream()
                .sorted(Comparator.comparing(nameExtractor)
                                    .thenComparing(ageExtractor))
                .collect(Collectors.toList());
        printPeople("Sorting people by name and age ", nameAndAge);
    }

    private static void printPeople(String message, List<Person> person) {
        System.out.println(message);
        person.stream().forEach(System.out::println);
    }
}
