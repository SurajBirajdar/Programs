package programs.program.bitManipulation;

/**
 * WHAT IS THIS PROGRAM?
 * This program counts how many '1's (set bits) are in the binary representation of a number.
 *
 * SIMPLE EXAMPLE:
 * Number 4 in binary is: 100 (only one '1')
 * Number 7 in binary is: 111 (three '1's)
 * Number 5 in binary is: 101 (two '1's)
 *
 * So for number 4, this program will return 1
 */
public class CountNoOfSetBits {

    /**
     * MAIN METHOD - Entry point of the program
     * Think of it like the starting point of your journey
     */
    public static void main(String[] args) {
        // Example: We want to count set bits in number 4
        // Binary of 4 is: 100 (1 one, 2 zeros = 100)
        int number = 4;

        // Call the method and print the result
        // This will print: 1 (because there's only one '1' in binary 100)
        System.out.println(countSetBits(number));
    }

    /**
     * METHOD: countSetBits
     * PURPOSE: Count how many '1's are in the binary representation
     *
     * INTERVIEW EXPLANATION:
     * "This method uses a clever trick. Each time we do (number & (number-1)),
     * it removes the rightmost '1' from the binary. We keep doing this until
     * the number becomes 0. The number of times we do this = number of '1's"
     */
    public static int countSetBits(int number) {
        // Initialize counter to track how many '1's we find
        // count = 0 (starting from 0)
        int count = 0;

        /**
         * WHILE LOOP: Keep repeating until number becomes 0
         * Example: If number = 4 (binary: 100)
         *   - First iteration: number = 100, number != 0, so continue
         *   - Second iteration: after operation, number = 0, so stop
         */
        while(number != 0) {
            /**
             * THE MAGIC LINE: number & (number-1)
             *
             * HOW IT WORKS:
             * Let's say number = 6 (binary: 110)
             * number - 1 = 5 (binary: 101)
             *
             * AND operation (110 & 101):
             *     110
             *   & 101
             *   -----
             *     100  = 4
             *
             * WHAT HAPPENED? The rightmost '1' got removed!
             *
             * ANOTHER EXAMPLE:
             * number = 12 (binary: 1100)
             * number - 1 = 11 (binary: 1011)
             *     1100
             *   & 1011
             *   ------
             *     1000 = 8
             * Again, rightmost '1' removed!
             *
             * WHY DOES THIS WORK?
             * When you subtract 1 from a number:
             * - The rightmost '1' becomes '0'
             * - All '0's to the right of it become '1's
             * When you AND them: only the left part remains (rightmost '1' disappears)
             */
            number = number & (number-1);

            /**
             * INCREMENT COUNTER
             * Add 1 to count because we found one set bit
             * count++ means count = count + 1
             */
            count++;
        }

        /**
         * RETURN THE COUNT
         * Give back the final count of all '1's we found
         * Example: If we went through loop 2 times, return 2
         */
        return count;
    }
}
