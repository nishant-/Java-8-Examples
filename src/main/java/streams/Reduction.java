package streams;

import java.util.Optional;
import java.util.OptionalInt;
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

    //using Form 1
    //Form 1 - T reduce(T identity, BinaryOpertor<T> accumulator)
    public static void productExampleUsingStream() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //mapping to int is required because * operator does not apply to boxed types.
        int product = integerStream.map(x -> x.intValue()).reduce(1, (a, b) -> a * b);
        System.out.println(product);
    }

    //Finding maximum and minimum using reduction
    public static void findMaxMinByReduction() {
        //Form 1 is applied in both cases and optional is returned
        Stream<Integer> aStream = Stream.iterate(1, x -> x - 1).limit(100);
        Optional<Integer> max = aStream.reduce(Integer::max);
        System.out.println("max = " + max.get());//prints 1, because stream of negative numbers is generated,
        //the stream will be  generated like {1, (1-1)=0 , (0-1) = -1, (-1 -1) = -2, ..... }
        Optional<Integer> min = Stream.of(-1, -2, -3, -4).reduce(Integer::min);
        System.out.println("min = " + min.get()); //prints -4
    }


    public static void main(String[] args) {
        streamReductionForm1();
        streamReductionForm2();
        streamReductionForm3();
        productExampleUsingStream();
        findMaxMinByReduction();
    }

}
