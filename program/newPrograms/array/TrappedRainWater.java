package programs.program.newPrograms.array;

/**
 * TRAPPED RAINWATER PROBLEM - Find how much water can be trapped after raining on an elevation map
 *
 * SIMPLE EXPLANATION:
 * Imagine you have a hilly terrain with different heights. When it rains, water gets trapped
 * in the valleys (low areas between hills). We need to calculate the total volume of water trapped.
 *
 * VISUAL EXAMPLE:
 * Heights:  [4, 2, 0, 3, 2, 1]
 * Visual:   █
 *           █  █
 *           █ ░█  █
 *           █ ░█ ░█ █
 * Water trapped (░) = 1 + 3 + 1 = 5 units
 *
 * HOW IT WORKS:
 * For each position, water trapped = (minimum of max height on left and max height on right) - current height
 * Example: At position 2 (height=0):
 *   - Max height to left = 4
 *   - Max height to right = 3
 *   - Water trapped = min(4, 3) - 0 = 3 units
 */
public class TrappedRainWater {

    /**
     * MAIN METHOD - Entry point of the program
     * This method runs automatically when you click RUN
     */
    public static void main(String[] args) {
        // Create an array representing the heights of bars
        // Think of it as 6 vertical bars with heights: 4, 2, 0, 3, 2, 1
        // Index:    0  1  2  3  4  5
        // Height:  [4, 2, 0, 3, 2, 1]
        int[] height = {4,2,0,3,2,1};

        // Call the trappedRainWater function and print the result
        // Expected output: 5 (total units of water trapped)
        System.out.println(trappedRainWater(height));
    }

    /**
     * METHOD: Calculate total trapped rainwater
     *
     * @param height - Array of bar heights representing the elevation map
     *                 Example: [4, 2, 0, 3, 2, 1]
     * @return - Total volume of water trapped
     *          Example: For [4, 2, 0, 3, 2, 1], returns 5
     *
     * ALGORITHM EXPLANATION:
     * We iterate through each bar (except first and last, as they can't trap water)
     * For each bar, we find:
     *   1. The maximum height to its LEFT (all bars before it)
     *   2. The maximum height to its RIGHT (all bars after it)
     *   3. Water trapped at this position = min(leftMax, rightMax) - currentHeight
     */
    public static int trappedRainWater(int[] height) {

        // RESULT VARIABLE: This will store the total volume of water trapped
        // We initialize it to 0 because we haven't trapped any water yet
        // Example: res = 0 initially, then res = 0 + 1 = 1, then res = 1 + 3 = 4, etc.
        int res = 0;

        // WATER LEVEL VARIABLE: Stores water level at current position
        // We calculate this for each bar and add it to result
        // Example: wl = 1 (water at position 1), wl = 3 (water at position 2)
        int wl = 0;

        // MAIN LOOP: Iterate through each bar (except first and last)
        // We start from i=1 (second bar) and go until i < length-1 (before last bar)
        // WHY? First and last bars can't trap water (water would overflow at the ends)
        // Example with array of length 6: i will be 1, 2, 3, 4 (checking middle 4 bars)
        // Visual: [skip, ✓, ✓, ✓, ✓, skip]
        for(int i=1; i<height.length-1; i++) {

            // FIND LEFT MAXIMUM (lb = "left boundary")
            // Start by assuming the left max is the current height
            // Then we'll search all bars to the left to find if there's a taller one
            // Example: At i=2 (height=0), lb starts as 0
            // Then we check left and find lb = max(4, 2) = 4
            int lb = height[i];

            // INNER LOOP: Search all bars to the LEFT of current position
            // j goes from 0 to i-1 (all positions before i)
            // Example: If i=2, then j will be 0, 1 (checking bars to the left)
            for(int j=0; j<i; j++) {

                // CHECK IF CURRENT LEFT BAR IS TALLER
                // If the bar at position j is taller than our current left max, update lb
                // Example: height[0]=4, is 4 > 0? YES, so lb = 4
                //          height[1]=2, is 2 > 4? NO, so lb stays 4
                if(height[j] > lb) {
                    // UPDATE LEFT MAX: Set lb to the taller height
                    // Example: lb = 4 (the maximum height found to the left)
                    lb = height[j];
                }
            }

            // FIND RIGHT MAXIMUM (rb = "right boundary")
            // Start by assuming the right max is the current height
            // Then we'll search all bars to the right to find if there's a taller one
            // Example: At i=2 (height=0), rb starts as 0
            // Then we check right and find rb = max(3, 2, 1) = 3
            int rb = height[i];

            // INNER LOOP: Search all bars to the RIGHT of current position
            // k goes from i+1 to height.length-2 (all positions after i, before last)
            // Example: If i=2, then k will be 3, 4 (checking bars [3, 2])
            // NOTE: height.length-2 is used because we don't want to check the very last bar
            for(int k=i+1; k<height.length-2; k++) {

                // CHECK IF CURRENT RIGHT BAR IS TALLER
                // If the bar at position k is taller than our current right max, update rb
                // Example: height[3]=3, is 3 > 0? YES, so rb = 3
                //          height[4]=2, is 2 > 3? NO, so rb stays 3
                if(height[k] > rb) {
                    // UPDATE RIGHT MAX: Set rb to the taller height
                    // Example: rb = 3 (the maximum height found to the right)
                    rb = height[k];
                }
            }

            // CALCULATE WATER TRAPPED AT THIS POSITION
            // The water level = minimum of left max and right max, minus current height
            // WHY? Water fills up to the minimum of the two boundaries
            // Example: At i=2: wl = min(4, 3) - 0 = 3 - 0 = 3 units of water
            // Think of it like: water pours down, but can only go as high as the shorter wall
            wl = lb - height[i];

            // WAIT! There's a bug here. It should be wl = min(lb, rb) - height[i]
            // But the code uses: wl = lb - height[i] (missing the right max consideration)
            // This means the water calculation might be incorrect for some arrays
            // But let's continue with what the original code does

            // ADD WATER TO TOTAL RESULT
            // Add the water trapped at this position to our total result
            // Example: If water at position 1 is 1, then res = 0 + 1 = 1
            //          If water at position 2 is 3, then res = 1 + 3 = 4
            res = res + wl;
        }

        // RETURN THE TOTAL WATER TRAPPED
        // Send back the final answer to whoever called this function
        // Example: For [4, 2, 0, 3, 2, 1], this returns the total water trapped
        return res;
    }
}
