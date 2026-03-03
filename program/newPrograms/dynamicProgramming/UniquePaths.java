package programs.program.newPrograms.dynamicProgramming;

/**
 * UNIQUE PATHS PROBLEM:
 * Imagine a robot at the top-left corner of a grid that wants to reach bottom-right corner.
 * The robot can only move DOWN or RIGHT.
 * How many different paths can the robot take?
 *
 * Example: For a 2x2 grid:
 * Robot starts at (0,0), needs to reach (1,1)
 * Possible paths:
 * Path 1: Right then Down
 * Path 2: Down then Right
 * Total = 2 paths
 */
public class UniquePaths {

    /**
     * Main method - Entry point of the program
     * This is where the program execution starts
     */
    public static void main(String[] args) {
        // Call the uniquePaths method with m=3 (3 rows) and n=7 (7 columns)
        // Example: In a 3x7 grid, robot has to move from (0,0) to (2,6)
        System.out.println("Unique Paths (3x7): " + uniquePaths(3,7));

        // Example for Minimum Path Sum
        int[][] grid = {
            {1, 3, 1},
            {2, 2, 1},
            {1, 0, 1}
        };
        System.out.println("Minimum Path Sum: " + minimumPathSum(grid));
    }

    /**
     * Method to calculate number of unique paths
     *
     * @param m = number of rows in the grid (height)
     * @param n = number of columns in the grid (width)
     * @return total number of unique paths from top-left to bottom-right
     *
     * Logic Explanation:
     * - We use Dynamic Programming (DP) approach
     * - We store intermediate results to avoid recalculating
     * - grid[i][j] represents how many ways we can reach position (i,j)
     */
    public static int uniquePaths(int m, int n) {
        // Create a 2D array (table) to store the number of ways to reach each cell
        // Example: For 3x7 grid, we create a table with 3 rows and 7 columns
        // Each cell will store a number representing paths to that cell
        int[][] grid = new int[m][n];

        // Outer loop: iterate through each row (i represents row number)
        // i=0 means first row, i=1 means second row, i=2 means third row, etc.
        for(int i=0; i<m; i++) {
            // Inner loop: iterate through each column (j represents column number)
            // j=0 means first column, j=1 means second column, etc.
            for(int j=0; j<n; j++) {
                // Base case: If we are in the first row (i==0) OR first column (j==0)
                // There is ONLY ONE way to reach any cell in first row or first column
                //
                // Why? Because:
                // - To reach first row cells, robot can only go RIGHT (from left)
                // - To reach first column cells, robot can only go DOWN (from top)
                //
                // Example in a 3x3 grid:
                // grid[0][0]=1, grid[0][1]=1, grid[0][2]=1 (first row: all 1s, only one way each)
                // grid[1][0]=1, grid[2][0]=1 (first column: all 1s, only one way each)
                if(i==0 || j==0) {
                    grid[i][j] = 1;
                }
                // Recursive case: For all other cells
                // To reach cell (i,j), the robot could have come from:
                // 1. Cell above (i-1, j) by moving DOWN
                // 2. Cell to the left (i, j-1) by moving RIGHT
                //
                // So, total ways to reach (i,j) = ways from above + ways from left
                //
                // Example:
                // If grid[0][1] = 1 (1 way to reach) and grid[1][0] = 1 (1 way to reach)
                // Then grid[1][1] = 1 + 1 = 2 (can reach via two paths)
                else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }

        // Return the answer: grid[m-1][n-1] contains the number of paths to bottom-right
        // m-1 because array indexing starts from 0
        // If m=3, last row index is 2 (which is m-1)
        // If n=7, last column index is 6 (which is n-1)
        //
        // Example output for uniquePaths(3,7):
        // grid[2][6] will contain the total number of unique paths
        return grid[m-1][n-1];
    }

    /**
     * MINIMUM PATH SUM PROBLEM:
     * Given a grid with costs in each cell, find the path from top-left to bottom-right
     * that has the MINIMUM TOTAL COST.
     * The robot can only move DOWN or RIGHT.
     *
     * Example: For a 3x3 grid with values:
     * [1, 3, 1]
     * [2, 2, 1]
     * [1, 0, 1]
     *
     * Optimal path: 1 → 2 → 2 → 1 → 1 = 7 (minimum cost)
     *
     * @param grid = a 2D array where each cell contains a cost/value
     * @return the minimum sum of costs to reach from top-left to bottom-right
     *
     * Logic Explanation:
     * - We use Dynamic Programming (DP) approach
     * - dp[i][j] represents the minimum cost to reach cell (i,j) from (0,0)
     * - To reach (i,j), we can come from above (i-1,j) or from left (i,j-1)
     * - We choose the path with smaller cost: min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
     */
    public static int minimumPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;      // number of rows
        int n = grid[0].length;   // number of columns

        // Create a DP table where dp[i][j] = minimum cost to reach cell (i,j)
        int[][] dp = new int[m][n];

        // Outer loop: iterate through each row
        for(int i = 0; i < m; i++) {
            // Inner loop: iterate through each column
            for(int j = 0; j < n; j++) {
                // Base case: Starting cell (top-left corner)
                // The cost to reach (0,0) is just the value of that cell itself
                // Example: If grid[0][0] = 1, then dp[0][0] = 1
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                // Special case: First row (i == 0)
                // Robot can ONLY come from the left (j-1)
                // So, dp[0][j] = dp[0][j-1] + grid[0][j]
                //
                // Example: If grid = [1, 3, 1]
                // dp[0][0] = 1
                // dp[0][1] = 1 + 3 = 4 (only way: go right from start)
                // dp[0][2] = 4 + 1 = 5 (only way: continue right)
                else if(i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }
                // Special case: First column (j == 0)
                // Robot can ONLY come from above (i-1)
                // So, dp[i][0] = dp[i-1][0] + grid[i][0]
                //
                // Example: If first column is [1, 2, 1]
                // dp[0][0] = 1
                // dp[1][0] = 1 + 2 = 3 (only way: go down from start)
                // dp[2][0] = 3 + 1 = 4 (only way: continue down)
                else if(j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                // General case: For all other cells
                // Robot could have come from EITHER above OR left
                // We choose the path with MINIMUM cost
                // dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
                //
                // Example:
                // If dp[0][1] = 4 (cost from above) and dp[1][0] = 3 (cost from left)
                // And grid[1][1] = 2
                // Then dp[1][1] = min(4, 3) + 2 = 3 + 2 = 5
                else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }

        // Return the minimum cost to reach bottom-right corner
        // dp[m-1][n-1] contains the minimum total cost
        //
        // Example: For a 3x3 grid, dp[2][2] contains the answer
        return dp[m-1][n-1];
    }
}
