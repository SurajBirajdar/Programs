package programs.program.newPrograms.binarySearch;

/**
 * ============================================================================
 * PIVOT INDEX IN ROTATED SORTED ARRAY - BINARY SEARCH SOLUTION
 * ============================================================================
 * PROBLEM STATEMENT:
 * Given a ROTATED SORTED ARRAY, find the PIVOT INDEX (rotation point)
 * - Pivot Index: The index where the array was rotated
 *   (the point where the largest element is followed by the smallest element)
 * - The array was originally sorted in ascending order, then rotated
 *
 * ROTATED ARRAY DEFINITION:
 * - Original: {10, 20, 30, 40, 50, 60, 70}
 * - Rotated by 3: {50, 60, 70, 10, 20, 30, 40}
 * - Pivot index: 2 (value 70 is the largest, followed by 10 which is smallest)
 * - At pivot: arr[pivot] > arr[pivot+1] (the break point)
 *
 * KEY INSIGHT:
 * - Right half (from pivot+1 to end): All elements < last element of array
 * - Left half (from start to pivot): All elements > last element of array
 * - Use this property to find the pivot using binary search
 *
 * APPROACH: Binary Search
 * - Compare mid element with last element (arr[n-1])
 * - If arr[mid] > arr[n-1]: Pivot is to the RIGHT (move right)
 * - If arr[mid] <= arr[n-1]: Pivot is to the LEFT or at mid (move left)
 * - Continue until we find the pivot
 *
 * TIME COMPLEXITY: O(log n) - Binary search on rotated array
 * SPACE COMPLEXITY: O(1) - Only using a few variables
 * ============================================================================
 */
public class PivotIndexInRotatedSortedArray {

    /**
     * MAIN METHOD - Entry point demonstrating pivot finding in rotated array
     */
    public static void main(String[] args) {
        // Rotated sorted array
        // Original sorted: {10, 20, 30, 40, 50, 60, 70}
        // Rotated by 3 positions: {50, 60, 70, 10, 20, 30, 40}
        // Pivot index is at 2 (where 70 is followed by 10)
        int[] arr = {50, 60, 70, 10, 20, 30, 40};

        // Find and print the pivot index (rotation point)
        System.out.println(pivotIndexInRotatedSortedArray(arr)); // Output: 2
    }

    /**
     * PIVOT INDEX FUNCTION - Finds the rotation point in a rotated sorted array
     * Uses binary search to efficiently locate the pivot element
     *
     * @param arr - Rotated sorted array (originally sorted, then rotated)
     * @return Index of the pivot element (largest element in array),
     *         or -1 if array is not rotated (already sorted)
     *
     * ALGORITHM LOGIC:
     * 1. First check if array is already sorted (no rotation)
     *    - If arr[start] < arr[end]: array is sorted, return -1
     * 2. Use binary search with arr[n-1] (last element) as reference
     * 3. Compare arr[mid] with arr[n-1]:
     *    - If arr[mid] > arr[n-1]: mid is in LEFT half (before pivot)
     *      Pivot is to the RIGHT, so move right (s = mid + 1)
     *    - If arr[mid] <= arr[n-1]: mid is in RIGHT half (after or at pivot)
     *      Pivot is to the LEFT or at mid, so move left (e = mid - 1)
     * 4. Continue until left and right pointers converge at the pivot
     */
    public static int pivotIndexInRotatedSortedArray(int[] arr) {
        // Get the total number of elements in the array
        int n = arr.length;

        // LEFT pointer: Start searching from the beginning of array
        int s = 0;

        // RIGHT pointer: Start searching from the end of array
        int e = n - 1;

        // Variable to store the index of pivot element
        // Initialize as -1 (indicates no rotation or not found)
        int ans = -1;

        // CHECK IF ARRAY IS NOT ROTATED (already sorted)
        // If first element < last element: array is already sorted (no rotation)
        if(arr[s] < arr[e]) {
            // Array is sorted in ascending order without any rotation
            return -1; // Return -1 to indicate no pivot found (no rotation)
        }

        // BINARY SEARCH LOOP to find the pivot index
        // Continue while search space exists (left <= right)
        while(s <= e) {
            // Calculate middle index to avoid overflow: mid = s + (e-s)/2
            int mid = s + (e - s) / 2;

            // CRITICAL COMPARISON: Compare current element with LAST element
            // Last element (arr[n-1]) is used as the reference point
            // because it determines which half of the rotated array we are in

            if(arr[mid] > arr[n-1]) {
                // Current element is GREATER than last element
                // This means mid is in the LEFT half (before the rotation point)
                // All elements in left half are greater than last element
                // Pivot (where large values end and small values begin) is to the RIGHT
                ans = mid; // Save this index as potential pivot

                // Move right to search further right for the actual pivot
                s = mid + 1; // Search in right half

            } else if(arr[mid] <= arr[n-1]) {
                // Current element is LESS THAN or EQUAL to last element
                // This means mid is in the RIGHT half (after the rotation point)
                // All elements in right half are smaller than or equal to last element
                // Pivot must be to the LEFT of mid
                e = mid - 1; // Move left to search for pivot in left half
            }
        }

        // Return the pivot index (where the largest element is located)
        // This is the rotation point of the array
        return ans;
    }
}
