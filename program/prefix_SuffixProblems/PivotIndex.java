package programs.program.prefix_SuffixProblems;

/**
 * PIVOT INDEX PROBLEM EXPLANATION:
 *
 * What is a Pivot Index?
 * A pivot index is a position in an array where the sum of all elements
 * to its LEFT equals the sum of all elements to its RIGHT.
 *
 * Example: {1, 7, 3, 6, 5, 6}
 *          0  1  2  3  4  5
 *
 * At index 3 (value=6):
 *   Left side: 1 + 7 + 3 = 11
 *   Right side: 5 + 6 = 11
 *   ✓ PIVOT FOUND!
 *
 * APPROACH:
 * Step 1: Create a leftSum array to store cumulative sum from start to each index
 * Step 2: Create a rightSum array to store cumulative sum from each index to end
 * Step 3: Compare leftSum and rightSum at each index to find where they are equal
 */
public class PivotIndex {

    // Main method - entry point of the program
    public static void main(String[] args) {
        // Create a sample array to test our pivot index function
        // Array: {1, 7, 3, 6, 5, 6}
        // Index:  0  1  2  3  4  5
        int[] arr = {1,7,3,6,5,6};

        // Call the pivotIndex method and print the result
        // Expected output: 3 (because at index 3, left sum = right sum = 11)
        System.out.println(pivotIndex(arr));
    }

    /**
     * METHOD: pivotIndex
     * PURPOSE: Find the index where sum of left elements equals sum of right elements
     * PARAMETERS: arr - the input array
     * RETURNS: the pivot index, or -1 if no pivot exists
     */
    public static int pivotIndex(int[] arr) {

        // STEP 1: Get the length of the array
        // Example: if arr = {1, 7, 3, 6, 5, 6}, then n = 6
        int n = arr.length;

        // STEP 2: Create leftSum array to store running sum from start to each index
        // Think of it like: "What's the total sum from the beginning up to position i?"
        // Example: leftSum[3] will contain 1+7+3+6 = 17
        int[] leftSum = new int[n];

        // STEP 3: Create rightSum array to store running sum from each index to end
        // Think of it like: "What's the total sum from position i to the end?"
        // Example: rightSum[3] will contain 6+5+6 = 17
        int[] rightSum = new int[n];

        // STEP 4: Initialize leftSum array (from left to right)
        // Start with the first element itself
        // leftSum[0] = arr[0] means "at index 0, we only have the element itself"
        // Example: leftSum[0] = 1
        leftSum[0] = arr[0];

        // STEP 5: Fill the leftSum array from index 1 to n-1
        // For each position, add the current element to the previous cumulative sum
        // Loop explanation:
        //   i=1: leftSum[1] = leftSum[0] + arr[1] = 1 + 7 = 8
        //   i=2: leftSum[2] = leftSum[1] + arr[2] = 8 + 3 = 11
        //   i=3: leftSum[3] = leftSum[2] + arr[3] = 11 + 6 = 17
        //   i=4: leftSum[4] = leftSum[3] + arr[4] = 17 + 5 = 22
        //   i=5: leftSum[5] = leftSum[4] + arr[5] = 22 + 6 = 28
        for(int i=1; i<n; i++) {
            leftSum[i] = leftSum[i-1] + arr[i];
        }

        // STEP 6: Initialize rightSum array (from right to left)
        // Start with the last element itself
        // rightSum[n-1] = arr[n-1] means "at the last index, we only have that element"
        // Example: rightSum[5] = 6
        rightSum[n-1] = arr[n-1];

        // STEP 7: Fill the rightSum array from index n-2 down to 0
        // For each position, add the current element to the next cumulative sum
        // Loop explanation (going backwards):
        //   i=4: rightSum[4] = rightSum[5] + arr[4] = 6 + 5 = 11
        //   i=3: rightSum[3] = rightSum[4] + arr[3] = 11 + 6 = 17
        //   i=2: rightSum[2] = rightSum[3] + arr[2] = 17 + 3 = 20
        //   i=1: rightSum[1] = rightSum[2] + arr[1] = 20 + 7 = 27
        //   i=0: rightSum[0] = rightSum[1] + arr[0] = 27 + 1 = 28
        for(int i = n-2; i>=0; i--) {
            rightSum[i] = rightSum[i+1] + arr[i];
        }

        // STEP 8: Compare leftSum and rightSum to find the pivot index
        // Iterate through each index in the array
        // At each index i:
        //   - leftSum[i] = sum of all elements from 0 to i (INCLUDING index i)
        //   - rightSum[i] = sum of all elements from i to n-1 (INCLUDING index i)
        //
        // IMPORTANT NOTE: In this implementation, both arrays include the element at index i itself
        // So when leftSum[i] == rightSum[i], it means:
        // (sum from 0 to i) == (sum from i to n-1)
        //
        // This happens when the element at i is the "center point" where both sides are equal
        for(int i=0; i<n; i++) {
            // Check if leftSum at index i equals rightSum at index i
            // If yes, we found our pivot index!
            // Example: At i=3, leftSum[3]=17 and rightSum[3]=17, so return 3
            if(leftSum[i] == rightSum[i]) {
                return i;
            }
        }

        // STEP 9: If no pivot index found after checking all positions
        // Return -1 to indicate "no pivot index exists in this array"
        // Example: If we check all indices and none satisfy the condition, return -1
        return -1;
    }
}
