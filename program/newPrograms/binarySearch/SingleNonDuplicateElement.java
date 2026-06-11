package programs.program.newPrograms.binarySearch;

/**
 * PROBLEM EXPLANATION:
 * ====================
 * Find the single element that appears only ONCE in a sorted array where
 * ALL other elements appear EXACTLY TWICE consecutively.
 *
 * EXAMPLE: [1, 1, 2, 3, 3, 4, 4] → Answer: 2 (appears once, others appear twice)
 * EXAMPLE: [10, 10, 20, 20, 30, 30, 40, 40, 50, 60, 60] → Answer: 50 (only once!)
 *
 * WHY BINARY SEARCH?
 * ==================
 * Instead of checking every element (O(n)), we use Binary Search to eliminate
 * half the array in each step. Time Complexity: O(log n) - MUCH FASTER!
 *
 * INTUITION:
 * ==========
 * Before the single element: pairs are at positions (0,1), (2,3), (4,5)...
 * After the single element: pairs shift and are at (1,2), (3,4)...
 * We use this pattern change to find where the single element is!
 */
public class SingleNonDuplicateElement {

    public static void main(String[] args) {
        // Test array: We're looking for the element that appears ONLY ONCE
        // Here: 10 appears 2x, 20 appears 2x, 30 appears 2x, 40 appears 2x,
        //       50 appears 1x (SINGLE!), 60 appears 2x
        int[] arr = {10, 10, 20, 20, 30, 30, 40, 40, 50, 60, 60};

        // Call the function and print the result (should print: 50)
        System.out.print(singleNonDuplicateElement(arr));
    }

