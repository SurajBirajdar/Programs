package programs.program.newPrograms.binarySearch;

// ========================================
// BINARY SEARCH - Find Element in Sorted Array
// ========================================
// What is Binary Search?
// It's like finding a word in a dictionary. Instead of checking every page,
// you open the dictionary in the middle. If the word is after the middle,
// you ignore the first half and search the second half. Repeat this until found!
//
// Time Complexity: O(log n) - VERY FAST! (vs O(n) for linear search)
// Space Complexity: O(1) - Only uses a few variables
//
// Example: Array = [1, 2, 3, 4, 5], Find = 5
// Step 1: Check middle (3) → 5 is bigger, so ignore left half
// Step 2: Check middle of right half (4) → 5 is bigger, so go right
// Step 3: Check next element (5) → FOUND! Return index 4
// ========================================

public class GetTargetElementInSortedArray {

    // This is the entry point - where the program starts
    public static void main(String[] args) {
        // Create a sorted array with 5 numbers: [1, 2, 3, 4, 5]
        // Array is ZERO-INDEXED: index 0=1, index 1=2, index 2=3, index 3=4, index 4=5
        int arr[] = {1,2,3,4,5};

        // Call the binary search method to find number 5 in the array
        // Expected: should return index 4 (because arr[4] = 5)
        // Print the result to console
        System.out.println(getIndexOfTargetElementInSortedArray(arr,5));
    }

    // ========================================
    // METHOD: Binary Search Implementation
    // ========================================
    // Purpose: Find the INDEX (position) of a target number in a SORTED array
    //
    // Parameters:
    //   arr = the sorted array (must be in ascending order!)
    //   target = the number we want to find
    //
    // Returns:
    //   index position if found (0 to arr.length-1)
    //   -1 if not found (convention: -1 means "not found")
    // ========================================
    public static int getIndexOfTargetElementInSortedArray(int[] arr, int target) {
        // Initialize start pointer at the beginning of array (index 0)
        // Example: arr = [1,2,3,4,5] → start = 0
        int start = 0;

        // Initialize end pointer at the last position of array
        // arr.length = 5, so end = 5-1 = 4 (last valid index)
        // We use (length - 1) because array indices start from 0
        int end = arr.length - 1;

        // Variable to store the middle index
        // We'll keep updating this as we narrow down our search
        // Example: if start=0 and end=4, mid = 0+(4-0)/2 = 2
        int mid = 0;

        // Main loop: Keep searching while start is <= end
        // Meaning: Keep searching as long as there are elements to check
        // When start > end, it means we've searched the entire possible range
        // Example: if start=4 and end=3, loop stops (no more elements to check)
        while(start<=end) {
            // Calculate middle index WITHOUT integer overflow
            // WHY? mid = (start + end) / 2 can overflow if numbers are huge
            // SAFE way: mid = start + (end - start) / 2
            // Example: start=0, end=4 → mid = 0 + (4-0)/2 = 2
            //          mid points to arr[2] = 3 (the middle element)
            mid = start + (end-start)/2;

            // CHECK 1: Is the middle element our target?
            // If arr[mid] equals target, we found it!
            // Example: arr[2]=3, target=3 → MATCH! Return index 2
            if(arr[mid] == target) {
                return mid;  // Exit immediately, target is found at index 'mid'
            }
            // CHECK 2: Is target smaller than middle element?
            // If yes, target must be in the LEFT half (before middle)
            // Why? Because array is sorted! All larger numbers are to the right
            // Example: arr[2]=3, target=1 → 1 < 3, so ignore right half
            else if(target < arr[mid]) {
                // Move end pointer LEFT: shrink search space
                // end = mid - 1 (exclude middle, it's not our target)
                // Example: was searching [0 to 4], now search [0 to 1]
                end = mid - 1;
            }
            // CHECK 3: Is target larger than middle element?
            // If yes, target must be in the RIGHT half (after middle)
            // Why? Array is sorted, so target is to the right
            // Example: arr[2]=3, target=5 → 5 > 3, so ignore left half
            else if(target > arr[mid]) {
                // Move start pointer RIGHT: shrink search space
                // start = mid + 1 (exclude middle, it's not our target)
                // Example: was searching [0 to 4], now search [3 to 4]
                start = mid + 1;
            }
        }

        // If loop exits, target was NOT found
        // Return -1 as a signal: "Sorry, target not in array"
        // This is the CONVENTION in programming (standard practice)
        // Example: Searching for 10 in [1,2,3,4,5] → returns -1
        return -1;
    }
}
