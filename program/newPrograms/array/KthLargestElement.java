package programs.program.newPrograms.array;

/**
 * This class finds the Kth largest element in an array
 * Example: In array [10, 56, 12, 78, 11, 5], the 1st largest is 78, 2nd largest is 56, 3rd largest is 12, 4th largest is 11
 */
public class KthLargestElement {

    /**
     * Main method - This is the starting point of the program
     * Think of it like the door that you enter to run the program
     * When you click RUN, this main method automatically executes
     */
    public static void main(String[] args) {
        // find kth largest element
        // Creating an array of integers (think of it as a box with 6 compartments)
        // Array: [10, 56, 12, 78, 11, 5]
        // Index:  0   1   2   3   4   5
        int[] arr = {10, 56, 12, 78, 11, 5};

        // Calling the kthLargestElement method with array and k=4
        // This means: Find the 4th largest element
        // Expected output: 11 (because 78>56>12>11)
        System.out.println(kthLargestElement(arr,4));
    }

    /**
     * Method to find the Kth largest element in an array
     *
     * @param arr - The array of numbers we want to search in
     *              Example: [10, 56, 12, 78, 11, 5]
     * @param k   - Position of the largest element we want
     *              Example: k=1 means 1st largest, k=2 means 2nd largest
     * @return    - The kth largest element, or -1 if not found
     *
     * HOW IT WORKS (Simple Explanation):
     * Imagine you have 6 students: 10, 56, 12, 78, 11, 5
     * You want to arrange them from tallest to shortest and pick the 4th one
     * Method: Keep comparing each student with others and swap if needed
     */
    public static int kthLargestElement(int[] arr, int k) {

        // OUTER LOOP: i acts as the cursor position, starting from position 0 (leftmost)
        // Example: i=0 means we're looking at the 1st element (10)
        //          i=1 means we're looking at the 2nd element (56)
        //          We keep moving right until i reaches the kth position
        // Condition: i<arr.length means continue while i is less than array size (6)
        for(int i=0; i<arr.length; i++) {

            // INNER LOOP: j looks for a larger element to the right of i
            // Example: When i=0 (looking at 10), j starts from i+1=1
            //          j will be 1, 2, 3, 4, 5 (checking 56, 12, 78, 11, 5)
            // This loop compares the element at position i with all elements to its right
            for(int j=i+1; j<arr.length; j++) {

                // IF CONDITION: Check if element at position i is SMALLER than element at position j
                // Example: Is 10 < 56? YES, so swap them!
                //          This ensures larger elements move towards the left
                if(arr[i] < arr[j]) {
                    // SWAP LOGIC (like exchanging positions with a friend):

                    // Step 1: Create a temporary container to hold the smaller value
                    // Example: temp = 10 (we're saving the value 10 so we don't lose it)
                    int temp = arr[i];

                    // Step 2: Move the larger value to the left position
                    // Example: arr[0] = 56 (now position 0 has 56 instead of 10)
                    arr[i] = arr[j];

                    // Step 3: Move the smaller value (saved in temp) to the right position
                    // Example: arr[1] = 10 (now position 1 has 10)
                    arr[j] = temp;

                    // After swap: [56, 10, 12, 78, 11, 5] - larger value moved left
                }
            }

            // EARLY EXIT: Once we've sorted up to the kth position, we can return the answer
            // Example: If k=4, we want the element at index 3 (because index starts from 0)
            //          So we check: Is i == 4-1? That means i == 3
            //          When i reaches 3, the 4th largest element is at position 3
            // Analogy: If you're looking for the 4th tallest student, once you've sorted
            //          the top 4 students, you can see the 4th one at index 3
            if(i == k-1) {
                // RETURN: Send back the answer (the kth largest element)
                // Example: When i=3, arr[3] should be the 4th largest element
                return arr[i];
            }
        }

        // DEFAULT RETURN: If k is greater than array length, return -1 (not found)
        // Example: If array has only 6 elements but k=10, there is no 10th largest
        // We return -1 as a signal that the answer doesn't exist
        return -1;
    }
}
