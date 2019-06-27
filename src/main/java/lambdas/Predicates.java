package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Predicates {

    //The java.util.function.Predicate<T> interface defines an abstract method named
    //test that accepts an object of generic type T and returns a boolean.

    //Example

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t: list) {
            if(p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    public static void main(String[] args) {

        Predicate<Integer> oddNumberPredicate = x -> x % 2 != 0;
        List<Integer> intList = IntStream.iterate(2 , x -> x +1)
                .limit(100)
                .boxed()
                .collect(Collectors.toList());

        intList = filter(intList, oddNumberPredicate);
        intList.forEach(System.out::println);


    }
}
