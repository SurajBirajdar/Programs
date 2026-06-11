package programs.program.newPrograms.binarySearch;

/**
 * PROBLEM EXPLANATION:
 * ====================
 * Find which ROW in a 2D matrix has the MAXIMUM number of 1's
 *
 * The matrix is SORTED: In each row, all 0's come BEFORE all 1's
 * EXAMPLE:
 *    Row 0: [0, 0, 0, 0, 1, 1]  → Has 2 ones (starting from index 4)
 *    Row 1: [0, 0, 1, 1, 1, 1]  → Has 4 ones (starting from index 2)  ← MAXIMUM!
 *    Row 2: [0, 0, 0, 0, 0, 1]  → Has 1 one  (starting from index 5)
 *    Row 3: [0, 1, 1, 1, 1, 1]  → Has 5 ones (starting from index 1)  ← ACTUAL MAXIMUM!
 *    Row 4: [0, 0, 0, 1, 1, 1]  → Has 3 ones (starting from index 3)
 *
 * ANSWER: Row index 3 has the maximum number of 1's (5 ones)
 *
 * WHY IS THIS USEFUL?
 * ===================
 * Instead of checking every element (O(n*m)), we find the FIRST 1 in each row
 * and count how many 1's are after it. Time: O(n*m) but optimizable to O(n+m)
 * with Binary Search!
 *
 * INTUITION:
 * ==========
 * Since each row is sorted (all 0's before all 1's):
 * - Find where the FIRST 1 appears in each row
 * - The LEFTMOST first 1 = most 1's in that row
 * - Count 1's = (total columns - position of first 1)
 */
public class RowWithMaximumOnes {

    public static void main(String[] args) {
        // This is a 2D array (matrix) with 5 rows and 6 columns
        // Think of it like a grid:
        // Row 0: [0, 0, 0, 0, 1, 1]
        // Row 1: [0, 0, 1, 1, 1, 1]
        // Row 2: [0, 0, 0, 0, 0, 1]
        // Row 3: [0, 1, 1, 1, 1, 1]
        // Row 4: [0, 0, 0, 1, 1, 1]
        int[][] arr = { {0,0,0,0,1,1},
                {0,0,1,1,1,1},
                {0,0,0,0,0,1},
                {0,1,1,1,1,1},
                {0,0,0,1,1,1}};

        // Call function to find which row has maximum 1's
        // Expected output: 3 (because row 3 has five 1's - the most)
        System.out.println(rowWithMaximum1_2D(arr));
    }

    /**
     * HELPER FUNCTION 1: Find the FIRST occurrence of 1 in a row
     * ============================================================
     * Since each row is sorted (0's come first, then 1's),
     * we find the INDEX where the first 1 appears
     *
     * EXAMPLE: In row [0, 0, 1, 1, 1, 1], first 1 is at INDEX 2
     * EXAMPLE: In row [0, 0, 0, 0, 1, 1], first 1 is at INDEX 4
     * EXAMPLE: In row [0, 0, 0, 0, 0, 1], first 1 is at INDEX 5
     *
     * @param arr - The 2D matrix
     * @param rowIndex - Which row to check
     * @return - The INDEX (column number) of the first 1, or (colCount+1) if no 1 exists
     */
    public static int firstOccurenceOf1(int[][] arr, int rowIndex) {

        // Get total number of rows
        // EXAMPLE: If matrix has 5 rows, n = 5
        int n = arr.length;

        // Get the LAST column index
        // EXAMPLE: If matrix has 6 columns (indices 0-5), colCount = 5
        int colCount = arr[0].length - 1;

        // Check the LAST column of this row
        // If the last column is 0, then there are NO 1's in this row
        // EXAMPLE: If arr[2][5] = 0, then row 2 has no 1's
        if(arr[rowIndex][colCount] == 0) {
            // Return colCount+1 to indicate "no 1 found"
            // This helps us know: count of 1's = 6 - 6 = 0
            return colCount + 1;
        }

        // Loop through each column from LEFT to RIGHT
        // EXAMPLE: j goes 0, 1, 2, 3, 4, 5...
        for(int j = 0; j <= colCount; j++) {

            // Check if current element is 1
            // EXAMPLE: Is arr[2][3] equal to 1?
            if(arr[rowIndex][j] == 1) {
                // We found the FIRST 1! Return its index
                // EXAMPLE: If we find 1 at column 3, return 3
                return j;
            }
        }

        // If we didn't find any 1 (shouldn't reach here if last column was 1)
        // Return -1 as a fallback
        return -1;
    }

