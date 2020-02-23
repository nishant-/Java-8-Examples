package misc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MapAndCollectionMethodEnhancements {

    public static void main(String[] args) {

        //map ehancements
        // V compute(K key, BiFunction<? super K, ? super V, ? extends V remappingFunction)
        //it is a default method in java.util.map
        //attempts to compute a mapping for the specified key and its current mapped value (or null if thereis no current mapping)

        Map<String, Integer> map = new HashMap<>();
        int v1 = map.compute("A", (k, v) -> (v == null) ? 0 : v + 1);//v1 = 0 since v=null at this stage
        System.out.println("map v1 = " + map);
        int v2 = map.compute("A", (k, v) -> (v == null) ? 0 : v + 1);//v2 = 1 since v=0 at this point
        int v3 = map.compute("B", (k, v) -> (v == null) ? 0 : v + 1);
        System.out.println(map);
        System.out.println(v1 + ", " + v2 + ", " + v3); //prints 0, 1, 0

        //V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
        //default method in the java.util.map interface
        //if the key is not associated with value or is null then this function attempts to compute the value based on the mapping function
        int m = 0;
        Function<String, Integer> mappingFunction = l -> m + 1;
        map = new HashMap<>();
        int val1 = map.computeIfAbsent("A", mappingFunction);//value is computed as 1
        int val2 = map.computeIfAbsent("A", mappingFunction);//since there is a value for this key already same key is returned
        int val3 = map.computeIfAbsent("B", mappingFunction);//value is computed as 1
        System.out.println(map);
        System.out.println(val1 + ", " + val2 + ", " + val3);
        //map.forEach(BiConsumer<? super K, super V> action)
        map.forEach((k, v) -> System.out.println("x = " + k + ", y = " + v));

        //V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
        //It is a default method in java.util.Map interface,
        //which does the following:
        //if the value for the specified key is present and non-null, attempts to compute a new mapping given the key and its current mapped value.
        //if key is found bifunction executes, if key not found bifunction is not invoked.
        //if bifunction returns null, value is removed from the map
        BiFunction<String, Integer, Integer> biFunc = (x, y) -> y > 0 ? y + 1 : y;
        map = new HashMap<>();
        Object val11 = map.computeIfPresent("A", biFunc);//val11 = null because no mapping exists
        map.put("A", 5);
        Object val22 = map.computeIfPresent("A", biFunc); //vl22 = 6 because key A has a mapping and biFunc is applied
        Object val33 = map.computeIfPresent("B", biFunc); //val33 = null because no mapping exists
        System.out.println(map);
        System.out.println(val11 + ", " + val22 + ", " + val33);

        //map.forEach(BiConsumer<? super K, super V> action)
        map.forEach((k, v) -> System.out.println("x = " + k + ", y = " + v));


        //removeIf method in collection. Note that this method returns true if any elements were removed
        //it is a default method in the collection interface
        //it will be available to all classes that implement the Collection interface
        //remove all such elements in a collection that match a predicate
        Set<String> cities = new HashSet<>();
        cities.addAll(Arrays.asList("Delhi", "Singapore", "Melbourne", "San Jose"));
        boolean x = cities.removeIf(s -> s.startsWith("D"));
        System.out.println(cities + ", " + x);


        //replaceAll method in the list interface
        //default void replaceAll(UnaryOperator<E> operator)
        //Replaces each element of this list with the result of applying the operator to that element.
        //Errors or runtime exceptions thrown by the operator are relayed to the caller.
        UnaryOperator<Integer> doubleIt = z -> z * 2;
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        intList.replaceAll(doubleIt);
        intList.forEach(System.out::println);


        //merge method
        System.out.println("beforee merge " + map);
        Object val = map.merge("A", 9, (o, p) -> null); //mpping function returns null value will be removed
        System.out.println("returned val = " + val);
        System.out.println(map);

        Object afterMaergeVal = map.merge("D", 1, (o, p) -> o + p);//key = D does not exist, k=D, v=1 is put in the map
        System.out.println("after merge val = " + afterMaergeVal);
        System.out.println("map before applying merge = " + map);
        afterMaergeVal = map.merge("D", 2, (o, p) -> o + p);//key = D exists, mapping function will apply and key value will be updated
        System.out.println("after merge val = " + afterMaergeVal);
        System.out.println("map after applying merge = " + map);

        map.merge("D", 500, (o, p) -> o * p); //o corresponds to old value if it exists, p corresponds to new value, in this example o=3, p=500
        System.out.println(map);

    }
}
