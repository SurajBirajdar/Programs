package programs.program.newPrograms.array.markingTechnique;

import java.util.*;

/*
 * PROBLEM: Find all missing numbers from 1 to n (array size) when the array has duplicates
 * Example: arr = {1,4,4,5,2,2} has size 6, so missing numbers should be from 1 to 6
 * Missing numbers are: 3 and 6 (because 1,2,4,5 are present, but 3 and 6 are not)
 *
 * APPROACH: We use a "Marking Technique" - we mark elements using negative signs
 * SPACE: O(1) - we don't use extra space, we modify the input array itself
 * TIME: O(n) - we traverse the array twice
 */

public class MissingElementsInArray {

    public static void main(String[] args) {
        // Step 0: Create a test array with duplicate numbers
        // Array: {1, 4, 4, 5, 2, 2} -> size is 6, so numbers should be 1 to 6
        int[] arr = {1,4,4,5,2,2};

        // Step 1: Call the method to find missing elements
        List<Integer> ans = missingElements(arr);

        // Step 2: Print each missing number (one per line)
        for(int num : ans) {
            System.out.print(num);      // Print the number
            System.out.println();        // Go to next line
        }
    }

    /*
     * METHOD: missingElements
     * INPUT: int[] arr - an array of numbers (may have duplicates, values are 1 to n)
     * OUTPUT: List<Integer> - list of all missing numbers
     *
     * LOGIC IN 2 STEPS:
     * Step 1: Mark - Convert array values to negative based on their position
     * Step 2: Scan - Check which positions still have positive values (those are missing)
     */
    public static List<Integer> missingElements(int[] arr) {
        // Create an empty list to store answer (missing numbers)
        List<Integer> ans = new ArrayList<>();

        // ═══════════════════════════════════════════════════════════
        // STEP 1: MARKING PROCESS - Mark which numbers are present
        // ═══════════════════════════════════════════════════════════

        // Get the length/size of array
        int n = arr.length;

        // Loop through each element in the array
        for(int i=0; i<n; i++){
            // Get the absolute value (ignore negative sign if any)
            // Example: if arr[i] = -5, value = 5
            int value = Math.abs(arr[i]);

            // Convert this value to an INDEX (subtract 1 because index starts from 0)
            // Example: value 5 means index 4 (0-indexed)
            int position = value - 1;

            // If the element at that position is still positive, make it negative
            // This negative sign means "we have seen this number"
            if(arr[position] > 0) {
                arr[position] = -arr[position];  // Convert to negative
            }
            // If already negative, it means we've already marked it (duplicate), skip
        }

        // At this point:
        // - Positions with positive values = numbers that were NOT seen
        // - Positions with negative values = numbers that WERE seen

        // ═══════════════════════════════════════════════════════════
        // STEP 2: SCANNING PROCESS - Find which numbers are missing
        // ═══════════════════════════════════════════════════════════

        // Loop through the array again
        for(int i=0; i<n; i++) {
            // If element at position i is still POSITIVE, it's missing
            // Because we never marked it as negative in step 1
            if(arr[i] > 0) {
                // Add 1 to index to get the actual number (index 0 = number 1)
                int number = i + 1;

                // Add this missing number to our answer list
                ans.add(number);
            }
        }

        // Return the list of all missing numbers
        return ans;
    }


}
