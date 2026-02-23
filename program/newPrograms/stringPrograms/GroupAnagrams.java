// This tells Java where this file belongs in our project folder structure
// Think of it like your home address: Country > State > City > Street
package programs.program.newPrograms.stringPrograms;

// This imports pre-built Java tools we need
// Like borrowing tools from a toolbox instead of making them ourselves
// The asterisk (*) means "import ALL tools from java.util package"
import java.util.*;

// This is our class - think of it as a blueprint or recipe book
// "public" means anyone can use it
// "class" means it's a template for creating objects
public class GroupAnagrams {

    // This is the main method - the STARTING POINT of our program
    // When you run the program, Java looks for "main" and starts here
    // Think of it as the "Play" button
    // "public" = anyone can access it
    // "static" = you don't need to create an object to use it
    // "void" = this method doesn't return any value
    // "String[] args" = can accept text input from command line (we're not using it here)
    public static void main(String[] args) {

        // STEP 1: Create our input data
        // We create an array (list) of strings (words)
        // String[] means "array of text values"
        // strs is the variable name (short for "strings")
        // Think of this as a shopping list with 5 items
        // Example: {"abcb", "acbb", "ate", "eta", "bbb"}
        String[] strs = {"abcb", "acbb", "ate", "eta", "bbb"};

        // STEP 2: Create a Map (dictionary) to store our groups
        // Map is like a phone book: Key (name) -> Value (phone number)
        // Here: Key = sorted letters, Value = list of words with those letters
        // Example: "abbc" -> ["abcb", "acbb"]
        // HashMap is the implementation (the actual type of map we're using)
        // <String, List<String>> means: Key is String, Value is List of Strings
        Map<String, List<String>> map = new HashMap<>();

        // STEP 3: Loop through each word in our array
        // "for each string in the strs array, do the following:"
        // First loop: str = "abcb"
        // Second loop: str = "acbb"
        // Third loop: str = "ate"
        // And so on...
        for(String str : strs) {

            // STEP 4: Convert the current word into an array of characters
            // "abcb" becomes ['a', 'b', 'c', 'b']
            // Think of breaking a word into individual letter tiles
            // char[] means "array of characters"
            // Example: "abcb" -> ['a', 'b', 'c', 'b']
            char[] ch = str.toCharArray();

            // STEP 5: Sort the characters alphabetically
            // This is THE KEY TRICK to find anagrams!
            // Anagrams have the same letters, so when sorted, they look identical
            // Before: ['a', 'b', 'c', 'b'] -> After: ['a', 'b', 'b', 'c']
            // Before: ['a', 'c', 'b', 'b'] -> After: ['a', 'b', 'b', 'c']
            // See? "abcb" and "acbb" both become "abbc" when sorted!
            // This is how we know they're anagrams
            Arrays.sort(ch);

            // STEP 6: Convert the sorted character array back to a String
            // ['a', 'b', 'b', 'c'] becomes "abbc"
            // This sorted string will be our KEY in the map
            // All anagrams will have the SAME sorted key
            // Example: "abcb" -> sorted -> "abbc"
            //          "acbb" -> sorted -> "abbc" (same key!)
            String sorted = new String(ch);

            // STEP 7: Check if this sorted key already exists in our map
            // containsKey() checks if the map already has this key
            // ! means "NOT" - so we're checking "if NOT contains key"
            // First time seeing "abbc"? Then do the next step
            // Example: First time we see "abbc", map doesn't have it yet
            if(!map.containsKey(sorted)) {

                // STEP 8: Create a new empty list for this sorted key
                // This list will hold all words that are anagrams of each other
                // LinkedList is a type of list (like ArrayList, but different internally)
                // <> means "use the same type as defined in the map"
                // Example: map.put("abbc", [empty list])
                // Think of creating a new folder with the label "abbc"
                map.put(sorted, new LinkedList<>());
            }

            // STEP 9: Add the original word to the list for this sorted key
            // map.get(sorted) -> gets the list for this key
            // .add(str) -> adds the original word to that list
            // Example: sorted = "abbc", str = "abcb"
            //          map.get("abbc").add("abcb")
            //          Later: map.get("abbc").add("acbb")
            //          Result: "abbc" -> ["abcb", "acbb"]
            // This groups all anagrams together!
            map.get(sorted).add(str);
        }

        // STEP 10: Print the final result
        // This shows all the groups we created
        // Output will look like: {abbc=[abcb, acbb], aet=[ate, eta], bbb=[bbb]}
        // Each key (sorted letters) maps to a list of words (anagrams)
        System.out.println(map);
    }
}

/*
 * ========================================
 * HOW THIS WORKS - SIMPLE EXPLANATION FOR INTERVIEWS:
 * ========================================
 *
 * PROBLEM: Group words that are anagrams (same letters, different order)
 *
 * SOLUTION: Use sorted letters as a "signature"
 *
 * WHY IT WORKS:
 * - Anagrams have the SAME letters, just in different order
 * - Example: "ate" and "eta" both have letters: a, e, t
 * - If we sort both: "aet" and "aet" - they're IDENTICAL!
 * - So we use this sorted version as a KEY to group them
 *
 * STEP-BY-STEP EXAMPLE:
 * Input: ["abcb", "acbb", "ate", "eta", "bbb"]
 *
 * Processing "abcb":
 *   - Sort letters: "abbc"
 *   - Map: {"abbc" -> ["abcb"]}
 *
 * Processing "acbb":
 *   - Sort letters: "abbc" (same as "abcb"!)
 *   - Map: {"abbc" -> ["abcb", "acbb"]}
 *
 * Processing "ate":
 *   - Sort letters: "aet"
 *   - Map: {"abbc" -> ["abcb", "acbb"], "aet" -> ["ate"]}
 *
 * Processing "eta":
 *   - Sort letters: "aet" (same as "ate"!)
 *   - Map: {"abbc" -> ["abcb", "acbb"], "aet" -> ["ate", "eta"]}
 *
 * Processing "bbb":
 *   - Sort letters: "bbb"
 *   - Map: {"abbc" -> ["abcb", "acbb"], "aet" -> ["ate", "eta"], "bbb" -> ["bbb"]}
 *
 * FINAL RESULT: All anagrams are grouped together!
 *
 * TIME COMPLEXITY: O(n * k log k)
 *   - n = number of words
 *   - k = length of longest word
 *   - k log k = time to sort each word
 *
 * SPACE COMPLEXITY: O(n * k)
 *   - Storing all words in the map
 *
 * LAYMAN EXPLANATION FOR INTERVIEWS:
 * "Imagine you have a bunch of word tiles. To find which words are anagrams,
 * I arrange each word's letters alphabetically - like organizing books by title.
 * Words that look the same after organizing are anagrams! I use a dictionary
 * (HashMap) where the organized version is the label, and under each label,
 * I put all the original words that match. It's like sorting mail into mailboxes
 * based on zip codes - all letters with the same zip code (sorted letters) go
 * in the same mailbox (list)."
 */


