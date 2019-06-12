package streams;

import javax.swing.text.html.Option;
import java.util.Optional;
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
        //although it is an infinite stream but since a match failed, further processing terminated
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

   //The findAny method returns an arbitrary element of the current stream.
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


    public static void main(String[] args) {

        anyMatchExample();
        allMatchExample();
        noneMatchExample();
        findAnyExample();
    }

}
