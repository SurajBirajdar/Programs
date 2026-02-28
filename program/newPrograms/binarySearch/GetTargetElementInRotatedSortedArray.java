package programs.program.newPrograms.binarySearch;

/**
 * PROBLEM: Find a target number in a ROTATED SORTED ARRAY
 *
 * Example: arr = {4,5,6,1,2,3}, target = 1
 * This array was originally {1,2,3,4,5,6}, but it got rotated.
 * We need to find position of 1, which is at index 3.
 *
 * WHY ROTATED ARRAY IS TRICKY:
 * - Normal sorted array: {1,2,3,4,5,6} -> Normal binary search works
 * - Rotated array: {4,5,6,1,2,3} -> One part is sorted, one part is not!
 *
 * SOLUTION: Use BINARY SEARCH but check which part is sorted first,
 * then decide which side to search based on that.
 */
public class GetTargetElementInRotatedSortedArray {

    // MAIN METHOD - Entry point of the program
    public static void main(String[] args) {
        // Create an array: {4,5,6,1,2,3}
        // Original sorted order was {1,2,3,4,5,6}, but it's rotated at position 3
        int[] arr = {4,5,6,1,2,3};

        // Call the function to find number 1 in this array
        // Expected result: index 3 (because arr[3] = 1)
        System.out.println(getTargetInRotatedSortedArray(arr,1));
    }

    /**
     * MAIN FUNCTION: Search for target in rotated sorted array
     *
     * @param arr - The rotated sorted array (example: {4,5,6,1,2,3})
     * @param target - The number we're looking for (example: 1)
     * @return - The index where target is found, or -1 if not found
     *
     * TIME COMPLEXITY: O(log n) - because we use binary search
     * SPACE COMPLEXITY: O(1) - we only use a few variables
     */
    public static int getTargetInRotatedSortedArray(int[] arr, int target) {

        // left pointer starts at the beginning of array
        // Example: arr = {4,5,6,1,2,3}, left = 0 (points to 4)
        int left = 0;

        // right pointer starts at the end of array
        // Example: arr = {4,5,6,1,2,3}, right = 5 (points to 3)
        int right = arr.length - 1;

        // mid will store the middle position (we'll calculate it in the loop)
        int mid;

        // Keep searching while left pointer is less than or equal to right pointer
        // Example: Initially left=0, right=5, so 0<=5 is true, we enter loop
        // When left > right, we've searched everywhere, so we exit
        while(left <= right) {

            // Find the middle position
            // Formula: left + (right - left) / 2
            // Why this formula? To avoid integer overflow (safer than (left+right)/2)
            // Example: left=0, right=5 → mid = 0 + (5-0)/2 = 2
            // So mid points to arr[2] = 6
            mid = left + (right - left) / 2;

            // CHECK 1: Did we find the target?
            // Example: If arr[2]=6 and target=1, then 6 != 1, so we don't return here
            if(target == arr[mid]) {
                return mid; // Found it! Return the position
            }

            // CHECK 2: Is the LEFT HALF sorted?
            // arr[left] < arr[mid] means left part is in sorted order
            // Example: arr[0]=4 < arr[2]=6, so YES, left part is sorted!
            // Left part: {4,5,6} - this is sorted
            // If arr[left] >= arr[mid], then RIGHT part must be sorted instead
            else if(arr[left] < arr[mid]) {

                // The left part IS SORTED: {4,5,6}
                // Now check: Is our target in this sorted left part?
                // target >= arr[left] AND target <= arr[mid]
                // Example: target=1, arr[left]=4, arr[mid]=6
                // Check: 1 >= 4? NO! So target is NOT in the left part
                if(target >= arr[left] && target <= arr[mid]) {
                    // Target is in the left sorted part
                    // So we search in the left part
                    right = mid - 1; // Move right pointer to exclude right half
                    // Example: If this was true, right would become 1
                } else {
                    // Target is NOT in the left part
                    // So it must be in the right part (which is unsorted)
                    left = mid + 1; // Move left pointer to exclude left half
                    // Example: left becomes 3 (we move from 0 to 3)
                    // Now searching in: {1,2,3}
                }
            }

            // CHECK 3: The LEFT HALF is NOT sorted, so RIGHT HALF must be sorted
            else {
                // Right part is sorted
                // Example: Right part would be {1,2,3} which is sorted
                // Now check: Is our target in this sorted right part?
                // target > arr[mid] AND target <= arr[right]
                // Example: target=1, arr[mid]=6, arr[right]=3
                // Check: 1 > 6? NO! So target is not in "above mid" part
                if(target > arr[mid] && target <= arr[right]) {
                    // Target is in the right sorted part
                    left = mid + 1; // Move left pointer to search right
                } else {
                    // Target is NOT in the right part
                    // So it must be in the left part
                    right = mid - 1; // Move right pointer to search left
                    // Example: right becomes 1
                }
            }
        }

        // If we exit the loop without finding target, return -1
        // -1 is a special code meaning "NOT FOUND"
        return -1;
    }
}

/**
 * EXAMPLE WALKTHROUGH with arr={4,5,6,1,2,3}, target=1:
 *
 * ITERATION 1:
 *   left=0, right=5, mid=2
 *   arr[2]=6, target=1
 *   6 != 1, so not found yet
 *   arr[0]=4 < arr[2]=6? YES, left part {4,5,6} is sorted
 *   Is 1 between 4 and 6? NO
 *   So search right: left = 3
 *
 * ITERATION 2:
 *   left=3, right=5, mid=4
 *   arr[4]=2, target=1
 *   2 != 1, so not found yet
 *   arr[3]=1 < arr[4]=2? YES, left part {1,2} is sorted
 *   Is 1 between 1 and 2? YES! (1 >= 1 and 1 <= 2)
 *   So search left: right = 3
 *
 * ITERATION 3:
 *   left=3, right=3, mid=3
 *   arr[3]=1, target=1
 *   1 == 1? YES!
 *   RETURN 3 ✓
 *
 * ANSWER: Index 3 (arr[3] = 1)
 */

