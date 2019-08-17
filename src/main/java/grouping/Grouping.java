package grouping;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Grouping {

    private static final List<Person> people = Arrays.asList( new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35));

    public static void main(String[] args) {
        groupPeopleByAge();
        groupPeopleNamesByAge();
    }

    private static void groupPeopleByAge() {
         people.stream()
                .collect(Collectors.groupingBy(Person::getAge))
                .forEach((age, people) ->
                        System.out.println(String.format("%s", people))
                );
    }

    private static void groupPeopleByAgeVerboseLambdaParams() {
        /**
         * {@link Collectors#groupingBy(Function)} in above example takes an {@link Function}
         * type lambda expression.
         * */

        Function<Person, Integer> ageExtractorV1 = new Function<Person, Integer>() {
            @Override
            public Integer apply(Person person) {
                return person.getAge();
            }
        };

        Function<Person, Integer> ageExtractorV2 = (Person person) -> { return person.getAge(); };

        Function<Person, Integer> ageExtractorV3 = (person) -> person.getAge();

        Function<Person, Integer> ageExtractorV4 = Person::getAge;

        /**
         * {@link java.util.stream.Stream#forEach(Consumer)} method above used for printing the map details is passed an param
         * of type {@link BiConsumer}.
         * */

        BiConsumer<Integer, List<Person>> mapEntryConsumerV1 = new BiConsumer<Integer, List<Person>>() {
            @Override
            public void accept(Integer integer, List<Person> people) {
                System.out.println(people);
            }
        };

        BiConsumer<Integer, List<Person>> mapEntryConsumerV2 = (Integer integer, List<Person> person) -> {
            System.out.println(people);
        };

        BiConsumer<Integer, List<Person>> mapEntryConsumerV3 = (integer, people) -> System.out.println(people);
    }

    private static void groupPeopleNamesByAge() {
        people.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.mapping(Person::getName,
                                Collectors.toList())))
                .forEach((key, peopleNames) -> System.out.println(peopleNames));
    }

    private static void groupPeopleAndFindEldestPersonInEachGroup() {
        final Comparator<Person> byAge = Comparator.comparing(Person::getAge);
        people.stream()
                .collect(Collectors.groupingBy(person -> person.getName().charAt(0),
                        Collectors.reducing(BinaryOperator.maxBy(byAge))));
    }
}
