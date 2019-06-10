package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    //Filtering with a predicate
    public static void filterWithPredicate() {
        Stream<String> stringStream = Stream.of("abc","cde","abcd","zxcz","a","ab");
        //filter all strings having length greater than 3
        //the result will be collected to a list having {"abcd","zxcz"}
        Predicate<String> p = (s)->s.length()>3;
        //collect is a terminal operation
        List<String> filteredStrings = stringStream.filter(p).collect(Collectors.toList());
        filteredStrings.forEach(System.out::println);
    }

    //filter unique elements
    //important note : the distinct method works correctly only if
    // equals and hash code are implemented for
    //the object type in the stream
    public static void uniqueElements() {
        List<Integer> values = Arrays.asList(1,2,3,1,2,3,4,4,1,1,42,42,42);
        values.stream() //converts list to stream
                .distinct() //this will remove duplicates, it is an intermediate operation
                .forEach((x)->System.out.print(x+",")); //will print 1,2,3,4,42,

        //the below example runs without exception but does not filter unique elements
        //because the StringBuilder class does not implement hashcode and equals method
        /*List<StringBuilder> sbValues = Arrays.asList(new StringBuilder("a"),new StringBuilder("a"), new StringBuilder("b"));
        sbValues.stream().distinct().forEach((x)->System.out.print(x+","));*/
    }

    public static void main(String[] args) {
        filterWithPredicate();
        uniqueElements();
    }
}
