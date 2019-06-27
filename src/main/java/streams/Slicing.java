package streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Slicing {

    //Streams support the limit(n) method, which returns another stream that’s no longer
    //than a given size. The requested size is passed as argument to limit.
    public static void limitStream() {
        Stream<Integer> s = Stream.iterate(1, x -> x + 1);
        //limits the stream size to 10
        //limit is an intermediate operation, it results in another stream of size n, 10 in this example
        s.limit(10).forEach(x -> System.out.print(x + ","));
    }

    //the skip method returns a stream where the first n elements are discarded
    public static void skipStream() {
        IntStream intStream = IntStream.rangeClosed(1, 20);
        //skips the first 10 items of the stream;
        //skip is an intermediate operation,
        intStream.skip(10).forEach(x -> System.out.print(x + ","));
    }

    public static void main(String[] args) {
        skipStream();
        limitStream();

    }


}
