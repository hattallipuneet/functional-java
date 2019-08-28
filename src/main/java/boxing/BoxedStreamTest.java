package boxing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxedStreamTest {

    public static void main(String[] args) {
        // create an collection of integers from primitive int arrays
        List<Integer> integerList =  IntStream.of(1,2,3,4,4)
                                                .boxed()
                                                .collect(Collectors.toList());

        integerList.forEach(System.out::println);

    }
}
