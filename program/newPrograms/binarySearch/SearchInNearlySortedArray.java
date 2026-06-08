package programs.program.newPrograms.binarySearch;

/**
 * SEARCH IN NEARLY SORTED ARRAY - Interview Explanation Guide
 *
 * CONCEPT: A "nearly sorted" array means elements might be slightly out of order.
 * Example: {10,30,20,50,40,70,60,80} - it's mostly sorted but some elements are off by 1-2 positions
 *
 * PROBLEM: Find a target number in this nearly sorted array using BINARY SEARCH
 * WHY? Binary search is very fast - O(log n) time complexity (like finding a contact in phone book)
 *
 * ALGORITHM LOGIC:
 * In a normal binary search, we only check middle element.
 * But in a NEARLY SORTED array, the target might be at: mid-1, mid, or mid+1
 * So we check all THREE positions before moving our search range.
 */

public class SearchInNearlySortedArray {

    // MAIN METHOD - Entry point of the program (where execution starts)
    public static void main(String[] args) {
        // ARRAY DEFINITION: Create a nearly sorted array with 8 numbers
        // Think of it like a list of sorted students' heights, but some are slightly out of place
        // Example: {10, 30, 20, 50, 40, 70, 60, 80}
        //           ^   ^   ^ (these are not in perfect order)
        int[] arr = {10,30,20,50,40,70,60,80};

        // TARGET: What number are we looking for? We want to find 80 in the array
        // Think: "Find the phone number 80 in the contact list"
        int target = 80;

        // FUNCTION CALL: Call our search function and print the result
        // searchInNearlySortedArray returns the INDEX (position) where 80 is found
        // For example: If 80 is at position 7, it will print 7
        System.out.println(searchInNearlySortedArray(arr,target));
    }

    // SEARCH FUNCTION - Does the actual binary search on nearly sorted array
    // Parameters: arr = array to search in, target = number to find
    // Returns: position of target (or -1 if not found)
    public static int searchInNearlySortedArray(int[] arr, int target) {

        // START POINTER: Set to beginning of array (index 0)
        // Think: "Left boundary of our search zone" - like starting from page 1 of a book
        int s = 0;

        // END POINTER: Set to last position of array (arr.length - 1)
        // Think: "Right boundary of our search zone" - like ending at last page of book
        // For our array of 8 elements: arr.length = 8, so e = 7
        int e = arr.length - 1;

        // BINARY SEARCH LOOP: Keep searching until we find the element
        // Condition s <= e means: "Keep searching while left boundary hasn't crossed right boundary"
        // Like pages 1-300, then pages 1-150, then pages 1-75, etc. (keep dividing)
        while(s <= e) {

            // MID CALCULATION: Find the middle position between start and end
            // Formula: s + (e-s)/2 is safer than (s+e)/2 (avoids overflow with large numbers)
            // Example: If s=0, e=7, then mid = 0 + (7-0)/2 = 3 (middle position)
            // Think: "Open the middle page of the book"
            int mid = s + (e-s)/2;

            // CHECK LEFT NEIGHBOR: Is our target at mid-1 position (one position to the left)?
            // Remember: In nearly sorted array, target might be off by one position
            // Example: arr[2] might be our target 80
            if(arr[mid-1] == target) {
                // Yes! Found it at position mid-1, return this position
                // Example: If target is at index 2, return 2
                return mid-1;
            }

            // CHECK MID POSITION: Is our target exactly at the middle position?
            // Example: arr[3] == 80? Then target is found
            if(arr[mid] == target) {
                // Yes! Target is at the middle, return the middle index
                // Example: If target is at index 3, return 3
                return mid;
            }

            // CHECK RIGHT NEIGHBOR: Is our target at mid+1 position (one position to the right)?
            // Remember: In nearly sorted array, target could be displaced by 1 position right
            // Example: arr[4] might be our target 80
            if(arr[mid+1] == target) {
                // Yes! Target is one position to the right, return that position
                // Example: If target is at index 4, return 4
                return mid+1;
            }

            // DECIDE SEARCH DIRECTION: Where to continue searching?
            // If target is BIGGER than middle element, target must be on the RIGHT side
            // Example: If mid element is 50 and target is 80, 80 must be to the right
            if(target > arr[mid]) {
                // Move start pointer to right
                // s = mid + 1 means "ignore everything from start to mid, search from mid+1 onwards"
                // Think: "Found out target is in the right half, ignore left half"
                s = mid + 1;
            } else {
                // If target is NOT bigger than middle, it's on the LEFT side or equal (already checked)
                // Move end pointer to left
                // e = mid - 1 means "ignore everything from mid to end, search up to mid-1"
                // Think: "Found out target is in the left half, ignore right half"
                e = mid - 1;
            }
        }

        // NOT FOUND: If we exit the while loop, it means target doesn't exist in array
        // Return -1 to indicate "not found" (like returning null/empty in other languages)
        // Example: If looking for 100 in {10,30,20,50,40,70,60,80}, return -1
        return -1;
    }
}

/**
 * EXAMPLE WALKTHROUGH - How the search works step by step:
 *
 * Array: {10, 30, 20, 50, 40, 70, 60, 80}
 * Target: 80
 *
 * ITERATION 1:
 * s=0, e=7, mid=3
 * Check arr[2]=20 (no), arr[3]=50 (no), arr[4]=40 (no)
 * 80 > 50, so move right: s = 4
 *
 * ITERATION 2:
 * s=4, e=7, mid=5
 * Check arr[4]=40 (no), arr[5]=70 (no), arr[6]=60 (no)
 * 80 > 70, so move right: s = 6
 *
 * ITERATION 3:
 * s=6, e=7, mid=6
 * Check arr[5]=70 (no), arr[6]=60 (no), arr[7]=80 (YES!)
 * Return 7
 *
 * TIME COMPLEXITY: O(log n) - Very fast! Like finding a word in dictionary
 * SPACE COMPLEXITY: O(1) - Uses only a few variables, no extra space
 *
 * HOW TO EXPLAIN IN INTERVIEW:
 * "I'm using Binary Search which is much faster than checking every element.
 * Since the array is nearly sorted, the target might be at mid-1, mid, or mid+1.
 * I check all three positions and then eliminate half the remaining array.
 * This gives me O(log n) time complexity."
 */