    /**
     * MAIN ALGORITHM FUNCTION
     * =======================
     * Uses Binary Search to find the single non-duplicate element
     *
     * @param arr - A sorted array where all elements appear twice except one
     * @return - The value of the single element that appears once, or -1 if not found
     */
    public static int singleNonDuplicateElement(int[] arr) {

        // Get the total number of elements in the array
        // EXAMPLE: If arr = [1, 1, 2], then n = 3
        int n = arr.length;

        // Start pointer - points to the FIRST element (index 0)
        // Think of it like: START of the search area
        // EXAMPLE: s = 0 means we start checking from the beginning
        int s = 0;

        // End pointer - points to the LAST element (index n-1)
        // Think of it like: END of the search area
        // EXAMPLE: If array has 7 elements (indices 0-6), e = 6
        int e = n - 1;

        // Loop while START pointer hasn't crossed END pointer
        // EXAMPLE: While 0 <= 6, keep searching
        // When s > e, we've checked everywhere and didn't find it
        while(s <= e) {

            // Find the MIDDLE element to split the array in half
            // Formula: s + (e-s)/2 avoids integer overflow in large arrays
            // EXAMPLE: If s=0, e=10, mid = 0 + (10-0)/2 = 5
            int mid = s + (e - s) / 2;

            // CHECK 1: Is the middle element UNIQUE (not equal to neighbors)?
            // arr[mid-1] != arr[mid] means: element before ≠ middle element
            // arr[mid+1] != arr[mid] means: element after ≠ middle element
            // EXAMPLE: If arr = [10, 10, 50, 60, 60] and mid=2, check if 50 ≠ 10 AND 50 ≠ 60 → YES!
            // WARNING: This line can crash! If mid=0, arr[mid-1] goes to arr[-1] (INVALID!)
            if(arr[mid-1] != arr[mid] && arr[mid+1] != arr[mid]) {
                // We found it! The middle element is the single one
                return mid; // Return the index/value
            }

            // Get the value of element BEFORE middle (left neighbor)
            // Initialize as -1 (a safe default value that won't appear in our array)
            // EXAMPLE: previousVal will store arr[mid-1] value
            int previousVal = -1;

            // Safety check - make sure we don't go OUT OF BOUNDS
            // If mid-1 >= 0, it means there IS an element to the left
            // EXAMPLE: If mid=0, there's nothing to the left, so skip this
            if(mid - 1 >= 0) {
                // Get the actual value from the element to the left
                // EXAMPLE: If arr[2]=50, then previousVal = 50
                previousVal = arr[mid - 1];
            }

            // Store the MIDDLE element value for easy comparison
            // EXAMPLE: If we're checking arr[5], currentVal = arr[5]
            int currentVal = arr[mid];

            // Get the value of element AFTER middle (right neighbor)
            // Initialize as -1 (safe default, won't match real array elements)
            int nextVal = -1;

            // Safety check - make sure we don't go OUT OF BOUNDS
            // If mid+1 < n, it means there IS an element to the right
            // EXAMPLE: If mid=n-1 (last element), there's nothing to the right, so skip
            if(mid + 1 < n) {
                // Get the actual value from the element to the right
                // EXAMPLE: If arr[5]=100, then nextVal = 100
                nextVal = arr[mid + 1];
            }

            // ============================================
            // DECISION LOGIC: Where is the single element?
            // ============================================

            // CASE 1: Current element != previous AND current == next
            // This means: currentVal appears as the FIRST of a pair
            // EXAMPLE: arr = [10, 10, 20, 50, 60, 60]
            //          If mid points to first 60, then 60 != 20 AND 60 == 60 ✓
            // PATTERN: Single element is to the LEFT of middle
            if(currentVal != previousVal && currentVal == nextVal) {
                // Store the starting index of this pair
                int startIndex = mid;

                // Check if startIndex is ODD (using bitwise AND)
                // (startIndex & 1) == 1 means ODD
                // (startIndex & 1) == 0 means EVEN
                // EXAMPLE: 5 & 1 = 1 (ODD), 4 & 1 = 0 (EVEN)
                if((startIndex & 1) == 1) {
                    // If ODD index, single element is to the LEFT
                    // Move END pointer to search left side
                    // EXAMPLE: e = mid - 1
                    e = mid - 1;
                } else {
                    // If EVEN index, single element is to the RIGHT
                    // Move START pointer to search right side
                    // EXAMPLE: s = mid + 1
                    s = mid + 1;
                }
            }

            // CASE 2: Current element == previous AND current != next
            // This means: currentVal appears as the SECOND of a pair
            // EXAMPLE: arr = [10, 10, 20, 50, 60, 60]
            //          If mid points to second 10, then 10 == 10 AND 10 != 20 ✓
            // PATTERN: Single element is to the RIGHT of middle
            if(currentVal == previousVal && currentVal != nextVal) {
                // Store the ending index of this pair
                // NOTE: This variable is just for structure; we use mid directly below
                int endIndex = mid;

                // Check if endIndex is ODD
                if((endIndex & 1) == 1) {
                    // If ODD index, single element is to the RIGHT
                    // Move START pointer forward to search right side
                    s = mid + 1;
                } else {
                    // If EVEN index, single element is to the LEFT
                    // Move END pointer backward to search left side
                    e = mid - 1;
                }
            }
        }

        // If we exit the while loop without finding the single element
        // Return -1 to indicate "NOT FOUND"
        return -1;
    }
}

/**
 * COMPLETE EXAMPLE WALKTHROUGH:
 * =============================
 * Array: [1, 1, 2, 2, 3, 4, 4, 4, 4]  ← Wait, this violates problem! Each should appear exactly 2x
 *
 * CORRECT EXAMPLE:
 * Array: [1, 1, 2, 3, 3, 4, 4]
 * Index:  0  1  2  3  4  5  6
 *
 * Looking for: Element that appears once (Answer: 2 at index 2)
 *
 * Step 1: s=0, e=6, mid=3
 *         arr[3]=3
 *         arr[2]=2, arr[4]=3
 *         Check: 2 != 3 AND 3 == 3? NO
 *         Check: 3 == 2 AND 3 != 3? NO
 *         So we don't find it yet, need to eliminate half
 *
 * Step 2: Based on pair pattern, narrow search
 *         Continue until we find element that's unique (appears once)
 *
 * RUNTIME: O(log n) - Much faster than O(n) brute force!
 * SPACE: O(1) - Only using a few variables, no extra arrays
 */

