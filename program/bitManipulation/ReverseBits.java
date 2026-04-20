package programs.program.bitManipulation;

public class ReverseBits {

        public static void main(String[] args) {

            // This is the number whose bits we want to reverse
            int n = 43261596;

            // Call the function and print the result
            System.out.println(reverseBits(n));
        }

        public static int reverseBits(int n) {

            // This will store our final reversed number
            // Initially all bits are 0 → 00000000000000000000000000000000
            int res = 0;

            // We run loop 32 times because int has 32 bits
            // i = position where we will place the reversed bit
            // Start from leftmost (31) → go till rightmost (0)
            for (int i = 31; i >= 0; i--) {

                // Step 1: Get last bit of n
                // & 1 means "give me only the last bit"
                // Example:
                // n = 5 (101) → n & 1 = 1
                // n = 6 (110) → n & 1 = 0
                int bit = n & 1;

                // Step 2: Place this bit at correct reversed position
                // bit << i → shift this bit to position i
                // Example:
                // bit = 1, i = 31 → 1 goes to leftmost position
                // bit = 1, i = 30 → next position

                // Add it to result
                res = res + (bit << i);

                // Step 3: Remove the last bit from n
                // >> 1 means shift right (divide by 2, ignore remainder)
                // Example:
                // n = 1011 → after >>1 → 0101
                // So next loop will process next bit
                n = n >> 1;
            }

            // After processing all 32 bits, return result
            return res;
        }
    }
