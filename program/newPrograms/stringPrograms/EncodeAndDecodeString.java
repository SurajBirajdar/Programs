package programs.program.newPrograms.stringPrograms;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {

    // -------------------------------------------------------
    // ENCODE
    // Convert a list of words into ONE single string
    // Format: length#word
    // Example:
    //   Input  → ["hello", "world"]
    //   Output → "5#hello5#world"
    // -------------------------------------------------------
    public String encode(List<String> strs) {

        // Empty box to build the final big string
        StringBuilder ans = new StringBuilder();

        // Go through each word one by one
        for (String word : strs) {

            // Count how many letters are in this word
            // "hello" → 5 letters
            int len = word.length();

            // Add  length + "#" + word  to the box
            // "hello" becomes "5#hello"
            ans.append(len).append("#").append(word);
        }

        // Return the full packed string
        // "5#hello5#world"
        return ans.toString();
    }

    // -------------------------------------------------------
    // DECODE
    // Convert that ONE big string back to original list
    // Example:
    //   Input  → "5#hello5#world"
    //   Output → ["hello", "world"]
    // -------------------------------------------------------
    public List<String> decode(String s) {

        // Empty bag to collect all words
        List<String> list = new ArrayList<>();

        // i = finger pointing at current reading position
        // Start from the beginning
        int i = 0;

        // Keep reading until we reach the end of string
        while (i < s.length()) {

            // Find '#' from current position i
            // "5#hello" → '#' is at index 1
            int j = s.indexOf('#', i);

            // Read the number before '#'
            // substring(i, j) = "5"
            // parseInt("5") = 5
            int len = Integer.parseInt(s.substring(i, j));

            // Read the real word after '#'
            // Start = j + 1  (skip the '#')
            // End   = j + 1 + len  (read exactly 'len' letters)
            // "5#hello" → word = "hello"
            String word = s.substring(j + 1, j + 1 + len);

            // Add this word to our list
            list.add(word);

            // Move finger forward
            // Skip '#' and the word we just read
            i = j + 1 + len;
        }

        // Return the original list of words
        return list;
    }

    // -------------------------------------------------------
    // MAIN - Run and test
    // -------------------------------------------------------
    public static void main(String[] args) {

        // Create object to use encode and decode
        EncodeAndDecodeString obj = new EncodeAndDecodeString();

        // Original list of words
        List<String> input = List.of("hello", "world", "cat", "dog");
        System.out.println("Original : " + input);
        // Output: [hello, world, cat, dog]

        // Pack list into one string
        String encoded = obj.encode(input);
        System.out.println("Encoded  : " + encoded);
        // Output: 5#hello5#world3#cat3#dog

        // Unpack string back to list
        List<String> decoded = obj.decode(encoded);
        System.out.println("Decoded  : " + decoded);
        // Output: [hello, world, cat, dog]  ✅ Same as original!
    }

    // -------------------------------------------------------
    // TIME  : O(n) → we read each character once
    // SPACE : O(n) → we store the result
    // -------------------------------------------------------
}
