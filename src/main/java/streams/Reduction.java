package streams;

import java.util.Optional;
import java.util.stream.Stream;

public class Reduction {

    //Reduction operations reduces the stream to a value
    //Also called fold

    //Form 1 - T reduce(T identity, BinaryOpertor<T> accumulator)
    public static void streamReductionForm1() {
        Stream<String> s = Stream.of("a", "c", "k");
        String reducedValue = s.reduce("", (x, y) -> x + y);//or s.reduce("",String::concat);
        System.out.println(reducedValue); //prints ack
    }

    //Form 2 - when identity is not specified, optional is returned Optional<T> reduce(BinaryOperator<T> accumulator)
    public static void streamReductionForm2() {
        Stream<String> s = Stream.of("a", "b", "c");
        Optional<String> reduced = s.reduce(String::concat);
        System.out.println(reduced.get());
    }

    //Form 3 -
    //reduce(identity, accumulator, combiner)
    //accumulator is a BiFunction,
    //combiner is a BinaryOperator
    public static void streamReductionForm3() {
        System.out.println(Stream.of("a", "b", "c", "d").reduce("i", (c, s1) -> c + s1, (s2, s3) -> s2 + s3));
        //the above prints iabcd as the result
    }

    public static void main(String[] args) {
        streamReductionForm1();
        streamReductionForm2();
        streamReductionForm3();
    }

}
