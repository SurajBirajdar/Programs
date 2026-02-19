// This line tells Java where this file belongs in the project folder structure
package programs.program.newPrograms.stringPrograms;

// These are imports - they bring in pre-built Java tools (though we don't actually use these two)
import java.util.ArrayList;
import java.util.List;

/*
 * WHAT ARE PERMUTATIONS?
 * Permutations are all the different ways you can arrange letters.
 * Example: For "ABC", the permutations are:
 * ABC, ACB, BAC, BCA, CAB, CBA (6 different arrangements)
 *
 * HOW THIS WORKS:
 * We use a technique called "backtracking" - we try different positions,
 * then undo our changes and try again.
 */
public class PermutationsOfString {

    /**
     * This method finds all permutations of a character array
     *
     * @param arr - the character array we're rearranging (example: ['A', 'B', 'C'])
     * @param fi - "fixed index" - the position we're currently fixing/deciding (starts at 0)
     *
     * EXAMPLE WALKTHROUGH with "ABC":
     * - First call: fi=0, we try A, B, C at position 0
     * - Second call: fi=1, we try remaining letters at position 1
     * - Third call: fi=2, we try the last letter at position 2
     */
    public static void permutations(char[] arr, int fi) {

        // BASE CASE: Have we fixed all positions?
        // If fi > arr.length-1, it means we've arranged all letters
        // Example: if arr has 3 letters (length=3), when fi=3, we're done (3 > 3-1)
        if(fi > arr.length-1) {
            // Print the complete permutation we just created
            // Example: This might print "ABC" or "BAC" etc.
            System.out.println(arr);

            // Return means "stop this function and go back"
            // We go back to try other arrangements
            return;
        }

        // RECURSIVE CASE: We still have positions to fill
        // This loop tries every remaining character at the current position (fi)
        // Example: if fi=0, we try putting each letter (A, B, C) at position 0
        for(int i=fi; i<arr.length; i++) {

            // STEP 1: SWAP - Put character at position i into position fi
            // Example: swap(arr, 1, 0) would swap positions 0 and 1
            // If arr=['A','B','C'], after swap arr=['B','A','C']
            swap(arr, i, fi);

            // STEP 2: RECURSE - Now fix the next position (fi+1)
            // This is like saying "I've decided position fi, now decide position fi+1"
            // Example: if we fixed position 0 to 'A', now fix position 1
            permutations(arr, fi+1);

            // STEP 3: BACKTRACK - Undo the swap to try other possibilities
            // This swaps back to the original arrangement
            // Example: if we changed ['A','B','C'] to ['B','A','C'], change it back
            // WHY? So we can try other characters at position fi
            swap(arr, i, fi);
        }
    }

    /**
     * This helper method swaps two characters in an array
     *
     * @param arr - the character array (example: ['A', 'B', 'C'])
     * @param i - first position to swap (example: 0)
     * @param fi - second position to swap (example: 1)
     *
     * EXAMPLE: If arr=['A','B','C'], i=0, fi=1
     * After swap: arr=['B','A','C']
     * (A and B switched places)
     */
    public static void swap(char[] arr, int i, int fi) {

        // STEP 1: Save the character at position i in a temporary variable
        // Example: if arr[i] = 'A', then temp = 'A'
        // WHY? Because we're about to overwrite arr[i], so we need to remember it
        char temp = arr[i];

        // STEP 2: Put the character from position fi into position i
        // Example: if arr[fi] = 'B', then arr[i] = 'B'
        // Now arr[i] has the value that was in arr[fi]
        arr[i] = arr[fi];

        // STEP 3: Put the saved character (temp) into position fi
        // Example: temp = 'A', so arr[fi] = 'A'
        // Now the swap is complete! The two characters have traded places
        arr[fi] = temp;
    }

    /**
     * The main method - this is where the program starts running
     * Java always looks for this method first when you run a program
     */
    public static void main(String[] args) {

        // Create a string with the letters we want to permute
        // Example: "ABC" means we want to find all arrangements of A, B, and C
        String str = "ABC";

        // Call the permutations method:
        // - str.toCharArray() converts the String "ABC" into a char array ['A', 'B', 'C']
        //   WHY? Because arrays are easier to manipulate (swap characters)
        // - 0 is the starting index (we start fixing from position 0)
        //
        // WHAT WILL HAPPEN:
        // This will print all 6 permutations:
        // ABC, ACB, BAC, BCA, CAB, CBA
        permutations(str.toCharArray(), 0);

        // TRY YOURSELF:
        // Change "ABC" to "AB" - you'll get 2 permutations: AB, BA
        // Change "ABC" to "ABCD" - you'll get 24 permutations!
        // Formula: n! (factorial) - for 3 letters: 3! = 3×2×1 = 6 permutations
    }

}
