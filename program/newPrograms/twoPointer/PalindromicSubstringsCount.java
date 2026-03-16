package programs.program.newPrograms.twoPointer;

/**
 * ============================================================================
 * PALINDROMIC SUBSTRINGS COUNT - Complete Explanation
 * ============================================================================
 *
 * WHAT IS A PALINDROME?
 * A palindrome is a word/text that reads the same forwards and backwards.
 * Examples: "a", "b", "aba", "racecar", "mom", "dad"
 *
 * WHAT IS A SUBSTRING?
 * A substring is any continuous sequence of characters from the string.
 * For "abbac":
 *   - Substrings: "a", "ab", "abb", "abba", "abbac", "b", "bb", "bba", "bbac", etc.
 *
 * WHAT IS A PALINDROMIC SUBSTRING?
 * A substring that is also a palindrome.
 * For "abbac":
 *   - Palindromic substrings: "a", "b", "b", "a", "bb", "abba", "c"
 *   - Total count: 7
 *
 * ALGORITHM APPROACH: "EXPAND AROUND CENTER"
 * Think of it like expanding a circle from the center:
 * - For each character (odd-length palindromes), expand left and right
 * - For each pair of characters (even-length palindromes), expand left and right
 *
 * Example with "abbac":
 * Center at i=0 ('a'): "a" found (count=1)
 * Center at i=0,1 ('ab'): not palindrome
 * Center at i=1 ('b'): "b" found (count=1), then "bb" found (count=1)
 * Center at i=1,2 ('bb'): expands to "abba" (count=1)
 * ... and so on
 *
 * TIME COMPLEXITY: O(n²) where n is string length
 * SPACE COMPLEXITY: O(1) - only using a counter variable
 * ============================================================================
 */
public class PalindromicSubstringsCount {

    static int maxLength = 0;
    static String maxLengthPalindrome = "";

    public static void main(String[] args) {
        // =====================================================================
        // Step 1: Initialize the test string
        // =====================================================================
        // We want to count all palindromic substrings in this string
        // String "abbac" contains: a, b, b, a, c
        // Palindromic ones: a, b, b, a, bb, abba, c = 7 total
        String str = "abbac";

        // =====================================================================
        // Step 2: Initialize counter to store total palindromic substrings
        // =====================================================================
        // count = 0  means we haven't found any palindromes yet
        // We'll add 1 to this counter each time we find a palindromic substring
        int count = 0;

        // =====================================================================
        // Step 3: Loop through each character position (Center of expansion)
        // =====================================================================
        // i goes from 0 to length-1
        // For "abbac" (length 5): i will be 0, 1, 2, 3, 4
        // Example: when i=1, we're focusing on the character 'b' at index 1
        for(int i=0; i<str.length(); i++) {

            // ===================================================================
            // Step 4a: Check ODD-LENGTH palindromes (single character as center)
            // ===================================================================
            // countPalindromicSubstrings(str, i, i) means:
            //   - left = i (starting position)
            //   - right = i (same position)
            //   - We're starting with just ONE character as the center
            //
            // Example when i=1:
            //   - Start with center at index 1 (character 'b')
            //   - Check if 'b' is palindrome (YES, single char is always palindrome)
            //   - Then expand: check if str[0] == str[2] (is 'a' == 'b'? NO)
            //   - So we found 1 odd-length palindrome: "b"
            count+= countPalindromicSubstrings(str, i, i);

            // ===================================================================
            // Step 4b: Check EVEN-LENGTH palindromes (two characters as center)
            // ===================================================================
            // countPalindromicSubstrings(str, i, i+1) means:
            //   - left = i (starting position)
            //   - right = i+1 (next position)
            //   - We're starting with TWO adjacent characters as the center
            //
            // Example when i=1:
            //   - Start with center between index 1 and 2 (characters 'b' and 'b')
            //   - Check if str[1] == str[2] (is 'b' == 'b'? YES)
            //   - Found 1 palindrome: "bb", count++
            //   - Then expand: check if str[0] == str[3] (is 'a' == 'a'? YES)
            //   - Found another: "abba", count++
            //   - Then expand: check if str[-1] == str[4] (out of bounds, STOP)
            //   - So we found 2 even-length palindromes: "bb", "abba"
            count+= countPalindromicSubstrings(str, i, i+1);
        }

        // =====================================================================
        // Step 5: Print the final count
        // =====================================================================
        // After checking all positions and expansions, print the result
        // For "abbac": 7 palindromic substrings total
        // ("a" at 0, "b" at 1, "b" at 2, "a" at 3, "c" at 4, "bb", "abba")
        System.out.println(count);
        System.out.println("Maximum length palindromic substring is: " + maxLengthPalindrome + " and its length is: " + maxLength);
    }

