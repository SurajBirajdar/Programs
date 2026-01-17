package programs.program.arrayPrograms;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        // This program finds the subarray (a portion of the array) with the maximum sum
        // Example: In {-2, 1, -3, 4, -1, 2, 1}, the subarray {4, -1, 2, 1} has the maximum sum of 6
        // This uses an algorithm called "Kadane's Algorithm"

        // Step 1: Create an array of numbers (some positive, some negative)
        int[] arr = {-2, 1, -3, 4, -1, 2, 1};

        // Step 2: Initialize variables to track important values
        // maxSum: stores the largest sum we've found so far (start with the smallest possible number)
        int maxSum = Integer.MIN_VALUE;

        // currentSum: keeps track of the running sum as we add elements one by one
        int currentSum = 0;

        // start: stores the starting position of the subarray with maximum sum
        int start = 0;

        // end: stores the ending position of the subarray with maximum sum
        int end = 0;

        // tempStart: temporary starting position that we might use for a new subarray
        int tempStart = 0;

        // Step 3: Loop through each element in the array one by one
        for(int i=0; i<arr.length; i++) {

            // Step 4: Add the current element to our running sum
            currentSum = currentSum + arr[i];

            // Step 5: Check if the current sum is greater than the maximum sum we've seen before
            if(currentSum > maxSum) {
                // If yes, update maxSum with this new larger value
                maxSum = currentSum;

                // Remember where this best subarray started
                start = tempStart;

                // Remember where this best subarray ends (which is the current position)
                end = i;
            }

            // Step 6: Check if the current sum became negative
            if(currentSum < 0) {
                // If the sum is negative, it's better to start fresh
                // Reset currentSum to 0 (start counting from the next element)
                currentSum = 0;

                // Mark the next position as a potential starting point for a new subarray
                tempStart = i + 1;
            }
        }

        // Step 7: Print the maximum sum we found
        System.out.println(maxSum);

        // Step 8: Print the actual subarray that gave us the maximum sum
        // Loop from the start position to the end position
        for (int i = start; i <= end; i++) {
            // Print each element in the maximum sum subarray
            System.out.print(arr[i] + " ");
        }
    }
}