    /**
     * MAIN FUNCTION: Find which ROW has the MAXIMUM number of 1's
     * =============================================================
     * LOGIC:
     * 1. For each row, find where the first 1 appears
     * 2. Count how many 1's are in that row using: colCount - firstPosition
     * 3. Keep track of which row has the maximum count
     * 4. Return that row's index
     *
     * @param arr - The 2D matrix where each row is sorted
     * @return - The row INDEX (0-based) that has the most 1's
     */
    public static int rowWithMaximum1_2D(int[][] arr) {

        // Get total number of rows
        // EXAMPLE: 5 rows means n = 5
        int n = arr.length;

        // Store the number of rows (same as n, just for clarity)
        // EXAMPLE: rowCount = 5
        int rowCount = n;

        // Get total number of columns
        // EXAMPLE: 6 columns means colCount = 6
        int colCount = arr[0].length;

        // Variable to store the MAXIMUM count of 1's we've found so far
        // Initialize to -1 (means "no 1's found yet")
        // EXAMPLE: maxi = -1 initially
        int maxi = -1;

        // Variable to store the ROW INDEX that has the maximum 1's
        // Initialize to -1 (means "no row found yet")
        // EXAMPLE: rowWithMax1 = -1 initially
        int rowWithMax1 = -1;

        // Loop through EACH ROW to check them one by one
        // EXAMPLE: i goes 0, 1, 2, 3, 4 (for 5 rows)
        for(int i = 0; i < rowCount; i++) {

            // Call helper function to find FIRST 1 in this row
            // EXAMPLE: For row 1 [0,0,1,1,1,1], this returns 2 (first 1 is at index 2)
            int firstOccurenceOf1 = firstOccurenceOf1(arr, i);

            // Calculate how many 1's are in this row
            // FORMULA: Total 1's = colCount - firstOccurenceOf1
            // WHY? Because everything AFTER the first 1 is also a 1 (row is sorted)
            // EXAMPLE: For row 1: 6 - 2 = 4 ones (indices 2,3,4,5 are all 1)
            // EXAMPLE: For row 0: 6 - 4 = 2 ones (indices 4,5 are 1)
            int noOfOccurenceOf1 = colCount - firstOccurenceOf1;

            // Check if THIS row has MORE 1's than the previous maximum
            // EXAMPLE: If we found 4 ones and maxi was 2, then 4 > 2 = TRUE
            if(noOfOccurenceOf1 > maxi) {

                // Update the maximum to this new higher count
                // EXAMPLE: maxi = 4
                maxi = noOfOccurenceOf1;

                // Remember THIS row has the maximum 1's
                // EXAMPLE: rowWithMax1 = 1 (row at index 1)
                rowWithMax1 = i;
            }
        }

        // After checking all rows, return the row index that had the most 1's
        // EXAMPLE: Return 3 (if row 3 had the most 1's)
        return rowWithMax1;
    }
}

/**
 * COMPLETE EXAMPLE WALKTHROUGH:
 * =============================
 *
 * Matrix:
 * Index  Col0 Col1 Col2 Col3 Col4 Col5
 * Row0:   0    0    0    0    1    1    → First 1 at index 4 → Count = 6-4 = 2
 * Row1:   0    0    1    1    1    1    → First 1 at index 2 → Count = 6-2 = 4  ← Candidate
 * Row2:   0    0    0    0    0    1    → First 1 at index 5 → Count = 6-5 = 1
 * Row3:   0    1    1    1    1    1    → First 1 at index 1 → Count = 6-1 = 5  ← MAXIMUM!
 * Row4:   0    0    0    1    1    1    → First 1 at index 3 → Count = 6-3 = 3
 *
 * Step-by-step execution:
 *
 * i=0: firstOccurenceOf1 = 4, noOf1's = 6-4 = 2, 2 > -1? YES → maxi=2, rowWithMax1=0
 * i=1: firstOccurenceOf1 = 2, noOf1's = 6-2 = 4, 4 > 2? YES → maxi=4, rowWithMax1=1
 * i=2: firstOccurenceOf1 = 5, noOf1's = 6-5 = 1, 1 > 4? NO  → No change
 * i=3: firstOccurenceOf1 = 1, noOf1's = 6-1 = 5, 5 > 4? YES → maxi=5, rowWithMax1=3
 * i=4: firstOccurenceOf1 = 3, noOf1's = 6-3 = 3, 3 > 5? NO  → No change
 *
 * FINAL ANSWER: 3
 *
 * TIME COMPLEXITY: O(n * m) where n = number of rows, m = number of columns
 *                  (We potentially check every element)
 *
 * SPACE COMPLEXITY: O(1) - Only using a few variables, no extra space
 *
 * OPTIMIZATION POSSIBLE: Could use Binary Search on each row to achieve O(n + m)
 *                        but current solution is straightforward and easy to understand
 */

