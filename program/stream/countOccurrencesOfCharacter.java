package programs.program.stream;

// Importing Map to store character as key and count as value
import java.util.Map;
// Importing Collectors to use groupingBy and counting methods for stream operations
import java.util.stream.Collectors;

public class countOccurrencesOfCharacter {
    public static void main(String[] args) {
        // Define the input string whose characters we want to count
        String str = "suraja";

        // Declare a Map where Character is the key (each unique character)
        // and Long is the value (count of how many times that character appears)
        Map<Character, Long> result =
                // Convert the string into a stream of integer values (ASCII codes of each character)
                // Example: "suraja" becomes IntStream of [115, 117, 114, 97, 106, 97]
                str.chars()
                        // .mapToObj() = "map To Object" - converts primitive int stream to Object stream
                        // It transforms each int value into an Object (in this case, Character object)
                        // The lambda (c -> (char) c) takes each int 'c' and casts it to a char
                        // Example: 115 becomes 's', 117 becomes 'u', 114 becomes 'r', etc.
                        // We need this because Collectors.groupingBy() works with Objects, not primitives
                        .mapToObj(c -> (char) c)
                        // Group the characters by themselves (each character is a key)
                        // and count how many times each character appears in the string
                        // This creates a Map with character as key and count as value
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Print the result map which shows each character and its occurrence count
        // Example output: {a=3, r=1, s=1, u=1, j=1}
        System.out.println(result);
    }
}
