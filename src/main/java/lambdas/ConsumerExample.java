package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    //The java.util.function.Consumer<T> interface defines an abstract method named
    //accept that takes an object of generic type T and returns no result (void).
    //Consumer - a functional interface that takes an input and produces no output.

    public static <T> void printList(List<T> list, Consumer<T> c) {
        for(T t : list) {
            c.accept(t);
        }
    }

    public static void main(String[] args) {

        Consumer<String> printColonSeaparated = x -> System.out.print(x + ":");
        List<String> strings = Arrays.asList("x","y","z");
        printList(strings,printColonSeaparated); //prints x:y:z:

    }

}
