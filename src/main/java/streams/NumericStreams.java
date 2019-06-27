package streams;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumericStreams {

    //Using boxed types for int (Integer) , long (Long) .. etc in streams introduces additional overhead in
    //unboxing it to primitive type
    //when numeric types are required, use primitive streams such as IntStream, LongStream etc..

    public static void primitiveStreamExamples() {

        Stream<Data> dataStream = Stream.of(new Data(1),new Data(2),new Data(3));
        //mapToInt will return an IntStream
        IntStream intStream = dataStream.mapToInt(Data::getValue);
        System.out.println(intStream.sum()); //prints the sum, which is 6

        //LongStream
        LongStream longStream = LongStream.generate(() -> 5L).limit(10);
        System.out.println(Arrays.toString(longStream.toArray())); //prints 5, 10 times but as an array
        //similarly we have DoubleStream but **no FloatStream**

    }

    public static void numericStreamToStream() {
        IntStream intStream = IntStream.iterate(1, x-> x * 2).skip(1).limit(10);
        Stream<Integer> streamOfIntegers =  intStream.boxed(); //this is how you convert an IntStream to Stream of Integers
        streamOfIntegers.forEach(x -> System.out.printf("%d,",x)); //prints 2,4,8,...1024
    }

    //default values  OptionalInt, OptionalDouble, OptionalLong

    public static void defaultValuesExample () {

        LongStream longStream = LongStream.rangeClosed(1,10); //generates a stream of integers between 1..10 (10 inclusive)
        LongBinaryOperator operator = (x,y) -> x+y; //binary operator for long
        OptionalLong op = longStream.reduce(operator); //the reduction operation returns an OptionalLong
        long value = op.getAsLong(); //OptionalLong has getAsLong method which returns a long value;
        System.out.println(value);

        OptionalInt optnlInt =  Stream.of(1,2,3,4,5,6,7,8,9,10).mapToInt(x -> x).max();
        int max = optnlInt.orElse(Integer.MAX_VALUE); //provide an explicit default max if there is no value
        System.out.println(max); //prints 10 because a Max is found, however if the stream was empty then Integer.MAX_VALUE will
        //be returned, the below example illustrates that
        //Stream.empty() - produces an empty stream
        OptionalDouble optionalDouble = Stream.empty().mapToDouble(x -> 1).max();
        double maxDouble = optionalDouble.orElse(Double.MAX_VALUE);
        System.out.println(maxDouble); //prints max value of double, 1.7976931348623157E308
    }

    public static void main(String[] args) {
        primitiveStreamExamples();
        System.out.print(System.lineSeparator());
        numericStreamToStream();
        System.out.print(System.lineSeparator());
        defaultValuesExample();
        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());
    }


    static class Data {
        Integer value;

        Data(Integer value) {
            this.value=value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

}
