// COUNTING BITS - Interview Explanation
// This program counts the number of 1s in the binary representation of numbers 0 to N
// Example: For number=4, we need to find count of 1s in binary of 0,1,2,3,4
// 0 = 0000 -> 0 ones
// 1 = 0001 -> 1 one
// 2 = 0010 -> 1 one
// 3 = 0011 -> 2 ones
// 4 = 0100 -> 1 one
// Output: [0, 1, 1, 2, 1]

package programs.program.bitManipulation;

import java.util.Arrays; // Import Arrays class to print array nicely

public class CountingBits {

    // Main method - entry point of the program
    public static void main(String[] args) {
        // Example: We want to count bits from 0 to 4
        // Think of it like: "How many 1s are in the binary of each number?"
        int number = 4;

        // Call the method that counts bits for all numbers from 0 to 4
        // This will give us an array with answers
        int[] result = countingBits(number);

        // Print the result array nicely
        // Output will be: [0, 1, 1, 2, 1]
        System.out.println(Arrays.toString(result));
    }

    // Method to count number of 1 bits (set bits) in binary representation
    // Input: number = 4
    // Output: [0, 1, 1, 2, 1] (count of 1s in binary of 0, 1, 2, 3, 4)
    public static int[] countingBits(int number) {

        // Create an array of size (number+1) to store results
        // If number=4, we need indices 0,1,2,3,4 so array size = 5
        // Example: new int[5] creates [0, 0, 0, 0, 0]
        int[] result = new int[number+1];

        // Base case: 0 has no 1s in binary (0000...0)
        // Set result[0] = 0
        // This is our starting point, we know this is always true
        result[0] = 0;

        // Loop from 1 to number (inclusive)
        // For each position, we calculate how many 1s are in that number
        // Example: i will be 1, 2, 3, 4 (when number=4)
        for(int i=1; i<number+1; i++) {

            // Check if the number is ODD (like 1, 3, 5, 7...)
            // If i%2 != 0, it means i is ODD
            // Example: 3%2 = 1 (not 0), so 3 is odd
            // Why check odd? Because odd numbers have last bit as 1 in binary
            // 1 = 0001 (last bit is 1)
            // 3 = 0011 (last bit is 1)
            // 5 = 0101 (last bit is 1)
            if(i%2 !=0) {

                // For odd numbers:
                // Number of 1s = Number of 1s in (i/2) + 1
                // Why? Because odd number = even number with one extra 1 at the end
                // Example: 3 = 0011, 3/2 = 1 (integer division)
                // Binary of 1 = 0001 (has 1 one)
                // Binary of 3 = 0011 (has 2 ones)
                // So result[3] = result[1] + 1 = 1 + 1 = 2 ✓

                // Another example: 5 = 0101, 5/2 = 2
                // Binary of 2 = 0010 (has 1 one)
                // Binary of 5 = 0101 (has 2 ones)
                // So result[5] = result[2] + 1 = 1 + 1 = 2 ✓
                result[i] = result[i/2] + 1;

            } else {

                // For even numbers:
                // Number of 1s = Number of 1s in (i/2)
                // Why? Because even number = odd number shifted left by 1
                // The last bit is always 0 for even numbers
                // Shifting doesn't change count of 1s, just position
                // Example: 2 = 0010, 2/2 = 1
                // Binary of 1 = 0001 (has 1 one)
                // Binary of 2 = 0010 (has 1 one)
                // So result[2] = result[1] = 1 ✓

                // Another example: 4 = 0100, 4/2 = 2
                // Binary of 2 = 0010 (has 1 one)
                // Binary of 4 = 0100 (has 1 one)
                // So result[4] = result[2] = 1 ✓
                result[i] = result[i/2];
            }
        }

        // Return the complete array with count of 1s for each number
        // For input 4, returns [0, 1, 1, 2, 1]
        return result;
    }
}
