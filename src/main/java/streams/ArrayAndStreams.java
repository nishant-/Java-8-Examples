package streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayAndStreams {

    public static void convertArrayToStream() {
        String words[] = {"word1","word2","word3"};
        Stream<String> streamOfWords = Arrays.stream(words);
    }
}
