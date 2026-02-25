// This tells Java where to find this program in the folder structure
// Like saying: "This class is in programs → program → newPrograms → array"
package programs.program.newPrograms.array;

// This is the name of our program/class. Think of it like naming a box.
// public = anyone can use it
// class = a blueprint for creating objects
public class PlusOne {

    // This is the main method - the starting point of our program
    // It's like the first line of a recipe that Java reads when program starts
    // String[] args = way to pass information to the program
    public static void main(String[] args) {
        // EXAMPLE: We have a number 999 stored as [9, 9, 9] in an array
        // Our goal: Add 1 to this number to get 1000, which is [1, 0, 0, 0]
        // int[] arr = This creates an array (list) of integers
        int[] arr = {9,9,9};

        // Call the plusOne function and store the answer in 'result'
        // Example: plusOne([9,9,9]) gives us [1,0,0,0]
        int[] result = plusOne(arr);

        // This is a loop: Print each number in the result array
        // for(int i=0; i<result.length; i++)
        //   i starts at 0, goes until it reaches result.length
        //   Each time: print one number and a space
        // Example output: "1 0 0 0 "
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    // This is our main function that adds 1 to a number
    // Input: int[] arr = an array of single digits (like [9,9,9])
    // Output: int[] = the result array with 1 added
    // Think: If I have 999, I need to get 1000
    public static int[] plusOne(int[] arr) {
        // START FROM THE RIGHT (last digit, like ones place in 999)
        // int i = arr.length-1 means start at the last position
        // Example: if arr = [9,9,9], arr.length = 3, so i starts at 2 (the last 9)
        // i>=0 means keep going until we reach the beginning
        // i-- means go backwards (2, then 1, then 0)
        for(int i=arr.length-1; i>=0; i--) {
            // CHECK: Is the current digit NOT equal to 9?
            // Example: Is arr[2] (which is 9) not equal to 9? NO, it is 9
            // So we skip this if and go to the else
            if(arr[i] != 9) {
                // If digit is NOT 9, just add 1 and we're done!
                // Example: If we had [9,8,5], at position 2 we'd do 5+1 = 6
                arr[i]++;
                // BREAK = stop the loop, we're finished!
                // We don't need to check other digits
                break;
            } else {
                // If digit IS 9, we need to change it to 0 and CARRY over to next digit
                // Like in math: 9 + 1 = 10, so write 0 and carry 1
                // Example: [9,9,9] → first check: 9 becomes 0 → [9,9,0]
                //                   second check: 9 becomes 0 → [9,0,0]
                //                   third check: 9 becomes 0 → [0,0,0]
                arr[i] = 0;
            }
        }

        // AFTER the loop, check if the FIRST digit (arr[0]) is 0
        // This happens when ALL digits were 9
        // Example: [9,9,9] all become [0,0,0], so we know we need an extra digit
        if(arr[0] == 0) {
            // Create a NEW array that is 1 size bigger
            // arr.length + 1 means if original was 3, new is 4
            // Example: [9,9,9] needs to become [1,0,0,0] which has 4 digits
            int[] newArr = new int[arr.length + 1];

            // Put 1 at the very beginning (position 0) of the new array
            // This is like writing the "carry" digit
            // Example: newArr[0] = 1 → [1,0,0,0]
            newArr[0] = 1;

            // Return (give back) the new array with the extra digit
            // The old array [0,0,0] is forgotten, we give back [1,0,0,0]
            return newArr;
        }

        // If we didn't need an extra digit, just return the modified original array
        // Example: [1,2,8] after adding 1 becomes [1,2,9], return that
        return arr;
    }
}
