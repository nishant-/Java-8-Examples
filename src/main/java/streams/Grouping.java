package streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grouping {

    public static void main(String[] args) {

        /*
         * public static <T,K> Collector<T,?,Map<K,List<T>>> groupingBy(Function<? super
         * T,? extends K> classifier)
         *
         * Returns a Collector implementing a "group by" operation on input elements of
         * type T, grouping elements according to a classification function, and
         * returning the results in a Map.
         */

        Stream<String> s = Stream.of("abc", "d", "ghi", "jkl", "abc", "df", "abc");
        Map<Integer, List<String>> grouped = s.collect(Collectors.groupingBy(x -> x.length()));
        System.out.println(grouped);


        /*
         * public static <T,K,A,D> Collector<T,?,Map<K,D>> groupingBy(Function<? super
         * T,? extends K> classifier, Collector<? super T,A,D> downstream)
         *
         * Returns a Collector implementing a cascaded "group by" operationon input
         * elements of type T, grouping elements according to aclassification function,
         * and then performing a reduction operation on the values associated with a
         * given key using the specified downstream Collector.
         */
        s = Stream.of("abc", "d", "ghi", "jkl", "abc", "df");
        Map<Integer, Set<String>> ss = s.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(ss);

        /*
         * public static <T,K,D,A,M extends Map<K,D>> Collector<T,?,M>
         * groupingBy(Function<? super T,? extends K> classifier, Supplier<M>
         * mapFactory, Collector<? super T,A,D> downstream)
         *
         * Returns a Collector implementing a cascaded "group by" operationon input
         * elements of type T, grouping elements according to aclassification function,
         * and then performing a reduction operation onthe values associated with a
         * given key using the specified downstream Collector. The Map produced by the
         * Collector is createdwith the supplied factory function.
         *
         */

        s = Stream.of("abc", "d", "ghi", "jkl", "abc", "df");
        Map<Integer, Set<String>> ss2 = s.collect(Collectors.groupingBy(x -> x.length(), TreeMap::new,Collectors.toSet()));
        System.out.println(ss2);
    }

}
