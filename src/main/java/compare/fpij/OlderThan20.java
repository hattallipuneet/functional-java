package compare.fpij;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class OlderThan20 {

    private static final List<Person> people = Arrays.asList( new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35));

    public static void main(String[] args) {

    }

    private static void filterPeopleOlderThan20() {
        List<Person> olderThan20 = people.stream()
                .filter(person -> person.getAge() > 20)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }


    /**
     * Following method shows the verbose versions of method references used in {@link java.util.stream.Stream#collect(Collector)}
     * method of {@link #filterPeopleOlderThan20()} implementation.
     *
     * */
    private static void filterPeopleOlderThan20Verbose() {

        /**
         *  ArrayList::new - It is passed in form of {@link Supplier} lambda expression.
         * */

        Supplier<ArrayList<Person>> personListFactoryVersion1 =
                new Supplier<ArrayList<Person>>() {
                    @Override
                    public ArrayList<Person> get() {
                        return new ArrayList<>();
                    }
                };

        Supplier<ArrayList<Person>> personListFactoryVersion2 = () -> new ArrayList<>();

        Supplier<ArrayList<Person>> personListFactoryVersion3 = ArrayList::new;

        /**
         * ArrayList::add - It is passed in form of {@link BiConsumer} lambda expression.
         * */

        BiConsumer<ArrayList<Person>, Person> listAddOperationVersion1 =
                new BiConsumer<ArrayList<Person>, Person>() {
                    @Override
                    public void accept(ArrayList<Person> people, Person person) {
                        people.add(person);
                    }
                };

        BiConsumer<ArrayList<Person>, Person> listAddOperationVersion2 =
                (ArrayList<Person> people, Person person) -> { people.add(person); };

        BiConsumer<ArrayList<Person>, Person> listAddOperationsVersion3 =
                (people, person) -> people.add(person);

        BiConsumer<ArrayList<Person>, Person> listAddOperationsVersion4 = ArrayList::add;

        /**
         * ArrayList::addAll - It is passed in form of {@link BiConsumer} lambda expression.
        * */

        BiConsumer<ArrayList<Person>, ArrayList<Person>> listAddAllOperationVersion1 =
                new BiConsumer<ArrayList<Person>, ArrayList<Person>>() {
                    @Override
                    public void accept(ArrayList<Person> accumulate, ArrayList<Person> people) {
                        accumulate.addAll(people);
                    }
                };

        BiConsumer<ArrayList<Person>, ArrayList<Person>> listAddAllOperationVersion2 =
                (ArrayList<Person> accumulate, ArrayList<Person> people) -> { accumulate.addAll(people); };

        BiConsumer<ArrayList<Person>, ArrayList<Person>> listAddAllOperationVersion3 =
                (accumulate, people) -> accumulate.addAll(people);

        BiConsumer<ArrayList<Person>, ArrayList<Person>> listAddAllOperationVersion4 = ArrayList::addAll;
     }

}
