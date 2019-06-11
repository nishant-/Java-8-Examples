package streams;

import java.util.stream.Stream;

public class FindingAndMatching {

    //anyMatch, returns a boolean if anyElement in the stream matches the predicate
    //it is a terminal operation
    public static void anyMatchExample() {
        Stream<String> s = Stream.of("a","b","c","d");
        boolean result = s.anyMatch(x->x.equals("d"));
        System.out.println(result);
    }

    //use allMatch to check if predicate matches all items in the stream


    public static void main(String[] args) {

        anyMatchExample();
    }

}
