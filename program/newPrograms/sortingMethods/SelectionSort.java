package programs.program.newPrograms.sortingMethods;

/**
 * SELECTION SORT ALGORITHM EXPLANATION
 * =====================================
 * Selection Sort is like picking the smallest student from a group and putting them in line first.
 * You find the smallest element, put it at the beginning, then repeat for the remaining elements.
 *
 * REAL-WORLD ANALOGY:
 * Imagine you have 5 playing cards: [5, 6, 4, 1, 3]
 * Step 1: Find smallest (1), put it at position 0 -> [1, 6, 4, 5, 3]
 * Step 2: Find smallest in remaining (3), put it at position 1 -> [1, 3, 4, 5, 6]
 * Step 3: Find smallest in remaining (4), it's already there -> [1, 3, 4, 5, 6]
 * Step 4: Find smallest in remaining (5), it's already there -> [1, 3, 4, 5, 6]
 * Step 5: Only 6 remains, array is sorted!
 *
 * EXAMPLE: Sorting array [5,6,4,1,3]
 *
 * PASS 1 (i=0): Find minimum from index 0 to 4
 *   Check: 5,6,4,1,3 -> Minimum is 1 at index 3
 *   Swap arr[0] with arr[3] -> [1,6,4,5,3]
 *
 * PASS 2 (i=1): Find minimum from index 1 to 4
 *   Check: 6,4,5,3 -> Minimum is 3 at index 4
 *   Swap arr[1] with arr[4] -> [1,3,4,5,6]
 *
 * PASS 3 (i=2): Find minimum from index 2 to 4
 *   Check: 4,5,6 -> Minimum is 4 at index 2
 *   No swap needed (already in correct position)
 *
 * PASS 4 (i=3): Find minimum from index 3 to 4
 *   Check: 5,6 -> Minimum is 5 at index 3
 *   No swap needed
 *
 * PASS 5 (i=4): Only one element left, array is sorted!
 *
 * Time Complexity: O(n²) - two nested loops
 * Space Complexity: O(1) - sorts in place
 * Best for: Small datasets, when memory is limited
 * Advantage: Minimum number of swaps compared to bubble sort
 */

public class SelectionSort {

    // MAIN METHOD - Entry point of the program
    public static void main(String[] args) {

        // EXAMPLE ARRAY: We want to sort these 5 numbers in ascending order
        // Think of it like: 5 students with different heights needing to stand from shortest to tallest
        int[] arr = {5,6,4,1,3};

        // CALL THE SORTING METHOD: Pass the array to be sorted
        // This will rearrange the numbers using selection sort
        selectionSort(arr);

        // PRINT THE SORTED ARRAY: Display the result
        // This loop goes through each element and prints it
        // i=0 means start from first element, i<arr.length means continue until last element
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");  // Print each number followed by a space
        }
    }

    /**
     * SELECTION SORT METHOD - The main sorting logic
     * ===============================================
     * @param arr - The array we want to sort
     * @return - The sorted array (arrays are passed by reference, so it modifies original)
     */
    public static int[] selectionSort(int[] arr) {

        // GET THE LENGTH OF ARRAY
        // Example: If arr = {5,6,4,1,3}, then n = 5
        // We need to know how many elements we need to sort
        int n = arr.length;

        // OUTER LOOP: Controls the position where we place each smallest element
        // i goes from 0 to n-1 (technically we only need n-1 iterations, last element is automatic)
        //
        // WHAT HAPPENS IN EACH ITERATION:
        // i=0: Find smallest from all elements, put at position 0
        // i=1: Find smallest from remaining elements, put at position 1
        // i=2: Find smallest from remaining elements, put at position 2
        // i=3: Find smallest from remaining elements, put at position 3
        // i=4: Only one element left, must be largest
        //
        // EXAMPLE with array {5,6,4,1,3}:
        // When i=0, we're working with the entire array [5,6,4,1,3]
        // When i=1, we already placed 1 at position 0, now work with [6,4,5,3]
        // When i=2, we already placed 1,3, now work with [4,5,6]
        for(int i=0; i<n; i++) {

            // INITIALIZE MINIMUM INDEX
            // minIndex = i;
            // This assumes the current position i has the smallest element
            // We'll update this if we find a smaller element to the right
            //
            // EXAMPLE: When i=0, minIndex=0 (we assume arr[0]=5 is smallest)
            // When i=1, minIndex=1 (we assume arr[1]=6 is smallest among remaining)
            int minIndex = i;

            // INNER LOOP: Search for the smallest element from position i+1 to end
            // j = i+1; means start from the next element after current position
            // j < n; means continue until we reach the end
            // j++; move to next element
            //
            // WHY START FROM i+1?
            // Because positions 0 to i-1 are already sorted (have smallest elements placed)
            // We only need to search from i+1 onwards
            //
            // EXAMPLE with array {5,6,4,1,3} when i=0:
            // j starts at 1 (position after 0)
            // j goes: 1, 2, 3, 4
            // We check arr[1]=6, arr[2]=4, arr[3]=1, arr[4]=3
            for(int j=i+1; j<n; j++) {

                // COMPARISON: Check if current element is SMALLER than the minimum found so far
                // if(arr[j] < arr[minIndex])
                // This condition identifies elements smaller than minIndex
                //
                // EXAMPLE: In first iteration (i=0, minIndex=0):
                // j=1: Is arr[1]=6 < arr[0]=5? NO, minIndex stays 0
                // j=2: Is arr[2]=4 < arr[0]=5? YES, update minIndex=2
                // j=3: Is arr[3]=1 < arr[2]=4? YES, update minIndex=3
                // j=4: Is arr[4]=3 < arr[3]=1? NO, minIndex stays 3
                //
                // After loop: minIndex=3 (points to 1, which is the smallest)
                if(arr[j] < arr[minIndex]) {

                    // UPDATE MINIMUM INDEX
                    // minIndex = j;
                    // We found a smaller element at position j, so update minIndex to point to it
                    // This way, minIndex always points to the smallest element found so far
                    minIndex = j;
                }
            }

            // SWAP OPERATION: Exchange elements at position i and minIndex
            // This puts the smallest element at the correct sorted position
            // We need a temporary variable because we'll overwrite one value

            // STEP 1: Store the element at minIndex (the smallest) in temporary variable
            // int temp = arr[minIndex];
            // EXAMPLE: arr[minIndex]=1, so temp=1 (save it temporarily)
            int temp = arr[minIndex];

            // STEP 2: Put the element at position i into minIndex position
            // arr[minIndex] = arr[i];
            // EXAMPLE: arr[i]=5, so arr[minIndex]=5
            // Now arr[3]=5 (we moved 5 from position 0 to position 3)
            arr[minIndex] = arr[i];

            // STEP 3: Put the smallest element (saved in temp) at position i
            // arr[i] = temp;
            // EXAMPLE: We put temp=1 at position 0
            // Now arr[0]=1 (1 is now in correct sorted position!)
            //
            // COMPLETE EXAMPLE OF SWAP:
            // Before: arr[0]=5, arr[3]=1
            // Step 1: temp=1
            // Step 2: arr[3]=5 (now both positions have: arr[0]=5, arr[3]=5)
            // Step 3: arr[0]=1 (now we have: arr[0]=1, arr[3]=5) SWAPPED!
            arr[i] = temp;
        }

        // RETURN THE SORTED ARRAY
        // Although the array is modified in place, we return it for convenience
        return arr;
    }
}
