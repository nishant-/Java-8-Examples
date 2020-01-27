package functionalinterface.functions.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;



public class ConsumerExample {


    /**
     * @author nishant
     */
    public static <T> void printList(List<T> list, Consumer<T> c) {
        for(T t : list) {
            c.accept(t); //single abstract method (SAM) in Consumer is 'accept'
        }
    }

    public static void main(String[] args) {

        Consumer<String> printColonSeparated = x -> System.out.print(x + ":");
        List<String> strings = Arrays.asList("x","y","z");
        printList(strings,printColonSeparated); //prints x:y:z:

    }

}
