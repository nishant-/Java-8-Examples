package streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStreams {

    public static void main(String[] args) {

        // create stream with explicit values using static method Stream.of
        Stream<String> stream = Stream.of("New York", "Sydney", "Bangalore", "Melbourne");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // create an empty Stream
        Stream<String> emptyStream =  Stream.empty();

        //create Stream from arrays
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        // create infinite streams
        // Stream.iterate
        //you should use iterate when you need to produce a sequence of successive values
        Stream.iterate(1, n ->  n + 2)
                .limit(100) // limits the infinite stream to 100 repetitions
                .forEach(System.out::println); // prints first 100 odd numbers odd numbers

        //print first 20 fibo numbers
        System.out.println("first 20 fibonacci numbers");
        Stream.iterate(new int[]{0, 1} , t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);


    }




}
