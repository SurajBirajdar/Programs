package programs.program.newPrograms.binarySearch;

/**
 * ============================================================================
 * PEAK INDEX IN MOUNTAIN ARRAY - BINARY SEARCH SOLUTION
 * ============================================================================
 * PROBLEM STATEMENT:
 * Given a "mountain array" (also called bitonic array) where:
 * - The array strictly increases up to a peak element
 * - The array strictly decreases after the peak element
 * - Find the INDEX of the PEAK element (the maximum value)
 *
 * MOUNTAIN ARRAY PROPERTY:
 * - There is a single peak
 * - All elements before peak are smaller than peak
 * - All elements after peak are smaller than peak
 * - Pattern: increasing -> peak -> decreasing
 *
 * EXAMPLE: arr = {10, 20, 30, 40, 50, 60, 70, 35, 25}
 * - Array increases: 10 < 20 < 30 < 40 < 50 < 60 < 70 (peak)
 * - Array decreases: 70 > 35 > 25
 * - Peak is at index 6 with value 70
 *
 * APPROACH: Binary Search
 * - Compare mid element with its neighbors
 * - If mid is on the increasing side: peak is to the right (move right)
 * - If mid is on the decreasing side: peak is to the left or at mid (move left)
 * - Continue until we find the peak
 *
 * TIME COMPLEXITY: O(log n) - Binary search reduces search space by half each time
 * SPACE COMPLEXITY: O(1) - Only using a few variables
 * ============================================================================
 */
public class PeakIndexInMountainArray {

    /**
     * MAIN METHOD - Entry point demonstrating peak finding in a mountain array
     */
    public static void main(String[] args) {
        // Mountain array: strictly increases then strictly decreases
        // Pattern: 10 < 20 < 30 < 40 < 50 < 60 < 70 (PEAK) > 35 > 25
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 35, 25};

        // Find and print the index of the peak element
        System.out.println(peakIndex(arr)); // Output: 6 (index of 70, the peak)
    }

    /**
     * PEAK INDEX FUNCTION - Finds the index of peak in a mountain array
     * Uses binary search to efficiently locate the maximum element
     *
     * @param arr - Mountain array (strictly increases then strictly decreases)
     * @return Index of the peak element (the maximum value in the array)
     *
     * ALGORITHM LOGIC:
     * 1. Start with full array as search space (s = 0, e = n-1)
     * 2. Calculate mid point of current search space
     * 3. Compare arr[mid] with arr[mid+1]:
     *    - If arr[mid] < arr[mid+1]: We are on the increasing slope
     *      Peak is to the RIGHT, so move right (s = mid + 1)
     *    - If arr[mid] >= arr[mid+1]: We are on the decreasing slope or AT the peak
     *      Peak is to the LEFT or at mid, so move left and save mid (e = mid - 1)
     * 4. Continue until left and right pointers converge at the peak
     */
    public static int peakIndex(int[] arr) {
        // Get the total number of elements in the array
        int n = arr.length;

        // LEFT pointer: Start searching from the beginning of array
        int s = 0; // s stands for 'start'

        // RIGHT pointer: Start searching from the end of array
        int e = n - 1; // e stands for 'end'

        // Variable to store the index of peak element
        // Initialize as -1 (indicates not found, but will always be found in mountain array)
        int ans = -1;

        // BINARY SEARCH LOOP: Continue while search space exists (left <= right)
        while(s <= e) {
            // Calculate middle index using formula: s + (e-s)/2
            // This prevents integer overflow compared to (s+e)/2
            int mid = s + (e - s) / 2;

            // CRITICAL COMPARISON: Compare current element with next element
            // This tells us which slope we are on (increasing or decreasing)
            if(arr[mid] < arr[mid+1]) {
                // Current element is LESS than next element
                // This means we are on the INCREASING slope (moving towards peak)
                // Peak must be to the RIGHT of our current position
                s = mid + 1; // Move right to search for peak in the right half

            } else if(arr[mid] >= arr[mid+1]) {
                // Current element is GREATER than OR EQUAL to next element
                // This means we are on the DECREASING slope (past or at the peak)
                // Peak is either at mid or to the LEFT of mid
                ans = mid; // Save current index as a potential peak

                // Try to find the actual peak by searching the LEFT half
                // (peak might be to the left, but we save mid just in case)
                e = mid - 1; // Move left to search for peak in the left half
            }
        }

        // Return the index of the peak element found
        return ans;
    }
}
