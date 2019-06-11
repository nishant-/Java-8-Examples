package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Mapping {

    //Stream supports the map method,
    //map method takes function as argument
    //applies it to ech element of the map
    public static void mapMethod (){
        IntStream intStream = IntStream.rangeClosed(1,50);
        //map method doubles each item in the list.
        List<Integer> list = intStream.boxed().map(x->x*2).collect(Collectors.toList());
        System.out.println(Arrays.toString(list.toArray())); //will print 2,4,6...100
    }

    //flatmap flattens each generated stream into a single stream
    public static void flatMapMethod() {

        Stream<Integer[]> streams = Stream.of(new Integer[]{1,3,5},new Integer[]{2,4,6}, new Integer[]{8,10,12});
        Stream<Integer> flatStream = streams.flatMap(Arrays::stream);
        System.out.print(Arrays.toString(flatStream.toArray())); //produces 1,2,5,2,4,6,8,10,12
    }

    public static void main(String[] args) {
        mapMethod();
        flatMapMethod();
    }




}

