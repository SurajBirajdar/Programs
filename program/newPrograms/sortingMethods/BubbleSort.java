package programs.program.newPrograms.sortingMethods;

/**
 * BUBBLE SORT ALGORITHM EXPLANATION
 * ==================================
 * Bubble Sort is like bubbles rising to the surface of water.
 * Larger elements "bubble up" to the end of the array with each pass.
 * You compare adjacent elements and swap them if they're in wrong order.
 * Keep repeating until the entire array is sorted.
 *
 * EXAMPLE: Sorting array [5,6,4,1,3]
 *
 * PASS 1 (i=0): Compare adjacent pairs and move largest to end
 *   [5,6,4,1,3] -> [5,6,4,1,3] -> [5,4,6,1,3] -> [5,4,1,6,3] -> [5,4,1,3,6]
 *   5<6? No    -> 6>4? Yes    -> 4>1? Yes    -> 1<3? No    -> Now 6 is at correct position
 *
 * PASS 2 (i=1): Repeat but ignore last element (already sorted)
 *   [5,4,1,3,6] -> [4,5,1,3,6] -> [4,1,5,3,6] -> [4,1,3,5,6]
 *   5>4? Yes   -> 5>1? Yes    -> 5>3? Yes    -> Now 5 is at correct position
 *
 * PASS 3 (i=2): Continue with remaining unsorted elements
 *   [4,1,3,5,6] -> [1,4,3,5,6] -> [1,3,4,5,6]
 *   4>1? Yes   -> 4>3? Yes    -> Now 4 is at correct position
 *
 * PASS 4 (i=3): One more pass needed
 *   [1,3,4,5,6] -> [1,3,4,5,6]
 *   3>1? No    -> Array is now fully sorted!
 *
 * Time Complexity: O(n²) - nested loops
 * Space Complexity: O(1) - sorts in place
 * Best for: Small datasets, nearly sorted data, educational purposes
 * Worst for: Large unsorted datasets
 */

public class BubbleSort {

    // MAIN METHOD - Entry point of the program
    public static void main(String[] args) {

        // EXAMPLE ARRAY: We want to sort these 5 numbers in ascending order
        // Think of it like: 5 floating balls with different weights that need to sink/rise to correct position
        int[] arr = {5,6,4,1,3};

        // CALL THE SORTING METHOD: Pass the array to be sorted
        // This will rearrange the numbers in the array using bubble sort
        bubbleSort(arr);

        // PRINT THE SORTED ARRAY: Display the result
        // This loop goes through each element and prints it
        // i=0 means start from first element, i<arr.length means continue until last element
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");  // Print each number followed by a space
        }
    }

    /**
     * BUBBLE SORT METHOD - The main sorting logic
     * ============================================
     * @param arr - The array we want to sort
     * @return - The sorted array (arrays are passed by reference, so it modifies original)
     */
    public static int[] bubbleSort(int[] arr) {

        // GET THE LENGTH OF ARRAY
        // Example: If arr = {5,6,4,1,3}, then n = 5
        // We need to know how many elements we need to sort
        int n = arr.length;

        // OUTER LOOP: Controls number of passes through the array
        // i goes from 0 to n-2 (we need n-1 passes maximum)
        // Why n-1? After n-1 passes, the smallest element will be in place, so array is sorted
        //
        // EXAMPLE: For array of 5 elements, we need 4 passes
        // Pass 1: Largest element reaches end
        // Pass 2: 2nd largest element reaches correct position
        // Pass 3: 3rd largest element reaches correct position
        // Pass 4: Rest are automatically sorted
        for(int i=0; i<n-1; i++) {

            // INNER LOOP: Compares and swaps adjacent elements in one pass
            // j goes from 0 to n-i-2
            // Why n-i-1? Because after each pass, i more elements are sorted at the end
            // So we don't need to check them again
            //
            // EXAMPLE with array {5,6,4,1,3} (n=5):
            // Pass 1 (i=0): j goes from 0 to 3 (check positions 0-1, 1-2, 2-3, 3-4)
            // Pass 2 (i=1): j goes from 0 to 2 (check positions 0-1, 1-2, 2-3) - skip position 4
            // Pass 3 (i=2): j goes from 0 to 1 (check positions 0-1, 1-2) - skip last 2
            // This optimization is called "reducing comparisons"
            for(int j=0; j<n-i-1;j++) {

                // COMPARISON: Check if current element is GREATER than next element
                // if(arr[j] > arr[j+1])
                //
                // EXAMPLE:
                // arr[0]=5, arr[1]=6 -> Is 5 > 6? NO, don't swap
                // arr[1]=6, arr[2]=4 -> Is 6 > 4? YES, swap them!
                // arr[2]=4, arr[3]=1 -> Is 4 > 1? YES, swap them!
                //
                // This condition finds pairs that are in wrong order
                if(arr[j] > arr[j+1]) {

                    // SWAP OPERATION: Exchange two adjacent elements if they're in wrong order
                    // We need a temporary variable to hold one value during swap
                    // Otherwise one value will be overwritten and lost

                    // STEP 1: Store the larger element in a temporary variable
                    // int temp = arr[j];
                    // EXAMPLE: arr[j]=6, so temp=6 (we save it temporarily)
                    int temp = arr[j];

                    // STEP 2: Put the smaller element in the larger element's position
                    // arr[j] = arr[j+1];
                    // EXAMPLE: arr[j+1]=4, so arr[j] becomes 4 (move 4 to position j)
                    // Now we have: arr[j]=4, arr[j+1]=4 (both are 4, but that's OK for now)
                    arr[j] = arr[j+1];

                    // STEP 3: Put the larger element (saved in temp) in the next position
                    // arr[j+1] = temp;
                    // EXAMPLE: We put temp=6 at position j+1
                    // Now we have: arr[j]=4, arr[j+1]=6 (swapped successfully!)
                    arr[j+1] = temp;
                }
            }
        }

        // RETURN THE SORTED ARRAY
        // Although the array is modified in place, we return it for convenience
        return arr;
    }
}
