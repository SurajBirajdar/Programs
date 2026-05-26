package programs.program.newPrograms.binarySearch;

/**
 * ============================================================================
 * PAINTERS PARTITION PROBLEM - BINARY SEARCH SOLUTION
 * ============================================================================
 * PROBLEM STATEMENT:
 * Given an array of board lengths and 'k' painters, distribute boards to painters such that:
 * 1. Each painter must paint a contiguous set of boards (cannot skip boards)
 * 2. Each painter must get at least one board
 * 3. The maximum time taken by any painter is MINIMIZED
 *    (Time = sum of lengths of all boards assigned to that painter)
 *
 * REAL WORLD ANALOGY:
 * - Painters need to paint different length boards
 * - Each painter paints boards in sequence (cannot jump between boards)
 * - Want to distribute work fairly so the slowest painter finishes earliest
 * - Painters may work at same speed (each unit length = 1 unit time)
 *
 * EXAMPLE: arr = {5, 10, 30, 20, 15}, k = 3 painters
 * - Total work = 5 + 10 + 30 + 20 + 15 = 80 units
 * - Optimal distribution:
 *   Painter 1: [5, 10] = 15 units
 *   Painter 2: [30] = 30 units
 *   Painter 3: [20, 15] = 35 units
 * - Maximum time = 35 (minimum possible maximum)
 *
 * APPROACH: Binary Search
 * - Search space: minimum time to maximum time possible
 * - Minimum time: Largest single board (at least one painter must do at least this)
 * - Maximum time: Sum of all boards (one painter paints everything)
 * - For each candidate time, check if k painters can finish by that time
 *
 * TIME COMPLEXITY: O(n * log(sum)) where n is array length
 * SPACE COMPLEXITY: O(1) - Only using variables
 * ============================================================================
 */
public class PaintersPartition {

    /**
     * MAIN METHOD - Entry point demonstrating painters partition problem
     */
    public static void main(String[] args) {
        // Array of board lengths to be painted
        // Each element represents the time/effort needed to paint that board
        int[] arr = {5, 10, 30, 20, 15};

        // Number of painters available to distribute the work
        int k = 3; // We have 3 painters

        // Find the minimum possible maximum time required for any painter
        // when distributing boards among k painters
        System.out.println(paintersPartition(arr, 3)); // Output: 30
    }

    /**
     * VALIDATION FUNCTION - Checks if k painters can complete all boards in 'mid' time
     * This answers: "Can we distribute all boards to k painters such that
     * no painter needs more than 'mid' time?"
     *
     * @param arr - Array of board lengths
     * @param k - Number of painters available
     * @param mid - The maximum time limit per painter (candidate answer)
     * @return true if k painters can finish all boards within 'mid' time, false otherwise
     *
     * LOGIC:
     * - Start with painter 1 and assign boards one by one
     * - If adding next board exceeds time limit 'mid', assign to next painter
     * - If we need more painters than available (k), return false
     * - If any single board > mid, it's impossible, return false
     */
    public static boolean isValidAns(int[] arr, int k, int mid) {
        // Initialize painter count to 1 (we start with the first painter)
        int painterCount = 1;

        // Variable to track the total time assigned to current painter
        int boardLength = 0;

        // Iterate through each board to be painted
        for(int i = 0; i < arr.length; i++) {
            // Check if adding current board to current painter exceeds time limit 'mid'
            if(boardLength + arr[i] <= mid) {
                // Current painter can paint this board within time limit
                boardLength = boardLength + arr[i]; // Add this board's time to current painter
            } else {
                // Adding this board would exceed time limit for current painter
                painterCount++; // Assign remaining boards to next painter

                // Check two failure conditions:
                // 1. We need more painters than available (painterCount > k)
                // 2. Any single board takes more time than limit (boardLength > mid) - impossible!
                if(painterCount > k || boardLength > mid) {
                    return false; // Distribution is IMPOSSIBLE with this time limit
                } else {
                    // Start assigning boards to new painter
                    boardLength = 0; // Reset time counter for new painter
                    boardLength = boardLength + arr[i]; // Assign current board to new painter
                }
            }
        }

        // If we successfully assigned all boards without exceeding k painters
        return true; // Distribution is POSSIBLE with this time limit
    }

    /**
     * PAINTERS PARTITION - Main Binary Search Function
     * Finds the minimum possible maximum time any painter must work
     *
     * @param arr - Array of board lengths to be painted
     * @param k - Number of painters available for distribution
     * @return Minimum possible value of maximum time among all painters
     *         (the earliest time the last painter can finish)
     *
     * TIME COMPLEXITY: O(n * log(sum)) where sum is total of all elements
     *   - Binary Search: O(log(sum)) iterations (sum can be very large)
     *   - Each iteration validates with O(n) operation
     *
     * ALGORITHM EXPLANATION:
     * 1. Calculate total work (sum of all board lengths)
     * 2. Binary search from minimum possible (largest board) to maximum (total sum)
     * 3. For each mid value, validate if k painters can finish by that time
     * 4. If YES: try for less time (move left), store as answer
     * 5. If NO: increase time limit (move right)
     */
    public static int paintersPartition(int[] arr, int k) {
        // START point of binary search
        // Minimum possible time is when we try to distribute optimally
        // But we need at least 1 unit of work even for the fastest distribution
        int s = 0;

        // Calculate TOTAL work (sum of all board lengths)
        // This represents: if one painter paints everything alone
        int sum = 0; // Initialize sum to store total painting time needed
        for(int i = 0; i < arr.length; i++) {
            sum = sum + arr[i]; // Add each board's time to total
        }

        // END point of binary search
        // Maximum possible time: all boards assigned to one painter
        int e = sum;

        // Variable to store the final answer (minimum possible maximum time)
        int ans = 0;

        // BINARY SEARCH LOOP: Continue while start <= end
        while(s <= e) {
            // Calculate mid value using the formula: s + (e-s)/2
            // This avoids integer overflow compared to (s+e)/2
            // mid represents a candidate answer: max time per painter
            int mid = s + (e - s) / 2;

            // Check if it's VALID to distribute all boards to k painters
            // such that no painter works more than 'mid' time
            if(isValidAns(arr, k, mid)) {
                // If VALID (k painters can finish all boards in 'mid' time)
                ans = mid; // Store this as a potential solution

                // Try to find a smaller time limit (move left in search space)
                // Can we do it faster? Let's search for smaller values
                e = mid - 1;
            } else {
                // If NOT VALID (k painters cannot finish in 'mid' time)
                // We need more time for painters to work
                s = mid + 1; // Increase the time limit (move right in search space)
            }
        }

        // Return the minimum possible maximum time found
        // This is the optimal distribution where the slowest painter finishes earliest
        return ans;
    }
}
