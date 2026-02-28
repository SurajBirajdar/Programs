package programs.program.newPrograms.twoPointer;

/**
 * CONTAINER WITH MOST WATER PROBLEM - Find two lines that can hold the maximum amount of water
 *
 * SIMPLE EXPLANATION (Like explaining to a baby):
 * Imagine you have a bunch of VERTICAL BARS of different heights standing in a line.
 * You want to pick TWO BARS and fill water between them.
 * The amount of water you can hold = HEIGHT (limited by shorter bar) × DISTANCE (gap between bars)
 *
 * VISUAL EXAMPLE:
 * Heights: [6, 4, 2, 5, 4, 6, 1, 3, 5]
 * Index:    0  1  2  3  4  5  6  7  8
 *
 * Visual representation:
 * █         █           █
 * █  █      █  █        █
 * █  █  █   █  █  █     █
 * █  █  █   █  █  █  █  █  █
 * ─────────────────────────────
 * 0  1  2   3  4  5  6  7  8
 *
 * If we pick index 0 (height=6) and index 5 (height=6):
 * Water = min(6, 6) × distance(5-0) = 6 × 5 = 30 units (MAXIMUM!)
 *
 * TWO POINTER STRATEGY:
 * Start with leftmost and rightmost bars
 * Move the POINTER of the SHORTER bar inward
 * This helps us find better containers without checking all pairs
 */
public class ContainerWithMostWater {

    /**
     * MAIN METHOD - Entry point where the program starts
     * This method runs automatically when you click RUN
     */
    public static void main(String[] args) {
        // Create an array of bar heights
        // Think of it like: [6, 4, 2, 5, 4, 6, 1, 3, 5]
        // Index:           0  1  2  3  4  5  6  7  8
        // We need to find which 2 bars can hold the most water between them
        int[] height = {6,4,2,5,4,6,1,3,5};

        // Call the containerWithMostWater function and print the result
        // Expected output: 30 (holding water between index 0 and 5, both height 6)
        System.out.println(containerWithMostWater(height));
    }

    /**
     * METHOD: Find the maximum area (water) that can be contained between two bars
     *
     * @param arr - Array of bar heights
     *              Example: [6, 4, 2, 5, 4, 6, 1, 3, 5]
     * @return - Maximum area/volume of water that can be contained
     *           Example: For [6, 4, 2, 5, 4, 6, 1, 3, 5], returns 30
     *
     * TWO POINTER ALGORITHM EXPLANATION:
     * We use two pointers (left and right) starting from both ends
     * In each iteration:
     *   1. Calculate area between current left and right bars
     *   2. Store if this is the maximum area so far
     *   3. Move the pointer pointing to the SHORTER bar inward
     *
     * WHY move the shorter bar's pointer?
     * Because moving the taller bar's pointer will ONLY make area smaller
     * (width decreases, height won't increase because it's limited by the shorter bar)
     * But moving the shorter bar's pointer might find a TALLER bar and increase area
     */
    public static int containerWithMostWater(int[] arr) {

        // LEFT POINTER: Start from the leftmost bar (index 0)
        // Think of it as: standing at the LEFT END of the array
        // Example: l = 0 points to height[0] = 6
        int l = 0;

        // RIGHT POINTER: Start from the rightmost bar (last index)
        // Think of it as: standing at the RIGHT END of the array
        // arr.length = 9, so arr.length-1 = 8
        // Example: r = 8 points to height[8] = 5
        int r = arr.length-1;

        // MAX VARIABLE: Stores the maximum area found so far
        // We initialize to 0 because we haven't calculated any area yet
        // As we check different containers, we update this if we find a larger area
        // Example: max starts at 0, then becomes 18, then 30
        int max = 0;

        // WHILE LOOP: Continue until left pointer meets or crosses right pointer
        // As long as l < r, we have two different bars to form a container
        // Example: while(0 < 8), while(1 < 8), while(2 < 7), ... until l >= r
        while(l<r) {

            // FIND THE LIMITING HEIGHT: Get the minimum of the two bar heights
            // Water can only fill up to the HEIGHT of the SHORTER bar
            // Because water would spill over the shorter bar otherwise
            // Example with l=0, r=8: minimumHeight = min(6, 5) = 5
            // Think of it like: pouring water between two walls, it fills to the shorter wall
            int minimumHeight = Math.min(arr[l], arr[r]);

            // CALCULATE WIDTH: Distance between left and right pointers
            // width = position of right bar - position of left bar
            // Example with l=0, r=8: width = 8 - 0 = 8
            // Think of it like: measuring the gap between two bars
            int width = r-l;

            // CALCULATE AREA: Area of container = Height × Width
            // This is how much water can fit between these two bars
            // Example: area = 5 × 8 = 40 units of water
            // Think of it like: a rectangular container with height=5, width=8
            int area = minimumHeight * width;

            // CHECK IF CURRENT AREA IS GREATER THAN MAX
            // If the area we just calculated is better than the best we've found
            // Update the max to this new larger area
            // Example: if area (40) > max (0), then max = 40
            if(area > max) {
                // UPDATE MAX: Store this new maximum area
                // Now max = 40 (this is the best container so far)
                max = area;
            }

            // MOVE THE POINTER OF THE SHORTER BAR
            // This is the KEY STRATEGY of the two-pointer approach!
            // We always move the pointer of the shorter bar inward
            // WHY? Because:
            //   - Moving the taller bar's pointer only makes area smaller
            //     (width decreases, height can't increase because it's limited by shorter bar)
            //   - Moving the shorter bar's pointer might find a taller bar
            //     (which could give us a larger area despite smaller width)

            // CHECK IF LEFT BAR IS SHORTER
            // Compare the actual HEIGHT values of the left and right bars
            // If left bar is shorter, we move LEFT pointer inward to find a taller bar
            // If right bar is shorter or equal, we move RIGHT pointer inward
            // This is the CORRECT logic for two-pointer approach!
            if(arr[l] < arr[r]) {
                // LEFT BAR IS SHORTER: Move left pointer right (inward)
                // We move the SHORTER bar's pointer because:
                //   - Area is limited by the shorter height
                //   - Moving the taller bar only decreases width (area shrinks)
                //   - Moving the shorter bar might find a taller bar (could increase area)
                // Example: arr[0]=6 < arr[8]=5? NO (6 > 5)
                //          arr[1]=4 < arr[8]=5? YES → move left pointer
                //          l++ moves from 1 to 2
                l++;
            } else {
                // RIGHT BAR IS SHORTER OR EQUAL: Move right pointer left (inward)
                // Same logic: move the shorter bar's pointer to find a potentially taller bar
                // Example: arr[7]=3 >= arr[8]=5? NO (3 < 5)
                //          arr[8]=5 >= arr[7]=3? YES → move right pointer
                //          r-- moves from 8 to 7
                r--;
            }

            // ✅ CORRECT LOGIC EXPLANATION:
            // This if-else correctly implements the two-pointer strategy!
            // By checking arr[l] < arr[r], we identify which bar is shorter
            // Then we move that shorter bar's pointer inward
            // This greedy approach ensures we explore all promising containers
            // without wasting time on impossible combinations
        }

        // RETURN THE RESULT
        // After checking all valid container combinations
        // Return the maximum area we found
        // Example: Return 30 (the largest container area)
        return max;
    }
}
