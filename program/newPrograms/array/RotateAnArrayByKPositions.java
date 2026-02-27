package programs.program.newPrograms.array;

/**
 * ==========================================
 * ARRAY ROTATION PROBLEM - SIMPLE EXPLANATION
 * ==========================================
 *
 * WHAT IS ARRAY ROTATION?
 * Think of it like rotating a carousel:
 * Original array:  [1, 2, 3, 4, 5]
 * Rotate by 1:     [2, 3, 4, 5, 1]   (moved left by 1)
 * Rotate by 2:     [3, 4, 5, 1, 2]   (moved left by 2)
 *
 * Negative rotation means CLOCKWISE (right shift):
 * Original array:  [1, 2, 3, 4, 5]
 * Rotate by -1:    [5, 1, 2, 3, 4]   (moved right by 1)
 * Rotate by -2:    [4, 5, 1, 2, 3]   (moved right by 2)
 *
 * APPROACH: REVERSE ALGORITHM
 * We use 3 reverse operations to rotate without extra space:
 * Step 1: Reverse first k elements
 * Step 2: Reverse remaining elements
 * Step 3: Reverse entire array
 */

public class RotateAnArrayByKPositions {

    // ==========================================
    // MAIN METHOD - Entry point of the program
    // ==========================================
    public static void main(String[] args) {
        // Create an array with 5 numbers: [1, 2, 3, 4, 5]
        // Example: Think of a list: Apple(1), Banana(2), Cherry(3), Date(4), Elderberry(5)
        int[] arr = {1, 2, 3, 4, 5};

        // Call rotate method with k = -2 (rotate right by 2 positions)
        // After rotation, array becomes: [4, 5, 1, 2, 3]
        // Like shifting the list right: Last 2 items go to front
        rotate(arr, -2);

        // Print each element of the rotated array
        // Loop from i=0 to i=4 (length of array is 5)
        // i++ means increment i by 1 in each iteration
        // Example: First iteration prints arr[0]=4, Second prints arr[1]=5, etc.
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");  // Prints: 4 5 1 2 3
        }
    }

    /**
     * ==========================================
     * ROTATE METHOD - Core logic for rotation
     * ==========================================
     *
     * HOW IT WORKS:
     * For array [1,2,3,4,5] with k=-2 (rotate right by 2):
     *
     * Step 0 - Handle negative k:
     *   k = -2 % 5 = -2
     *   Since k < 0, k = -2 + 5 = 3
     *   (Rotating right by 2 is same as rotating left by 3)
     *
     * Step 1 - Reverse first 3 elements [1,2,3]:
     *   Result: [3, 2, 1, 4, 5]
     *
     * Step 2 - Reverse remaining elements [4,5]:
     *   Result: [3, 2, 1, 5, 4]
     *
     * Step 3 - Reverse entire array:
     *   Result: [4, 5, 1, 2, 3] ✓ DONE!
     */
    public static void rotate(int[] arr, int k) {

        // Step 0: Normalize k using modulo operation
        // k = k % arr.length;
        // WHY? If array has 5 elements, rotating by 5 is same as rotating by 0
        // Example: [1,2,3,4,5] with k=7 is same as k=2 (7%5=2)
        // Analogy: If you have 5 people in a circle and rotate 7 times,
        // it's same as rotating 2 times (5+2=7)
        k = k % arr.length;

        // Step 1: Handle negative k (clockwise/right rotation)
        // if(k<0) means "if k is negative"
        // Example: If k = -2
        if(k < 0) {
            // k = k + arr.length;
            // This converts negative rotation to positive rotation
            // WHY? Right rotation by 2 = Left rotation by 3 (in array of size 5)
            // Formula: Right(2) = Left(5-2) = Left(3)
            // Example: Rotating [1,2,3,4,5] right by 2 = [4,5,1,2,3]
            //          Rotating [1,2,3,4,5] left by 3 = [4,5,1,2,3] (SAME!)
            k = k + arr.length;
        }

        // Step 2: Reverse first k elements
        // This reverses the first part that will move to the end
        // For array [1,2,3,4,5] with k=3:
        // reverse(arr, 0, 2) → Reverses [1,2,3] → [3,2,1,4,5]
        reverse(arr, 0, k - 1);

        // Step 3: Reverse remaining elements
        // This reverses the second part that will stay at beginning
        // For array [3,2,1,4,5] with k=3:
        // reverse(arr, 3, 4) → Reverses [4,5] → [3,2,1,5,4]
        reverse(arr, k, arr.length - 1);

        // Step 4: Reverse entire array
        // Reversing the whole array gives us final rotated result
        // [3,2,1,5,4] reversed → [4,5,1,2,3] ✓
        // This is the magic step that completes the rotation!
        reverse(arr, 0, arr.length - 1);
    }

    /**
     * ==========================================
     * REVERSE METHOD - Helper function
     * ==========================================
     *
     * PURPOSE: Reverses elements from index 'start' to index 'end'
     *
     * HOW IT WORKS (Example: reverse [1,2,3,4,5] from index 0 to 2):
     * Initial:     [1, 2, 3, 4, 5]
     * After swap:  [3, 2, 1, 4, 5]
     *
     * ANALOGY: Like swapping candies on a table:
     * [Candy1, Candy2, Candy3, Candy4, Candy5]
     * Swap Candy1 with Candy3 → [Candy3, Candy2, Candy1, Candy4, Candy5]
     */
    public static void reverse(int[] arr, int start, int end) {

        // while(start<end) means "keep repeating as long as start is less than end"
        // EXAMPLE: If start=0 and end=2, loop runs because 0<2
        //          When start=1 and end=1, loop stops because 1 is not < 1
        // This ensures we only swap pairs needed to reverse the array
        while(start < end) {

            // int temp = arr[start];
            // Save the element at 'start' position in a temporary variable
            // WHY? We need to save it before overwriting it
            // ANALOGY: Before switching hats with someone, hold your hat in hand
            // Example: arr[0]=1, so temp=1
            int temp = arr[start];

            // arr[start] = arr[end];
            // Put the element from 'end' position at 'start' position
            // ANALOGY: Put the hat from the end person to the start person
            // Example: arr[0] = arr[2] → arr[0] becomes 3
            arr[start] = arr[end];

            // arr[end] = temp;
            // Put the saved element (temp) at 'end' position
            // ANALOGY: Put your original hat on the end person
            // Example: arr[2] = temp → arr[2] becomes 1 (which was arr[0])
            arr[end] = temp;

            // start++;
            // Move 'start' one position forward (towards end)
            // ANALOGY: Move to the next pair of people to swap hats
            // Example: start goes from 0 to 1
            start++;

            // end--;
            // Move 'end' one position backward (towards start)
            // ANALOGY: Also move from the other side towards middle
            // Example: end goes from 2 to 1
            // When start=1 and end=1, they meet and loop stops
            end--;
        }
    }
}