    /**
     * =========================================================================
     * HELPER METHOD: countPalindromicSubstrings(String, int left, int right)
     * =========================================================================
     *
     * PURPOSE:
     * This method expands around a center point and counts all palindromes
     * found by expanding outwards.
     *
     * PARAMETERS:
     * - str: the input string we're searching in
     * - left: the left pointer (starting position of expansion)
     * - right: the right pointer (starting position of expansion)
     *
     * RETURNS:
     * The number of palindromic substrings found by expanding from (left, right)
     *
     * EXAMPLE WALKTHROUGH with str="abbac", left=1, right=2:
     *
     * Initial state: left=1 (pointing to 'b'), right=2 (pointing to 'b')
     *
     * Iteration 1:
     *   - Condition check: left>=0? YES (1>=0) ✓
     *                      right<5? YES (2<5) ✓
     *                      str[1]=='b' == str[2]=='b'? YES ✓
     *   - All conditions true, so: count=1, left=0, right=3
     *   - Substring found: "bb" (from index 1 to 2)
     *
     * Iteration 2:
     *   - Condition check: left>=0? YES (0>=0) ✓
     *                      right<5? YES (3<5) ✓
     *                      str[0]=='a' == str[3]=='a'? YES ✓
     *   - All conditions true, so: count=2, left=-1, right=4
     *   - Substring found: "abba" (from index 0 to 3)
     *
     * Iteration 3:
     *   - Condition check: left>=0? NO (-1>=0) ✗
     *   - Condition fails, STOP the loop
     *   - Return count=2 (found 2 palindromes: "bb" and "abba")
     *
     * =========================================================================
     */
    public static int countPalindromicSubstrings(String str, int left, int right) {

        // =====================================================================
        // Initialize counter for this expansion
        // =====================================================================
        // count = 0 means we start with no palindromes found in this expansion
        // We'll increment this for each valid palindrome found
        int count = 0;

        // =====================================================================
        // WHILE LOOP: Keep expanding left and right until we can't anymore
        // =====================================================================
        // We continue the loop only if ALL three conditions are true:
        //
        // Condition 1: left >= 0
        //   - Means: left pointer hasn't gone out of bounds on the left side
        //   - Example: if left = -1, we've gone past the beginning, so STOP
        //
        // Condition 2: right < str.length()
        //   - Means: right pointer hasn't gone out of bounds on the right side
        //   - For "abbac" (length 5), if right = 5, we've gone past the end, so STOP
        //
        // Condition 3: str.charAt(left) == str.charAt(right)
        //   - Means: the characters at left and right positions are the SAME
        //   - If they're different, it's not a palindrome anymore, so STOP
        //   - Example: if str[0]='a' and str[3]='a', they match, so CONTINUE
        //   - Example: if str[0]='a' and str[3]='b', they don't match, so STOP
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {

            // =================================================================
            // We found a palindrome! Increment the counter
            // =================================================================
            // Every time we enter this while loop, it means we found a valid
            // palindromic substring (characters at left and right are same)
            //
            // Example progression when expanding "abbac":
            // - First iteration: found "bb", count becomes 1
            // - Second iteration: found "abba", count becomes 2
            // - Third iteration would fail condition, so we exit
            count++;

            System.out.println(str.substring(left,right+1));
            String current = str.substring(left, right+1);
            if(current.length() > maxLength) {
                maxLength = current.length();
                maxLengthPalindrome = current;
            }

            // =================================================================
            // Move left pointer one step to the LEFT (decrease by 1)
            // =================================================================
            // left-- means we're expanding the search area to the left
            // Example: if left was 1, now it becomes 0 (we go one position left)
            //
            // Visual representation for "abbac":
            // Before: left=1, right=2    (current substring: "bb")
            // After:  left=0, right=2    (will check substring: "?bb" where ? is at 0)
            left--;

            // =================================================================
            // Move right pointer one step to the RIGHT (increase by 1)
            // =================================================================
            // right++ means we're expanding the search area to the right
            // Example: if right was 2, now it becomes 3 (we go one position right)
            //
            // Visual representation for "abbac":
            // Before: left=0, right=2    (current substring: "abb")
            // After:  left=0, right=3    (will check substring: "abba")
            right++;

            // =================================================================
            // Now the loop will check the NEW left and right positions
            // Continue expanding until characters don't match or we go out of bounds
            // =================================================================
        }

        // =====================================================================
        // Return the count of palindromes found during this expansion
        // =====================================================================
        // Return how many palindromic substrings were found
        // Example return values:
        //   - return 1: found 1 palindrome (single character or one pair)
        //   - return 2: found 2 palindromes while expanding
        //   - return 0: found no palindromes
        return count;
    }
}
