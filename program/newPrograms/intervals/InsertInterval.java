package programs.program.newPrograms.intervals;

import java.util.*;

/**
 * PROBLEM: Insert a new interval into a list of non-overlapping intervals
 *
 * EXAMPLE:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 *
 * WHY? [4,8] overlaps with [3,5] and [6,7] and [8,10], so we merge them all!
 */
public class InsertInterval {

    public static void main(String[] args) {
        // Step 1: Create existing intervals (like booked time slots)
        // Think of it as: [1-2], [3-5], [6-7], [8-10], [12-16] are already booked
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};

        // Step 2: Create a new interval to insert (we want to book [4-8])
        int[] newInterval = {4,8};

        // Step 3: Call the method to insert and merge overlapping intervals
        int[][] result = insertInterval(intervals, newInterval);

        // Step 4: Print the final result in readable format
        // Example output: [1, 2] [3, 10] [12, 16]
        for(int i=0; i<result.length; i++) {
            System.out.print("[" + result[i][0] + ", " + result[i][1] + "] ");
        }
    }

    /**
     * METHOD: insertInterval()
     *
     * ALGORITHM EXPLANATION:
     * Step 1: Add all intervals that END BEFORE newInterval STARTS (no overlap)
     * Step 2: Merge all intervals that OVERLAP with newInterval
     * Step 3: Add the merged interval to result
     * Step 4: Add remaining intervals (they come AFTER newInterval)
     */
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        // Create a list to store the final answer
        // ArrayList is like a flexible bucket that can grow as needed
        // Example: We'll put intervals here one by one
        ArrayList<int[]> result = new ArrayList<>();

        // Counter 'i' to track which interval we're looking at
        // Think of it as pointing to intervals one by one: [1,2], [3,5], etc.
        int i = 0;

        // 'n' stores total number of existing intervals
        // Example: n = 5 because we have 5 intervals
        int n = intervals.length;

        // ========================================
        // PHASE 1: Add non-overlapping intervals BEFORE newInterval
        // ========================================
        // Condition: intervals[i][1] < newInterval[0]
        // Meaning: If an interval ENDS BEFORE new interval STARTS, it doesn't overlap
        //
        // EXAMPLE:
        // intervals[i] = [1, 2], newInterval = [4, 8]
        // [1,2] ends at 2, [4,8] starts at 4
        // 2 < 4? YES! So [1,2] doesn't overlap with [4,8], add it to result
        while(i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);  // Add this interval safely (no overlap)
            i++;                        // Move to next interval
        }

        // ========================================
        // PHASE 2: Merge all overlapping intervals
        // ========================================
        // Condition: newInterval[1] >= intervals[i][0]
        // Meaning: If new interval's END >= current interval's START, they overlap!
        //
        // EXAMPLE:
        // newInterval = [4, 8], intervals[i] = [3, 5]
        // [4,8] ends at 8, [3,5] starts at 3
        // 8 >= 3? YES! They overlap, so we MERGE them
        while(i < n && newInterval[1] >= intervals[i][0]) {
            // Expand newInterval's START to include the overlapping interval's START
            // newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            // Take the SMALLER start value
            // EXAMPLE: newInterval starts at 4, interval starts at 3, use 3
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);

            // Expand newInterval's END to include the overlapping interval's END
            // newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            // Take the LARGER end value
            // EXAMPLE: newInterval ends at 8, interval ends at 10, use 10
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);

            // Move to next interval to check for more overlaps
            i++;
        }

        // After merging, add the final merged interval to result
        // At this point, newInterval contains all overlapped intervals merged together
        result.add(newInterval);

        // ========================================
        // PHASE 3: Add remaining non-overlapping intervals AFTER newInterval
        // ========================================
        // These intervals start AFTER newInterval ends, so no overlap
        // EXAMPLE: [12, 16] comes after [3, 10], so just add it
        while(i < n) {
            result.add(intervals[i]);  // Add remaining intervals
            i++;                        // Move to next
        }

        // Convert ArrayList to 2D array and return
        // result.toArray(new int[result.size()][2]) converts the list to array format
        // [2] means each row has 2 columns (start and end)
        // EXAMPLE: [[1,2], [3,10], [12,16]]
        return result.toArray(new int[result.size()][2]);
    }

}
