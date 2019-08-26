package partitioning;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Partition {

   public static void main(String[] args) {
        List<Student> students = Stream.of(
                new Student("Nikluas", 85),
                new Student("Hayley", 75),
                new Student("Marcel", 84),
                new Student("Finn", 35),
                new Student("Kol", 25),
                new Student("Rebecca", 70),
                new Student("Camille", 39)
        ).collect(Collectors.toList());


        Map<Boolean, List<Student>> passingFailing =
                students.stream().collect(Collectors.partitioningBy(ScoreUtil::hasPassed));

        if (passingFailing.containsKey(Boolean.FALSE)) {
            passingFailing.get(Boolean.FALSE)
                    .stream().forEach(System.out::println);
        }

    }
}
