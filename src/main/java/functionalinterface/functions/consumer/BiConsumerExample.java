package functionalinterface.functions.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    //BiConsumer<T, U> , Single Abstract Method : accept(T t, U u), returns void

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> biFunc = map::put;
        biFunc.accept("One", 1);
        biFunc.accept("Two", 2);

        map.forEach((k, v) -> System.out.println(k + "," + v));

    }

}
