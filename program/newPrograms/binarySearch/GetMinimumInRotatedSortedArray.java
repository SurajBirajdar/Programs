package programs.program.newPrograms.binarySearch;

/**
 * PROBLEM EXPLANATION FOR INTERVIEW:
 * ===================================
 * You are given a rotated sorted array and need to find the minimum element.
 *
 * Example: [4,5,6,7,0,1,2] -> Output: 0
 *
 * Real-world analogy: Imagine a bookshelf where books were sorted A-Z,
 * but someone rotated a section. We need to find the first book in alphabetical order.
 *
 * KEY CONCEPT: Use Binary Search (divide and conquer) instead of checking all elements
 * Time Complexity: O(log n) - Much faster than O(n)
 */
public class GetMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        // Example array: [4,5,1,2,3]
        // This is a rotated sorted array where the minimum is 1
        // Original was [1,2,3,4,5] but rotated to [4,5,1,2,3]
        int[] arr = {4,5,1,2,3};
        System.out.println(getMinimumInRotatedSortedArray(arr)); // Output: 1
    }

    public static int getMinimumInRotatedSortedArray(int[] arr) {
        // STEP 1: Initialize pointers for binary search
        // 'start' points to beginning of array (index 0)
        // Like placing left finger at start of a book
        int start = 0;

        // 'end' points to last element of array (index = length-1)
        // Like placing right finger at end of a book
        // For arr = [4,5,1,2,3], end = 4
        int end = arr.length-1;

        // 'mid' will store middle position (we'll calculate it in loop)
        // Like opening book in the middle to check
        int mid = 0;

        // STEP 2: Binary Search Loop
        // Keep searching until start and end pointers meet
        // This means we've narrowed down to one element - our answer!
        while(start<end) {
            // Calculate middle position
            // Formula: start + (end-start)/2 is safer than (start+end)/2
            // Why? Avoids integer overflow when numbers are very large
            // For [4,5,1,2,3]: start=0, end=4 -> mid=0+(4-0)/2=2
            // arr[2] = 1 (middle element)
            mid = start + (end-start)/2;

            // STEP 3: Decide which half to search
            // Compare middle element with rightmost element
            // If arr[mid] > arr[end]: minimum is in RIGHT half
            // Why? Because right side is not sorted, minimum must be there
            // Example: [4,5,1,2,3] -> arr[2]=1, arr[4]=3
            // 1 is NOT > 3, so we don't take this branch
            if(arr[mid] > arr[end]) {
                // Move start pointer RIGHT to search right half
                // Exclude middle because it's larger than end
                // start = mid + 1
                // Example: [6,7,0,1,2] -> arr[2]=0, arr[4]=2
                // 0 is NOT > 2, so we skip this
                start = mid+1;
            } else {
                // Otherwise: minimum is in LEFT half (including middle)
                // Move end pointer to middle to include it in search
                // For [4,5,1,2,3] -> arr[2]=1, arr[4]=3
                // 1 is NOT > 3 (it's smaller), so minimum is on left
                // end = mid (keep middle as possible answer)
                // Next iteration: start=0, end=2
                end = mid;
            }
        }

        // STEP 4: Return the answer
        // When while loop ends, start == end
        // Both point to the minimum element
        // For [4,5,1,2,3]: finally start=end=2, arr[2]=1 ✓
        return arr[start];
    }
}
