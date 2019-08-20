package stream.collectors;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollectors {

    public static void main(String[] args) {
        Friend ross = new Friend("Ross", 1,27);
        Friend mike = new Friend("Mike", 2,25);
        Friend monica = new Friend("Monica", 3,28);
        Friend rachel = new Friend("Rachel", 4,27);
        Friend joey = new Friend("Ross", 5,28);
        Friend chandler = new Friend("Chandler", 6,30);
        Friend phoebe = new Friend("Phoebe", 7,31);

        List<Friend> friends = Stream.of(ross, mike, monica, rachel, joey, chandler, phoebe)
                                      .collect(Collectors.toList());

        Map<Integer, List<Friend>> groupByAge = friends.stream()
                                                    .collect(Collectors.groupingBy(Friend::getAge,
                                                        Collectors.toCollection(LinkedList::new)));

        groupByAge.forEach((key, value) -> {
            System.out.println(value.getClass().getSimpleName());
        });
    }
}
