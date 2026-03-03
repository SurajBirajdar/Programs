package programs.program.newPrograms.twoPointer;
import java.util.*;

/*
 * PROBLEM: Find all unique triplets (3 numbers) in array that sum to 0
 * Example: arr = {-1, 0, 1, 2, -1, -4}
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 * These are all combinations of 3 numbers that add up to 0
 */

public class ThreeSum {

    public static void main(String[] args) {
        // Test array with positive, negative and duplicate numbers
        // Input: [-1, 0, 1, 2, -1, -4]
        int[] arr = {-1, 0, 1,2,-1,-4};
        // Call function and print all triplets that sum to 0
        System.out.println(threeSum(arr));
        // Expected Output: [[-1, -1, 2], [-1, 0, 1]]
    }

    /*
     * APPROACH: Two Pointer Technique (after sorting)
     * Step 1: Sort the array so we can use two pointers
     * Step 2: For each element, find 2 other elements that sum with it to 0
     * Step 3: Use left and right pointers to find pairs efficiently
     */
    public static List<List<Integer>> threeSum(int[] arr) {
        // STEP 1: Sort array to use two pointer technique
        // Example: [-1, 0, 1, 2, -1, -4] becomes [-4, -1, -1, 0, 1, 2]
        // Why? This helps us skip duplicates easily and move pointers logically
        Arrays.sort(arr);

        // Create empty list to store all valid triplets
        // Each triplet is itself a list of 3 integers
        // Example: result will contain [[-1, -1, 2], [-1, 0, 1]]
        List<List<Integer>> result = new ArrayList<>();

        // STEP 2: Iterate through array, fixing one number at a time
        // We go till arr.length-2 because we need at least 2 more elements for a triplet
        // Example: with 6 elements, we stop at index 3 (arr[3] = 2)
        // Why arr.length-2? If i goes to arr.length-1, we won't have room for left and right pointers
        for(int i=0; i<arr.length-2; i++) {

            // OPTIMIZATION: Skip duplicate values for the first element
            // If current element is same as previous element, we already found triplets with it
            // Example: In [-4, -1, -1, 0, 1, 2], skip the second -1
            // This prevents duplicate triplets in our result
            if(i > 0 && arr[i] == arr[i-1]) {
                continue; // Jump to next iteration, skip this duplicate
            }

            // STEP 3: Use Two Pointer Technique to find 2 more elements
            // left pointer starts right after current element
            // Example: if i=0 (arr[0]=-4), left starts at 1 (arr[1]=-1)
            int left = i+1;

            // right pointer starts at the last element
            // Example: right starts at 5 (arr[5]=2)
            int right = arr.length-1;

            // STEP 4: Move pointers towards each other to find pairs
            // Condition: left < right (pointers haven't crossed)
            // Example: Start with left=1, right=5 and move them inward
            while(left<right) {
                // Calculate sum of all 3 numbers
                // Example: arr[0] + arr[1] + arr[5] = -4 + (-1) + 2 = -3
                int sum = arr[i] + arr[left] + arr[right];

                // Case 1: Sum equals 0 - WE FOUND A VALID TRIPLET!
                if(sum == 0) {
                    // Create a new list to store this triplet
                    // Example: list = [-4, -1, 2]
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);     // Add the fixed element
                    list.add(arr[left]);  // Add the left element
                    list.add(arr[right]); // Add the right element

                    // Add this triplet to our result list
                    // Now result contains this valid combination
                    result.add(list);

                    // DUPLICATE HANDLING: Skip all duplicates on the left side
                    // Example: If left=1 and arr[2] is also -1, skip it
                    // We check arr[left] == arr[left+1]
                    while(left<right && arr[left] == arr[left+1]) {
                        left++; // Move left pointer to skip duplicate
                    }

                    // DUPLICATE HANDLING: Skip all duplicates on the right side
                    // Example: If right=5 and arr[4] is also 2, skip it
                    // We check arr[right] == arr[right-1]
                    while(left<right && arr[right] == arr[right-1]) {
                        right--; // Move right pointer to skip duplicate
                    }

                    // After finding a triplet, move BOTH pointers to search for more triplets
                    left++;   // Move left pointer to the right (towards positive numbers)
                    right--;  // Move right pointer to the left (towards negative numbers)

                // Case 2: Sum is less than 0 (sum is too small/negative)
                } else if(sum < 0) {
                    // Example: sum = -10 (we need bigger numbers)
                    // Move left pointer RIGHT to get a larger (less negative) number
                    // Moving left right increases the sum because array is sorted
                    left++;

                // Case 3: Sum is greater than 0 (sum is too big/positive)
                } else {
                    // Example: sum = 5 (we need smaller numbers)
                    // Move right pointer LEFT to get a smaller (less positive) number
                    // Moving right left decreases the sum because array is sorted
                    right--;
                }
            }
            // When left >= right, we've exhausted all pairs for this fixed element
            // Loop continues with next value of i
        }

        // Return all unique triplets found
        // Example: [[-4, -1, 5], [-1, 0, 1], ...]
        return result;
    }
}
