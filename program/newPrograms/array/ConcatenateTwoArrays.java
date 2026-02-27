// This tells Java where this program lives in the folder structure
// Like saying: "This class lives in programs → program → newPrograms → array"
package programs.program.newPrograms.array;

// This is the name of our program. Think of it like labeling a box.
// public = anyone can use it
// class = a blueprint for Java objects
public class ConcatenateTwoArrays {

    // This is the main method - the starting point when we run the program
    // It's like pressing the START button on a video game
    // String[] args = way to pass information to the program
    public static void main(String[] args) {

        // GOAL: Combine two separate arrays into ONE big array
        // EXAMPLE: We have two baskets of fruits
        // Basket 1: [5, 3, 2]  (3 items)
        // Basket 2: [9, 0, 1]  (3 items)
        // Final result: [5, 3, 2, 9, 0, 1] (6 items all together)

        // STEP 1: Create the FIRST array with 3 numbers
        // int[] arr1 = This creates an array of integers (whole numbers)
        // {5,3,2} = put these 3 numbers into the array at positions 0, 1, 2
        // Position 0 = 5
        // Position 1 = 3
        // Position 2 = 2
        int[] arr1 = {5,3,2};

        // STEP 2: Create the SECOND array with 3 numbers
        // int[] arr2 = Another array of integers
        // {9,0,1} = put these 3 numbers into the array at positions 0, 1, 2
        // Position 0 = 9
        // Position 1 = 0
        // Position 2 = 1
        int[] arr2 = {9,0,1};

        // STEP 3: Calculate how big the final array should be
        // arr1.length = How many items in arr1? Answer: 3
        // arr2.length = How many items in arr2? Answer: 3
        // arr1.length + arr2.length = 3 + 3 = 6
        // So our final array will have 6 spots
        // int length = This creates a variable to store this number (6)
        int length = arr1.length + arr2.length;

        // STEP 4: Create the EMPTY result array with 6 empty spots
        // int[] result = Create a new array
        // new int[length] = Make it with 6 empty spots (all starting as 0)
        // Result array: [0, 0, 0, 0, 0, 0]
        // Positions:    [0, 1, 2, 3, 4, 5]
        int[] result = new int[length];

        // ============================================================================
        // STEP 5: COPY ALL ITEMS FROM arr1 INTO THE RESULT ARRAY
        // ============================================================================

        // for(int i=0; i<arr1.length; i++)
        // This means: Create a counter called 'i' that starts at 0
        //            Keep going while i is less than 3
        //            After each round, increase i by 1 (i++)
        // Rounds: i=0, i=1, i=2 (then stop because i=3 is not less than 3)
        for(int i=0; i<arr1.length; i++) {

            // result[i] = arr1[i]
            // This means: "Copy the number from arr1 at position i into result at position i"
            //
            // ROUND 1: i=0
            //   arr1[0] = 5
            //   result[0] = 5
            //   Result array now: [5, 0, 0, 0, 0, 0]
            //
            // ROUND 2: i=1
            //   arr1[1] = 3
            //   result[1] = 3
            //   Result array now: [5, 3, 0, 0, 0, 0]
            //
            // ROUND 3: i=2
            //   arr1[2] = 2
            //   result[2] = 2
            //   Result array now: [5, 3, 2, 0, 0, 0]
            result[i] = arr1[i];
        }
        // After this loop, the first 3 spots are filled with arr1's numbers

        // ============================================================================
        // STEP 6: COPY ALL ITEMS FROM arr2 INTO THE RESULT ARRAY
        // ============================================================================

        // for(int i=0; i<arr2.length; i++)
        // This means: Create a counter called 'i' that starts at 0
        //            Keep going while i is less than 3
        //            After each round, increase i by 1 (i++)
        // Rounds: i=0, i=1, i=2 (then stop because i=3 is not less than 3)
        for(int i=0; i<arr2.length; i++) {

            // result[arr1.length + i] = arr2[i]
            // This is TRICKY! Let me break it down:
            // arr1.length = 3 (how many items in arr1)
            // i = current counter (0, 1, or 2)
            // arr1.length + i = where to put items from arr2
            //
            // ROUND 1: i=0
            //   arr1.length + i = 3 + 0 = 3
            //   arr2[0] = 9
            //   result[3] = 9  (put arr2's first item at position 3)
            //   Result array now: [5, 3, 2, 9, 0, 0]
            //
            // ROUND 2: i=1
            //   arr1.length + i = 3 + 1 = 4
            //   arr2[1] = 0
            //   result[4] = 0  (put arr2's second item at position 4)
            //   Result array now: [5, 3, 2, 9, 0, 0]
            //
            // ROUND 3: i=2
            //   arr1.length + i = 3 + 2 = 5
            //   arr2[2] = 1
            //   result[5] = 1  (put arr2's third item at position 5)
            //   Result array now: [5, 3, 2, 9, 0, 1]
            result[arr1.length + i] = arr2[i];
        }
        // After this loop, all 6 spots are filled!

        // ============================================================================
        // STEP 7: PRINT THE FINAL RESULT
        // ============================================================================

        // for(int i=0; i<result.length; i++)
        // This means: Create a counter called 'i' that starts at 0
        //            Keep going while i is less than 6
        //            After each round, increase i by 1 (i++)
        // Rounds: i=0, i=1, i=2, i=3, i=4, i=5 (then stop)
        for(int i=0; i<result.length; i++) {

            // System.out.print(result[i] + " ")
            // This means: "Print the number at position i, followed by a space"
            // DON'T use println() because we want them on ONE line with spaces between
            //
            // ROUND 1: i=0 → Print "5 "
            // ROUND 2: i=1 → Print "3 "
            // ROUND 3: i=2 → Print "2 "
            // ROUND 4: i=3 → Print "9 "
            // ROUND 5: i=4 → Print "0 "
            // ROUND 6: i=5 → Print "1 "
            //
            // FINAL OUTPUT: 5 3 2 9 0 1
            System.out.print(result[i] + " ");
        }
    }
}
