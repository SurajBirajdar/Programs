package programs.program.newPrograms.stringPrograms;

// Import statement - brings in Java's built-in classes for collections like List and ArrayList
import java.util.*;

// Class definition - creates a blueprint called CombinationsOfString
public class CombinationsOfString {

    // Main method - this is where the program starts running
    public static void main(String[] args) {

        // Create a string variable called 'str' and store "abc" in it
        // This is the input string for which we'll find all combinations
        String str = "abc";

        // Create an empty list called 'result' to store all the combinations we find
        // ArrayList is like a flexible array that can grow in size
        List<String> result = new ArrayList<>();

        // Outer loop: Go through each character in the string one by one
        // str.toCharArray() converts "abc" into ['a', 'b', 'c']
        // In each iteration, 'ch' will be one character (first 'a', then 'b', then 'c')
        for (char ch : str.toCharArray()) {

            // Get the current size of the result list
            // This tells us how many combinations we already have
            // We store it because the list size will change as we add new items
            int size = result.size();

            // Inner loop: Go through all existing combinations in the result list
            // We use 'size' (not result.size()) because we only want to process
            // the combinations that existed BEFORE we started adding the current character
            for (int i = 0; i < size; i++) {

                // Take each existing combination (result.get(i))
                // Add the current character (ch) to it
                // Store this new combination back in the result list
                // Example: if result has "a" and ch is 'b', this creates "ab"
                result.add(result.get(i) + ch);
            }

            // After processing all existing combinations, add the current character
            // by itself as a new combination
            // String.valueOf(ch) converts the character to a String
            // Example: when ch is 'a', this adds "a" to the result list
            result.add(String.valueOf(ch));
        }

        // Final loop: Print all the combinations we found
        // Go through each string 's' in the result list
        for (String s : result) {

            // Print each combination followed by a space (not a new line)
            // So all combinations will be on the same line
            System.out.print(s + " ");
        }

    }
}

/*
 * HOW THIS ALGORITHM WORKS - STEP BY STEP EXAMPLE:
 *
 * Input: "abc"
 *
 * Initial state: result = []
 *
 * Iteration 1 (ch = 'a'):
 *   - size = 0 (result is empty)
 *   - Inner loop doesn't run (no existing combinations)
 *   - Add "a" → result = ["a"]
 *
 * Iteration 2 (ch = 'b'):
 *   - size = 1 (result has 1 item)
 *   - Inner loop runs once:
 *     - Take "a", add 'b' → "ab"
 *   - Add "ab" → result = ["a", "ab"]
 *   - Add "b" → result = ["a", "ab", "b"]
 *
 * Iteration 3 (ch = 'c'):
 *   - size = 3 (result has 3 items)
 *   - Inner loop runs 3 times:
 *     - Take "a", add 'c' → "ac"
 *     - Take "ab", add 'c' → "abc"
 *     - Take "b", add 'c' → "bc"
 *   - Add "ac", "abc", "bc" → result = ["a", "ab", "b", "ac", "abc", "bc"]
 *   - Add "c" → result = ["a", "ab", "b", "ac", "abc", "bc", "c"]
 *
 * Output: a ab b ac abc bc c
 */

