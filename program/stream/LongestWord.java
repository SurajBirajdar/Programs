package programs.program.stream;
import java.util.*;
public class LongestWord {
    public static void main(String[] args) {
        // Find longest word from string of words
        String str = "My name is Suraj";
        String longestWord = Arrays.stream(str.split(" ")).max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println(longestWord);
    }
}
