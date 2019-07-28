package streams;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindingAndMatching {

    //anyMatch, returns a boolean if anyElement in the stream matches the predicate
    //it is a terminal operation
    //is there an element in the stream that matches the given predicate?
    public static void anyMatchExample() {
        Stream<String> s = Stream.of("a", "b", "c", "d");
        //as soon as a matching item is found,
        //remaining items in the stream will not be processed
        boolean result = s.anyMatch(x -> x.equals("b"));
        System.out.println(result);
    }

    //use allMatch to check if predicate matches all items in the stream
    //allMatch is a terminal operation
    public static void allMatchExample() {
        Stream<Integer> streamOfIntegers = Stream.iterate(2, x -> x * 2).limit(20);
        //returns true because all elements are divisible by 2
        boolean result = streamOfIntegers.allMatch(x -> x % 2 == 0);
        System.out.println(result);
        //the below example returns false.
        //although it is an infinite stream but since a match failed, further processing terminates
        result = Stream.iterate(1,x -> x + 1).allMatch(x -> x % 5 == 0);
        System.out.println(result);
    }

    //noneMatch is opposite of all match
    //returns true if none of the items in the stream match the predicate
    public static void noneMatchExample() {
        Stream<String> streamOfStrings = Stream.of("abc","def","ghij","klmnop");
        //the below will result in true because none of the strings in the stream have length greater than 10
        boolean result = streamOfStrings.noneMatch(x -> x.length() > 10);
        System.out.println(result);
    }

    //These three operations—anyMatch, allMatch, and noneMatch—make use of what we
    //call short-circuiting, a stream version of the familiar Java short-circuiting && and ||
    //operators.


   //The findAny method returns an Optional describing an arbitrary element of the current stream.
    //the below example also demonstrates how to use stream-builder
    //In a non-parallel operation, it will most likely return the first element
   // in the Stream but there is no guarantee for this.
    public static void findAnyExample() {
        Stream.Builder<String> stringStreamBuilder = Stream.builder();
        stringStreamBuilder.add("Quest");//returns this
        stringStreamBuilder.accept("Challenge"); //returns nothing
        stringStreamBuilder.accept("Another one"); //returns nothing
        stringStreamBuilder.accept("Yet another"); //returns nothing
        Stream<String> streamOfString = stringStreamBuilder.build();//stream is built
        Optional<String> value = streamOfString.findAny(); //returns an arbitrary item if found
        System.out.println(value.get());
    }

    //findFirst method returns an Optional describing the first element of the stream having an encounter order
    //the below example uses an IntStream
    public static void findFirstExample() {
        IntStream s = IntStream.iterate(1, x -> (x << 1));
        OptionalInt op = s.findFirst(); //returns the first element of the stream i.e. 1
        //not that the stream is infinite but the findFirst method returns immediately
        // after it finds the first element of the stream
        System.out.println(op.getAsInt());
    }

    //When to use findFirst or findAny?
    //Finding the first element is more constraining in parallel. If you don’t care about
    //which element is returned, use findAny because it’s less constraining when using
    //parallel streams.


    public static void main(String[] args) {

        anyMatchExample();
        allMatchExample();
        noneMatchExample();
        findAnyExample();
        findFirstExample();
    }

}
