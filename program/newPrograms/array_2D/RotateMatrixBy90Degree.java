package programs.program.newPrograms.array_2D;

/**
 * PROBLEM EXPLANATION (In Layman's Terms):
 * ==========================================
 *
 * WHAT IS MATRIX ROTATION BY 90 DEGREES?
 *
 * Imagine you have a grid of numbers:
 *    1 2 3           7 4 1
 *    4 5 6   =>      8 5 2
 *    7 8 9           9 6 3
 *
 * When you rotate it 90 degrees clockwise, the first column becomes the first row!
 *
 * HOW DO WE DO THIS?
 * Two steps:
 * Step 1: TRANSPOSE - Flip the matrix along diagonal (rows become columns)
 *    1 2 3           1 4 7
 *    4 5 6   =>      2 5 8
 *    7 8 9           3 6 9
 *
 * Step 2: REVERSE EACH ROW - Make each row go backwards
 *    1 4 7           7 4 1
 *    2 5 8   =>      8 5 2
 *    3 6 9           9 6 3
 *
 * Result: 90-degree clockwise rotation!
 */

public class RotateMatrixBy90Degree {

    public static void main(String[] args) {
        // rotate matrix by 90 degree
        int matrix[][] = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};

        // Call our rotation function and store the rotated result
        // The function will rotate our matrix by 90 degrees clockwise
        int[][] result = rotateMatrixBy90Degree(matrix);

        // Print the rotated matrix to see the result
        // We use nested loops: outer loop for rows, inner loop for columns

        // Outer loop: i goes from 0 to 2 (because we have 3 rows)
        // result.length gives us the number of rows (which is 3)
        for(int i=0; i<result.length; i++) {

            // Inner loop: j goes from 0 to 2 (because we have 3 columns)
            // result[0].length gives us the number of columns (which is 3)
            for(int j=0; j<result[0].length; j++) {
                // Print each number in the current row, followed by a space
                // Example: when i=0, j=0,1,2 we print: "7 4 1 "
                System.out.print(result[i][j] + " ");
            }

            // After printing all columns in current row, print a newline
            // This moves cursor to the next row for printing
            System.out.println();
        }
    }

    /**
     * FUNCTION: rotateMatrixBy90Degree
     * INPUT: A 2D integer matrix (like a grid of numbers)
     * OUTPUT: The same matrix, but rotated 90 degrees clockwise
     *
     * EXAMPLE:
     * Input:  1 2 3      Output: 7 4 1
     *         4 5 6              8 5 2
     *         7 8 9              9 6 3
     */
    public static int[][] rotateMatrixBy90Degree(int[][] matrix) {

        // STEP 1: TRANSPOSE THE MATRIX
        // Why transpose? Because when we flip rows and columns, then reverse each row,
        // we get a 90-degree rotation!

        // Get the number of rows in the matrix
        // matrix.length tells us how many rows we have
        // Example: if matrix has 3 rows, m = 3
        int m = matrix.length;

        // Get the number of columns in the matrix
        // matrix[0].length tells us how many columns are in the first row
        // Example: if first row has 3 elements, n = 3
        int n = matrix[0].length;

        // Outer loop for transposing: i represents the row number
        // i goes from 0 to 2 (for a 3x3 matrix)
        // This loop picks each row one by one
        for(int i=0; i<m; i++) {
            // internal for loop is only diagonal wise
            for(int j=i+1; j<n; j++) {

                // Create a temporary variable to hold one value
                // Think of it like having 3 hands: one to hold old value, two to swap
                // Example: if we want to swap 2 and 4:
                // temp = 2 (store first value safely)
                int temp = matrix[i][j];

                // Copy the value from position [j][i] to position [i][j]
                // Example: copy 4 to where 2 was
                // matrix[i][j] = 4
                matrix[i][j] = matrix[j][i];

                // Copy the value we saved in temp to position [j][i]
                // Example: copy 2 (which we saved) to where 4 was
                // matrix[j][i] = 2
                // Now 2 and 4 are swapped!
                matrix[j][i] = temp;
            }
        }
        // then reverse each row
        for(int i=0; i<m; i++) {
            // in each row now use two pointer approach to reverse row
            int startCol = 0;

            // Initialize endCol pointer at the end of the row
            // n-1 because arrays are 0-indexed
            // Example: for row [1, 4, 7], endCol starts at position 2 (value 7)
            int endCol = n-1;

            // Two-pointer approach: Move startCol and endCol towards each other
            // We keep swapping values until they meet in the middle
            // Example: [1, 4, 7] becomes [7, 4, 1]
            // startCol points to 1, endCol points to 7 → swap → [7, 4, 1]
            while(startCol<endCol) {

                // Save the value at startCol in temp variable
                // Example: temp = 1 (the value at startCol)
                int temp = matrix[i][startCol];

                // Copy the value from endCol to startCol
                // Example: matrix[i][0] = 7 (copy from endCol to startCol)
                matrix[i][startCol] = matrix[i][endCol];

                // Copy the saved value to endCol
                // Example: matrix[i][2] = 1 (copy our saved value)
                // Now we've swapped 1 and 7!
                matrix[i][endCol] = temp;

                // Move startCol one position to the right
                // This moves our left pointer closer to the center
                // Example: startCol was 0, now startCol = 1
                startCol++;

                // Move endCol one position to the left
                // This moves our right pointer closer to the center
                // Example: endCol was 2, now endCol = 1
                // Now startCol (1) and endCol (1) have met, so we stop the loop
                endCol--;
            }
        }

        // After reversing each row, matrix looks like this:
        // Before:  1 4 7      After reversing:  7 4 1
        //          2 5 8                        8 5 2
        //          3 6 9                        9 6 3

        // Return the rotated matrix back to the caller
        // The matrix is now rotated 90 degrees clockwise!
        return matrix;
    }
}
