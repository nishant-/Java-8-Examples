
package functionalinterface.functions;

import java.util.function.Function;

public class ComposeAndThen {

    public static int composeExample(int data) {

        Function<Integer,Integer> f1 = i -> i + i;
        Function<Integer,Integer> f2 = i -> i * i * i;

        Integer value = f1.compose(f2).apply(data); //mathematically it is f(g(x)) => f(g(2)) => f(2 * 2 * 2) => f(8) => 8 + 8 = 16
        return value;
    }


    public static int composeAndThenExample(int data) {

        Function<Integer,Integer> f1 = i -> 3 * i;
        Function<Integer,Integer> f2 = i -> i * i;

        Integer value = f1.andThen(f2).apply(data); //mathematically it is g(f(x)) => g(f(2)) => g(6) => 36
        return value;
    }

    public static void main(String[] args) {
        composeExample(5); //prints 250
        composeAndThenExample(2); //prints 36
    }
}

