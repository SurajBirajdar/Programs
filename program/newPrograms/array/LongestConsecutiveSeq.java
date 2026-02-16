// LINE 1: This tells Java where this file belongs in your project
// Think of it like your home address: "programs.program.newPrograms.array"
package programs.program.newPrograms.array;

// LINE 3-4: These are like importing tools from a toolbox
// HashSet = A special container that stores unique items and finds them super fast
// Set = The blueprint/rule book for HashSet
import java.util.HashSet;
import java.util.Set;

// LINE 6: This is the name of our program/class
// Think of it as the title of your recipe book
public class LongestConsecutiveSeq {

    // LINE 7: This is where our program starts running (the entry point)
    // Like pressing the "Start" button on a game
    public static void main(String[] args) {

        // LINE 9: PROBLEM EXPLANATION
        // We have numbers: {100, 34, 3, 2, 1, 0, -1}
        // We want to find the longest sequence of consecutive numbers
        // Example: -1, 0, 1, 2, 3 are consecutive (each number is 1 more than previous)
        // The number 100 and 34 are alone (no neighbors)

        // LINE 9: Create an array (list) of numbers
        // arr = array = a container that holds multiple numbers in order
        // Think of it like a train with 7 compartments, each holding one number
        int[] arr = {100, 34, 3, 2, 1, 0, -1};

        // LINE 10: Create a HashSet (a magical bag that holds unique items)
        // Why HashSet? Because it can check "Does this number exist?" in lightning speed!
        // Example: Checking if 3 exists takes same time as checking if 100 exists
        Set<Integer> set = new HashSet<>();

        // LINE 12-14: Pour all numbers from our array into the HashSet
        // for(int num : arr) means "for each number in the array"
        // Like taking each toy from a box and putting it in a special bag
        // After this: set = {-1, 0, 1, 2, 3, 34, 100} (unordered, but all unique)
        for(int num : arr) {
            set.add(num);  // add means "put this number in the set"
        }

        // LINE 16: Create a variable to remember the longest sequence length
        // Initially it's 0 because we haven't found any sequence yet
        // Think: "What's the longest chain of numbers I've found?" Answer: 0 (nothing yet)
        int longest = 0;

        // LINE 17: Create a variable to remember where the longest sequence starts
        // Example: If longest sequence is 1,2,3,4,5 then longestStart = 1
        int longestStart = 0;

        // LINE 19: Loop through each number in our set
        // We'll check each number to see if it starts a sequence
        // Example: Check -1, then 0, then 1, then 2, etc.
        for(int num : set) {

            // LINE 21: THIS IS THE CLEVER PART! 🧠
            // We only want to start counting if this number is the BEGINNING of a sequence
            // How do we know it's the beginning? If (num - 1) doesn't exist!
            // Example: For number 3, we check: Does 2 exist? YES! So 3 is NOT the start
            // Example: For number -1, we check: Does -2 exist? NO! So -1 IS the start!
            // !set.contains(num - 1) means "Does the set NOT contain (num - 1)?"
            if(!set.contains(num - 1)) {

                // LINE 22: Store the current number we're checking
                // We'll increase this as we find consecutive numbers
                // Example: If num = -1, then currentNum = -1
                int currentNum = num;

                // LINE 23: Start counting! We found at least 1 number (the current one)
                // Example: We found -1, so count = 1
                int count = 1;

                // LINE 26-29: Keep looking for the next consecutive number
                // while loop means "keep doing this as long as condition is true"
                // Example: Starting at -1:
                //   - Does 0 exist (-1+1)? YES! Move to 0, count = 2
                //   - Does 1 exist (0+1)? YES! Move to 1, count = 3
                //   - Does 2 exist (1+1)? YES! Move to 2, count = 4
                //   - Does 3 exist (2+1)? YES! Move to 3, count = 5
                //   - Does 4 exist (3+1)? NO! Stop here. Final count = 5
                while(set.contains(currentNum + 1)) {
                    currentNum++;  // Move to next number (currentNum = currentNum + 1)
                    count++;       // Increase our count (count = count + 1)
                }

                // LINE 32-35: Check if this sequence is the longest we've found so far
                // Example: We found sequence -1,0,1,2,3 with length 5
                // If previous longest was 3, then 5 > 3, so update!
                if(count > longest) {
                    longest = count;        // Remember this is the longest (5)
                    longestStart = num;     // Remember it starts at -1
                }
            }
        }

        // LINE 39-42: Print the results to the screen!
        // System.out.print = Show text on screen (stays on same line)
        // System.out.println = Show text and move to next line
        System.out.print("Longest consecutive sequence: ");

        // LINE 41-43: Print each number in the longest sequence
        // Example: If longestStart = -1 and longest = 5
        // Loop runs 5 times: i=0,1,2,3,4
        // Print: (-1+0)=-1, (-1+1)=0, (-1+2)=1, (-1+3)=2, (-1+4)=3
        // Output: -1 0 1 2 3
        for(int i = 0; i < longest; i++) {
            System.out.print((longestStart + i) + " ");
        }

        // LINE 45: Move to next line (like pressing Enter)
        System.out.println();

        // LINE 46: Print the length of the longest sequence
        // Example: "Length: 5"
        System.out.println("Length: " + longest);
    }
}

/*
 * ====== FULL EXAMPLE WALKTHROUGH ======
 *
 * Input: {100, 34, 3, 2, 1, 0, -1}
 *
 * Step 1: Put all numbers in HashSet: {-1, 0, 1, 2, 3, 34, 100}
 *
 * Step 2: Check each number:
 *   - 100: Does 99 exist? NO! So start counting from 100
 *          Does 101 exist? NO! Sequence length = 1
 *
 *   - 34: Does 33 exist? NO! So start counting from 34
 *         Does 35 exist? NO! Sequence length = 1
 *
 *   - 3: Does 2 exist? YES! So skip (not the start of sequence)
 *
 *   - 2: Does 1 exist? YES! So skip (not the start of sequence)
 *
 *   - 1: Does 0 exist? YES! So skip (not the start of sequence)
 *
 *   - 0: Does -1 exist? YES! So skip (not the start of sequence)
 *
 *   - -1: Does -2 exist? NO! So start counting from -1
 *         Does 0 exist (-1+1)? YES! count=2, move to 0
 *         Does 1 exist (0+1)? YES! count=3, move to 1
 *         Does 2 exist (1+1)? YES! count=4, move to 2
 *         Does 3 exist (2+1)? YES! count=5, move to 3
 *         Does 4 exist (3+1)? NO! Stop. Sequence length = 5 ✓
 *
 * Step 3: Longest sequence starts at -1 with length 5
 *
 * Output:
 * Longest consecutive sequence: -1 0 1 2 3
 * Length: 5
 */

