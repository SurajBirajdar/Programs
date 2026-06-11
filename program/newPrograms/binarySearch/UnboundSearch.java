package programs.program.newPrograms.binarySearch;

/**
 * PROBLEM EXPLANATION:
 * ====================
 * Search for a TARGET element in an INFINITE or UNKNOWN SIZE sorted array
 *
 * KEY DIFFERENCE from normal Binary Search:
 * - We DON'T know the array size
 * - We DON'T know the end index (might be infinite!)
 * - We can't use arr.length
 *
 * EXAMPLE:
 * Array: [70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220...]
 * Target: 140
 * We don't know how many elements exist, maybe infinite!
 *
 * ALGORITHM IN 2 STEPS:
 * =====================
 * STEP 1: Find the RANGE where target might exist
 *         - Start with i=1 and keep doubling: 1, 2, 4, 8, 16, 32...
 *         - Stop when arr[i] > target (we found the range!)
 *         - Now we know: target is between arr[i/2] and arr[i]
 *
 * STEP 2: Do normal Binary Search within that range
 *         - Use standard binary search on the found range
 *         - Time: O(log n) where n is position of target
 *
 * WHY THIS WORKS?
 * ===============
 * Instead of searching infinite array at once, we exponentially narrow down
 * the search space FIRST (finding bounds), then do binary search WITHIN those bounds.
 *
 * TIME COMPLEXITY: O(log n) where n is the position of target
 * SPACE COMPLEXITY: O(1) - only using a few variables
 */
public class UnboundSearch {

    public static void main(String[] args) {
        // Test array: sorted but we pretend we don't know its size
        // IMAGINE: This could go on forever! [70, 80, 90, 100, ...]
        int[] arr = {70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220};

        // The element we're searching for
        // EXAMPLE: We want to find 140
        int target = 140;

        // Call our function and print the result (should be index 7)
        System.out.println(unboundSearch(arr, target));
    }

    /**
     * MAIN FUNCTION: Search in infinite/unknown size array
     * =====================================================
     * This function:
     * 1. Checks if first element is target (quick check)
     * 2. Exponentially finds the upper bound where target might be
     * 3. Does binary search within the found bounds
     *
     * @param arr - Sorted array of unknown/infinite size
     * @param target - The element we want to find
     * @return - Index of target if found, -1 otherwise
     */
    public static int unboundSearch(int[] arr, int target) {

        // ============================================
        // STEP 1: Check if target is at the very start
        // ============================================

        // Check if the FIRST element equals our target
        // EXAMPLE: If arr[0] = 70 and target = 70, we found it immediately!
        if(arr[0] == target) {
            // Return 0 because target is at index 0
            return 0;
        }

        // ============================================
        // STEP 2: Find the UPPER BOUND where target exists
        // ============================================

        // Start with position i = 1
        // EXAMPLE: i = 1, we'll check arr[1], arr[2], arr[4], arr[8], arr[16]...
        int i = 1;

        // Keep DOUBLING i until arr[i] > target
        // WHY double? Because it's exponential - we find bound in O(log n) time!
        // EXAMPLE: If target = 140:
        //          i=1: arr[1]=80, is 80 <= 140? YES, double to i=2
        //          i=2: arr[2]=90, is 90 <= 140? YES, double to i=4
        //          i=4: arr[4]=110, is 110 <= 140? YES, double to i=8
        //          i=8: arr[8]=150, is 150 <= 140? NO, STOP! We found the range
        while(arr[i] <= target) {
            // DOUBLE the position (multiply by 2)
            // EXAMPLE: i = 1 → 2 → 4 → 8 → 16 → 32...
            i = i * 2;
        }

        // Now we know:
        // - arr[i/2] <= target (left boundary)
        // - arr[i] > target (right boundary)
        // So target is DEFINITELY between i/2 and i (if it exists at all)

        // ============================================
        // STEP 3: Do normal Binary Search in the range
        // ============================================

        // Safety check: if arr[i] > target, then range is valid
        // EXAMPLE: If arr[8] = 150 > 140, yes, range is valid
        if(arr[i] > target) {

            // Set END pointer to the current position i
            // EXAMPLE: e = 8, this is our right boundary
            int e = i;

            // Set START pointer to i/2
            // WHY? Because we know target can't be before i/2
            // EXAMPLE: s = 8/2 = 4, this is our left boundary
            int s = i / 2;

            // Standard Binary Search loop
            // Continue while START hasn't crossed END
            // EXAMPLE: While 4 <= 8, keep searching
            while(s <= e) {

                // Find the middle position between start and end
                // Formula: s + (e-s)/2 prevents overflow
                // EXAMPLE: 4 + (8-4)/2 = 4 + 2 = 6
                int mid = s + (e - s) / 2;

                // Check if element at middle is our target
                // EXAMPLE: Is arr[6] = 130 equal to 140? NO
                if(arr[mid] == target) {
                    // FOUND IT! Return the index
                    return mid;
                }

                // If middle element is GREATER than target
                // Target must be on the LEFT side
                // EXAMPLE: arr[6]=130... wait that's NOT > 140
                if(arr[mid] > target) {
                    // Move end pointer LEFT (eliminate right half)
                    // EXAMPLE: e = 6 - 1 = 5
                    e = mid - 1;
                } else {
                    // Middle element is LESS than target
                    // Target must be on the RIGHT side
                    // EXAMPLE: arr[6]=130 < 140? Actually no, 130 < 140 is TRUE
                    // Move start pointer RIGHT (eliminate left half)
                    // EXAMPLE: s = 6 + 1 = 7
                    s = mid + 1;
                }
            }
        }

        // If we exit the while loop without finding target
        // Return -1 to indicate "NOT FOUND"
        return -1;
    }
}

/**
 * COMPLETE EXAMPLE WALKTHROUGH:
 * =============================
 *
 * Array: [70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220]
 * Index:  0   1   2    3    4    5    6    7    8    9    10   11   12   13   14   15
 * Target: 140
 *
 * ===== PHASE 1: FINDING THE BOUND =====
 *
 * i=1:  arr[1]=80,  is 80 <= 140? YES → i = 1*2 = 2
 * i=2:  arr[2]=90,  is 90 <= 140? YES → i = 2*2 = 4
 * i=4:  arr[4]=110, is 110 <= 140? YES → i = 4*2 = 8
 * i=8:  arr[8]=150, is 150 <= 140? NO → STOP!
 *
 * Range found: Between i/2=4 and i=8
 * Subarray to search: [110, 120, 130, 140, 150]
 *
 * ===== PHASE 2: BINARY SEARCH IN RANGE [4, 8] =====
 *
 * Iteration 1: s=4, e=8, mid=6
 *              arr[6]=130, is 130 == 140? NO
 *              is 130 > 140? NO
 *              130 < 140? YES → s = 6+1 = 7
 *
 * Iteration 2: s=7, e=8, mid=7
 *              arr[7]=140, is 140 == 140? YES!
 *              FOUND! Return 7
 *
 * ===== FINAL ANSWER: 7 =====
 *
 * HOW EFFICIENT?
 * ==============
 * Finding bound: i goes 1→2→4→8, so ~log₂(position of target) = ~3 steps
 * Binary search: ~log₂(range size) = ~log₂(4) = 2 steps
 * Total: O(log n) where n is position of target in infinite array
 *
 * MUCH BETTER than O(n) where we'd check every element!
 * MUCH BETTER than O(m) where m is total array size!
 */

