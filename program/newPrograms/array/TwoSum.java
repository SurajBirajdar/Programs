// This line tells Java where this file belongs in the project folder structure
package programs.program.newPrograms.array;

// This line imports the HashMap tool from Java's library so we can use it
import java.util.HashMap;

// This is the start of our class named "TwoSum" - think of it as a container for our code
public class TwoSum {

    // This is the main method - the starting point where our program begins to run
    public static void main(String[] args) {

        // Two Sum Problem: Find two numbers in an array that add up to a target number

        // Create an array (a list) of 5 numbers: 56, 3, 7, 11, and 2
        int[] arr = {56, 3, 7, 11, 2};

        // Call the twoSum method to find two numbers that add up to 10
        // Store the result (which will be the positions of those two numbers) in a variable called "result"
        int[] result = twoSum(arr, 10);

        // Print the positions (indices) of the two numbers that add up to 10
        // result[0] is the first position, result[1] is the second position
        System.out.println(result[0] + ", " + result[1]);
    }


    // This method finds two numbers in an array that add up to the target
    // It takes two inputs: an array of numbers (arr) and a target number (target)
    // It returns an array containing the positions of the two numbers
    public static int[] twoSum(int[] arr, int target) {

        // Create a HashMap - think of it as a smart notebook that stores pairs of values
        // Key: the number from array, Value: the position (index) of that number
        HashMap<Integer, Integer> map = new HashMap<>();

        // Start a loop that goes through each number in the array
        // i starts at 0 (first position) and increases by 1 each time until we reach the end
        for(int i = 0; i < arr.length; i++) {

            // Calculate the complement - the number we need to add to arr[i] to get the target
            // Example: if target is 10 and arr[i] is 3, then complement is 10 - 3 = 7
            int complement = target - arr[i];

            // Check if we have already seen the complement number in our HashMap
            if(map.containsKey(complement)) {

                // Success! We found the two numbers!
                // Return their positions: map.get(complement) gives us the position of the complement
                // i is the current position
                return new int[] {map.get(complement), i};

            } else {

                // We haven't found the pair yet
                // Store the current number and its position in the HashMap for future reference
                // Key: arr[i] (the number), Value: i (its position)
                map.put(arr[i], i);
            }
        }

        // If we finish the loop without finding a pair, return {-1, -1}
        // This means no two numbers in the array add up to the target
        return new int[] {-1, -1};
    }
}
