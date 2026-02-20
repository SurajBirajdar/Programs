package programs.program.newPrograms.stringPrograms;

// Import statement: This brings in all Java utility classes like HashMap, Map, etc.
import java.util.*;

public class Anagram {

    public static void main(String[] args) {
        // Test case 1: Two strings to check if they are anagrams
        String str1 = "aba";  // First string with characters: a, b, a
        String str2 = "bab";  // Second string with characters: b, a, b

        // Call the checkAnagram method and print the result (true/false)
        System.out.println(checkAnagram(str1, str2));
    }

    /**
     * WHAT IS AN ANAGRAM?
     * Two strings are anagrams if they contain the SAME characters with the SAME frequency.
     * Example: "aba" and "bab" are anagrams because:
     *   - Both have 2 'a's and 1 'b'
     *   - Only the order is different
     *
     * ALGORITHM STRATEGY:
     * Step 1: Count all characters in the first string using a HashMap
     * Step 2: For each character in second string, reduce the count from HashMap
     * Step 3: If HashMap becomes empty, strings are anagrams!
     */
    public static boolean checkAnagram(String str1, String str2) {

        // STEP 1: Create a HashMap to store character counts
        // Key = Character (like 'a', 'b', 'c')
        // Value = Integer (how many times that character appears)
        HashMap<Character, Integer> map = new HashMap<>();

        // STEP 2: Loop through FIRST string and count each character
        // toCharArray() converts "aba" into ['a', 'b', 'a']
        for(char ch : str1.toCharArray()) {

            // For each character, update its count in the HashMap
            // getOrDefault(ch, 0): If 'ch' exists, get its count; otherwise return 0
            // Then add 1 to that count
            // Example: If we see 'a' for the first time: 0 + 1 = 1
            //          If we see 'a' again: 1 + 1 = 2
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // After Step 2, our HashMap for "aba" looks like:
        // {'a' -> 2, 'b' -> 1}

        // STEP 3: Loop through SECOND string and reduce counts
        for(char ch : str2.toCharArray()) {

            // Check 1: Does this character exist in our HashMap?
            // If NOT, it means str2 has a character that str1 doesn't have
            // So they CANNOT be anagrams! Return false immediately.
            if(!map.containsKey(ch))
                return false;

            // Check 2: If the count of this character is exactly 1
            // Then we should remove it from the map (because 1 - 1 = 0)
            // No need to keep characters with 0 count
            else if(map.get(ch) == 1) {
                map.remove(ch);
            }

            // Check 3: If the count is more than 1 (like 2, 3, etc.)
            // Then reduce the count by 1
            // Example: If 'a' has count 2, make it 2 - 1 = 1
            else {
                map.put(ch, map.get(ch) - 1);
            }
        }

        // STEP 4: Final check - Is the HashMap empty?
        // If map.size() == 0, it means:
        //   - All characters from str1 were found in str2
        //   - All characters from str2 were found in str1
        //   - Frequencies matched perfectly
        //   - Therefore, they ARE anagrams! Return true
        //
        // If map.size() > 0, it means:
        //   - str1 had some characters left over
        //   - str2 didn't have enough of those characters
        //   - Therefore, they are NOT anagrams! Return false
        return map.size() == 0;
    }

    /*
     * INTERVIEW EXPLANATION TEMPLATE:
     * ================================
     * "This code checks if two strings are anagrams using a HashMap approach.
     *
     * First, I count all characters in the first string and store them in a HashMap
     * where the key is the character and value is its frequency.
     *
     * Then, I iterate through the second string and for each character:
     *   - If it's not in the map, I return false immediately
     *   - If its count is 1, I remove it from the map
     *   - Otherwise, I decrement its count
     *
     * Finally, if the map is empty, both strings have the same characters with
     * the same frequencies, so they are anagrams.
     *
     * TIME COMPLEXITY: O(n + m) where n and m are the lengths of the strings
     * SPACE COMPLEXITY: O(k) where k is the number of unique characters
     *
     * EDGE CASES TO MENTION:
     * - What if strings have different lengths? (They can't be anagrams)
     * - What about case sensitivity? (This code is case-sensitive)
     * - What about spaces and special characters? (They are counted too)
     * "
     */
}
