package programs.program.newPrograms.sortingMethods;

/**
 * INSERTION SORT ALGORITHM EXPLANATION
 * ====================================
 * Insertion Sort is like arranging playing cards in your hand.
 * You pick one card at a time and insert it in the correct position among already sorted cards.
 *
 * EXAMPLE: Sorting array [5,6,4,1,3]
 * Step 1: [5] | [6,4,1,3]  -> 5 is already sorted
 * Step 2: [5,6] | [4,1,3]  -> Compare 6 with 5, no change needed
 * Step 3: [4,5,6] | [1,3]  -> Insert 4 between 5 and 6
 * Step 4: [1,4,5,6] | [3]  -> Insert 1 at beginning
 * Step 5: [1,3,4,5,6]      -> Insert 3 in correct position
 *
 * Time Complexity: O(n²) in worst case, O(n) in best case
 * Space Complexity: O(1) - sorts in place
 * Best for: Small datasets or nearly sorted data
 */

public class InsertionSort {

    // MAIN METHOD - Entry point of the program, like the starting gate of a race
    public static void main(String[] args) {

        // EXAMPLE ARRAY: We want to sort these 5 numbers in ascending order
        // Think of it like: 5 students with different heights that need to stand in line from shortest to tallest
        int[] arr = {5,6,4,1,3};

        // CALL THE SORTING METHOD: Pass the array to be sorted
        // This will rearrange the numbers in the array
        insertionSort(arr);

        // PRINT THE SORTED ARRAY: Display the result
        // This loop goes through each element one by one and prints it
        // i=0 means start from first element, i<arr.length means continue until last element
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");  // Print each number followed by a space
        }
    }

    /**
     * INSERTION SORT METHOD - The main logic
     * =====================================
     * @param arr - The array we want to sort
     * @return - The sorted array (since arrays are passed by reference, it modifies original)
     */
    public static int[] insertionSort(int[] arr) {

        // GET THE LENGTH OF ARRAY
        // Example: If arr = {5,6,4,1,3}, then n = 5
        // We need to know how many numbers we need to sort
        int n = arr.length;

        // OUTER LOOP: Start from the 2nd element (index 1) and go till the last element
        // Why start from index 1? Because first element is already considered sorted
        // Think of it: You start with one card in hand, then pick cards one by one
        // i=1 means pick 2nd element, i=2 means pick 3rd element, etc.
        for(int i=1; i<n; i++) {

            // CURRENT INDEX: This is the position of the element we're currently inserting
            // Example: When i=2, curr=2 (we're working with 3rd element which is 4)
            int curr = i;

            // PREVIOUS INDEX: This points to the element just before our current element
            // Example: When i=2, prev=1 (position of 6 in {5,6,4,1,3})
            // This is where we start comparing from (the element to the left)
            int prev = i - 1;

            // CURRENT VALUE: Extract the value of the element we want to insert
            // Example: When i=2, currentValue = 4 (the element at index 2 in {5,6,4,1,3})
            // We store this value because we'll move other elements and need to remember this number
            int currentValue = arr[i];

            // INNER WHILE LOOP: Compare and shift elements to the right
            // This loop runs as long as TWO CONDITIONS are true:
            // 1) prev >= 0 : We haven't reached the beginning of array (valid position exists)
            // 2) currentValue < arr[prev] : The current element is SMALLER than the element at prev position
            //
            // Think of it: If you have a card "4" and you're comparing with "6", "5"
            // You keep moving left until you find a card smaller than 4
            while(prev>=0 && currentValue < arr[prev]) {

                // SHIFT OPERATION: Move the larger element one position to the right
                // This creates space for our current element
                // arr[prev+1] = arr[prev];
                // Example: If we have [5, 6, 4] and we're inserting 4
                //          We move 6 to the right: [5, 6, 6] (4 is not placed yet)
                arr[prev+1] = arr[prev];

                // DECREMENT PREVIOUS: Move the previous pointer one step to the left
                // Now we'll compare with the next element on the left
                // Example: prev was 1 (pointing to 6), now prev = 0 (pointing to 5)
                prev--;
            }

            // INSERT AT CORRECT POSITION: Place our current element in the empty space
            // After the while loop ends, prev+1 is the correct position for currentValue
            //
            // Think of it: After moving elements, we have an empty spot where currentValue should go
            // Example: [5, 6, 6] -> We place 4 at position prev+1 = 1 -> [5, 4, 6] ??? NO WAIT
            // After shifting: [5, 6, ?] and prev moves from 1 to 0
            // We check if 5 > 4, yes! So we shift 5: [5, 5, ?] and prev becomes -1
            // Now prev=-1 is NOT >=0, so while loop stops
            // We place 4 at arr[-1+1] = arr[0] = 4 -> [4, 5, 6]
            arr[prev+1] = currentValue;
        }

        // RETURN THE SORTED ARRAY
        // Although the array is modified in place, we return it for convenience
        return arr;
    }
}
