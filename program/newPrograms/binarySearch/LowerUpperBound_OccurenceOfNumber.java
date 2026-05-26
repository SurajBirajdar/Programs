package programs.program.newPrograms.binarySearch;

/**
 * ============================================================================
 * LOWER BOUND AND UPPER BOUND SEARCH - BINARY SEARCH SOLUTION
 * ============================================================================
 * PROBLEM STATEMENT:
 * Given a sorted array and a target value, find:
 * - LOWER BOUND: First position where element >= target (leftmost position)
 * - UPPER BOUND: First position where element > target (rightmost position + 1)
 * - COUNT OCCURRENCES: Use both bounds to find how many times target appears
 *
 * EXAMPLE: arr = {10, 20, 30, 30, 30, 30, 30, 40, 50}, target = 30
 * - Lower Bound of 30: index 2 (first 30)
 * - Upper Bound of 30: index 7 (first element > 30)
 * - Count: 7 - 2 = 5 occurrences
 *
 * APPROACH: Binary Search
 * - Lower Bound: Find first element >= target
 * - Upper Bound: Find first element > target
 * ============================================================================
 */
public class LowerUpperBound_OccurenceOfNumber {

    /**
     * MAIN METHOD - Entry point demonstrating lower bound and upper bound searches
     * Shows various use cases and calculates occurrence count
     */
    public static void main(String[] args) {
        // Sorted array containing numbers with duplicates
        int[] arr = {10, 20, 30, 30, 30, 30, 30, 40, 50};

        // Target value we want to find
        int target = 30;

        // Test 1: Get lower bound of 35 (doesn't exist, should return first element > 35)
        System.out.println(getLowerBound(arr, 35)); // Output: 7 (index of 40)

        // Test 2: Get upper bound of 45 (doesn't exist, should return first element > 45)
        System.out.println(getUpperBound(arr, 45)); // Output: 9 (beyond array)

        // Find the lower bound index of target (leftmost position of target)
        int lowerBoundIndex = getLowerBound(arr, target); // 2 (first 30)
        System.out.println(lowerBoundIndex); // Output: 2

        // Find the upper bound index of target (position after last occurrence)
        int upperBoundIndex = getUpperBound(arr, target); // 7 (first element > 30)
        System.out.println(upperBoundIndex); // Output: 7

        // Calculate occurrence count: upper bound - lower bound = number of occurrences
        int occurenceCount = upperBoundIndex - lowerBoundIndex;
        System.out.println("Occurence of number : " + target + " is: " + occurenceCount); // Output: 5
    }

    /**
     * LOWER BOUND FUNCTION - Finds the first element >= target
     * Returns the leftmost position where an element is >= target
     *
     * @param arr - Sorted array to search
     * @param target - Value to find the lower bound for
     * @return Index of first element >= target, or -1 if not found
     *
     * LOGIC:
     * - If arr[mid] >= target: this could be the answer, save it and search left (smaller values)
     * - If arr[mid] < target: target must be to the right, search right
     * - Continue until search space is exhausted
     */
    public static int getLowerBound(int[] arr, int target) {
        // Get the length of the array
        int n = arr.length;

        // LEFT pointer: start from the beginning of array
        int s = 0;

        // RIGHT pointer: start from the end of array
        int e = n - 1;

        // Initialize answer as -1 (means not found)
        int ans = -1;

        // BINARY SEARCH LOOP: Continue while left <= right
        while (s <= e) {
            // Calculate middle index to avoid overflow: mid = s + (e-s)/2
            int mid = s + (e - s) / 2;

            // Check if current element at mid is greater than or equal to target
            if (arr[mid] >= target) {
                // Found a candidate answer! Store this index
                ans = mid;

                // Try to find an even smaller index (go left) to find FIRST occurrence
                e = mid - 1; // Shrink search space to left half
            } else {
                // Current element is smaller than target
                // Target must be on the right side
                s = mid + 1; // Shrink search space to right half (search right)
            }
        }

        // Return the lower bound index (or -1 if not found)
        return ans;
    }

    /**
     * UPPER BOUND FUNCTION - Finds the first element > target
     * Returns the position after the last occurrence of target (leftmost position where element > target)
     *
     * @param arr - Sorted array to search
     * @param target - Value to find the upper bound for
     * @return Index of first element > target, or array length if not found
     *
     * LOGIC:
     * - If arr[mid] <= target: target is still at mid or to the right, search right
     * - If arr[mid] > target: this could be the answer, save it and search left (to find FIRST > target)
     * - Continue until search space is exhausted
     */
    public static int getUpperBound(int[] arr, int target) {
        // Get the length of the array
        int n = arr.length;

        // LEFT pointer: start from the beginning of array
        int s = 0;

        // RIGHT pointer: start from the end of array
        int e = n - 1;

        // Initialize answer as n (means all elements <= target)
        // Array length is used because any index >= n is outside the array
        int ans = n;

        // BINARY SEARCH LOOP: Continue while left <= right
        while (s <= e) {
            // Calculate middle index to avoid overflow: mid = s + (e-s)/2
            int mid = s + (e - s) / 2;

            // Check if current element at mid is less than or equal to target
            if (arr[mid] <= target) {
                // Element is too small or equal, target must be on the right
                // Move to right half to find first element > target
                s = mid + 1;
            } else {
                // Current element is GREATER than target
                // Found a candidate answer! Store this index
                ans = mid;

                // Try to find an even smaller index (go left) to find FIRST element > target
                e = mid - 1; // Shrink search space to left half
            }
        }

        // Return the upper bound index (or n if all elements <= target)
        return ans;
    }
}
