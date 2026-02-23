package programs.program.newPrograms.array;

/*
 * PROBLEM STATEMENT (In Simple Terms):
 * ------------------------------------
 * Imagine you have a row of numbers and a sliding window of fixed size.
 * You need to slide this window across the array and find which position
 * gives you the MAXIMUM sum of numbers inside that window.
 *
 * EXAMPLE: Array = {2, 1, 5, 1, 3, 2}, Window Size (k) = 3
 *
 * Window 1: [2, 1, 5] → Sum = 8
 * Window 2: [1, 5, 1] → Sum = 7
 * Window 3: [5, 1, 3] → Sum = 9 ← This is the MAXIMUM!
 * Window 4: [1, 3, 2] → Sum = 6
 *
 * Answer: Maximum sum = 9, Subarray = [5, 1, 3]
 */

public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {

        // ============================================================
        // STEP 0: DEFINE THE INPUT DATA
        // ============================================================

        // This is our array of numbers - think of it as a row of boxes
        // Each box contains a number: 2, 1, 5, 1, 3, 2
        int[] arr = {2, 1, 5, 1, 3, 2};

        // 'k' is the size of our sliding window (how many numbers to look at together)
        // Here k=3 means we look at 3 consecutive numbers at a time
        int k = 3;


        // ============================================================
        // STEP 1: DECLARE VARIABLES TO TRACK IMPORTANT INFORMATION
        // ============================================================

        // 'windowSum' stores the sum of current window we're looking at
        // Initially 0 because we haven't started calculating yet
        int windowSum = 0;

        // 'maxSum' stores the HIGHEST sum we've found so far
        // We'll update this whenever we find a bigger sum
        int maxSum = 0;

        // 'startIndex' remembers WHERE (which position) the best window starts
        // This helps us print the actual numbers later
        int startIndex = 0;


        // ============================================================
        // STEP 2: CALCULATE THE SUM OF THE FIRST WINDOW
        // ============================================================
        // Why? We need a starting point. We calculate the sum of first 'k' elements
        // For our example: first window = arr[0] + arr[1] + arr[2] = 2 + 1 + 5 = 8

        // Loop from position 0 to position k-1 (first k elements)
        // When i=0: add arr[0] which is 2, windowSum becomes 2
        // When i=1: add arr[1] which is 1, windowSum becomes 3
        // When i=2: add arr[2] which is 5, windowSum becomes 8
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];  // Add current element to windowSum
        }

        // Now windowSum = 8 (sum of first window: 2+1+5)
        // Since this is our first window, it's also our maximum so far
        maxSum = windowSum;

        // The first window starts at position 0 (beginning of array)
        startIndex = 0;


        // ============================================================
        // STEP 3: SLIDE THE WINDOW AND CHECK OTHER WINDOWS
        // ============================================================
        // Now we move our window ONE step at a time to the right
        // Instead of recalculating everything, we use a SMART TRICK:
        // - Remove the leftmost number that goes OUT of the window
        // - Add the new rightmost number that comes INTO the window

        // Loop starts from position k (4th element) to end of array
        // Each iteration represents sliding the window one position right
        for (int i = k; i < arr.length; i++) {

            // SLIDING WINDOW FORMULA (The Smart Trick):
            // -------------------------------------------
            // New Sum = Old Sum - (element going OUT) + (element coming IN)
            //
            // 'arr[i - k]' is the element LEAVING the window (leftmost element)
            // 'arr[i]' is the element ENTERING the window (new rightmost element)
            //
            // ITERATION 1: i=3
            // - Going out: arr[3-3] = arr[0] = 2 (remove first element)
            // - Coming in: arr[3] = 1 (add 4th element)
            // - windowSum = 8 - 2 + 1 = 7
            // - New window is [1, 5, 1]
            //
            // ITERATION 2: i=4
            // - Going out: arr[4-3] = arr[1] = 1
            // - Coming in: arr[4] = 3
            // - windowSum = 7 - 1 + 3 = 9
            // - New window is [5, 1, 3]
            //
            // ITERATION 3: i=5
            // - Going out: arr[5-3] = arr[2] = 5
            // - Coming in: arr[5] = 2
            // - windowSum = 9 - 5 + 2 = 6
            // - New window is [1, 3, 2]
            windowSum = windowSum - arr[i - k] + arr[i];

            // CHECK: Is this new window sum BETTER than our previous best?
            if (windowSum > maxSum) {

                // YES! We found a bigger sum, so update our maximum
                maxSum = windowSum;

                // Calculate WHERE this best window starts in the array
                // Formula: current position 'i' minus window size 'k' plus 1
                // Example: when i=4 and k=3, startIndex = 4-3+1 = 2
                // This means the window starts at position 2 (which is arr[2]=5)
                startIndex = i - k + 1;
            }
        }


        // ============================================================
        // STEP 4: DISPLAY THE RESULTS
        // ============================================================

        // Print the maximum sum we found
        // For our example: Maximum Sum = 9
        System.out.println("Maximum Sum = " + maxSum);

        // Print the actual numbers that make up this maximum sum
        // We need to print 'k' consecutive numbers starting from 'startIndex'
        System.out.print("Subarray: ");

        // Loop from startIndex to (startIndex + k - 1)
        // For our example: startIndex=2, k=3
        // So we print arr[2], arr[3], arr[4] which is 5, 1, 3
        for (int i = startIndex; i < startIndex + k; i++) {
            System.out.print(arr[i] + " ");  // Print each number with a space
        }

        // OUTPUT will be:
        // Maximum Sum = 9
        // Subarray: 5 1 3
    }
}

/*
 * ============================================================
 * INTERVIEW EXPLANATION (In Layman Terms):
 * ============================================================
 *
 * INTERVIEWER: "Explain this algorithm to me"
 *
 * YOUR ANSWER:
 * "Imagine you have a lineup of people holding numbers, and you have a
 * camera that can only photograph 3 people at a time. You want to find
 * which group of 3 people, standing next to each other, has the highest
 * total when you add their numbers.
 *
 * The NAIVE way would be to add up numbers for every possible group:
 * - Take photo of first 3, add them up
 * - Take photo of next 3, add them up
 * - And so on...
 *
 * But that's wasteful! We can be SMARTER with the Sliding Window technique:
 * - First, we add up the first 3 people
 * - Then, when we move the camera one person right, instead of adding
 *   all 3 again, we simply:
 *   → Remove the person who left the frame (on the left)
 *   → Add the new person who entered the frame (on the right)
 *
 * This way, we only go through the array ONCE (O(n) time complexity)
 * instead of multiple times!"
 *
 * TIME COMPLEXITY: O(n) - We visit each element once
 * SPACE COMPLEXITY: O(1) - We only use a few variables
 *
 * WHERE IS THIS USED IN REAL LIFE?
 * - Stock market: Find the best N-day period to sell stocks
 * - Network monitoring: Find the busiest time window in server logs
 * - Video streaming: Find the buffer window with most data
 */
