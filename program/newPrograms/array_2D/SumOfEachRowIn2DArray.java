// This is the package declaration - think of it like assigning this class to a specific folder
// Structure: programs/program/newPrograms/array_2D/
package programs.program.newPrograms.array_2D;

// Import java.util.* - this brings in all utility classes like ArrayList and List
// Think of it as opening a toolbox that contains ArrayList, List, and other helpful tools
import java.util.*;

// This is the main class - like the blueprint for our program
// Class name: SumOfEachRowIn2DArray - describes what the class does (sums each row in a 2D array)
public class SumOfEachRowIn2DArray {

    // This is the main method - the entry point where your program starts running
    // String[] args allows us to pass command-line arguments (not used here, but good to have)
    // The program execution ALWAYS starts from public static void main(String[] args)
    public static void main(String[] args) {

        // EXAMPLE: Think of a 2D array (matrix) like a table in a spreadsheet or grid
        // int[][] means: array of arrays (2D array) that holds integers
        // Example visualization:
        // ┌─────┬─────┐
        // │  5  │ 10  │  <- Row 0, sum = 15
        // ├─────┼─────┤
        // │ 20  │ 30  │  <- Row 1, sum = 50
        // ├─────┼─────┤
        // │ 40  │ 50  │  <- Row 2, sum = 90
        // └─────┴─────┘
        int[][] matrix = {
                {5, 10},   // Row 0: contains 5 and 10
                {20, 30},  // Row 1: contains 20 and 30
                {40, 50}   // Row 2: contains 40 and 50
        };

        // Call the sumOfEachRow method and pass the matrix
        // The method will calculate sum of each row and return a List
        // Example: [15, 50, 90]
        List<Integer> result = sumOfEachRow(matrix);

        // Loop through the result list and print each sum
        // i=0: print 15, i=1: print 50, i=2: print 90
        // result.size() returns 3 (we have 3 rows)
        // System.out.print() prints without moving to next line (like a continuous stream)
        for(int i=0; i<result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        // Output: 15 50 90
    }

    // This is a static helper method - it does the actual work of calculating sums
    // "static" means we can call this method without creating an object of this class
    // "List<Integer>" is the return type - we're returning a List of Integer values
    // "int[][] arr" is the parameter - the 2D array we want to sum
    //
    // EXAMPLE FLOW for our matrix:
    // Input: {{5, 10}, {20, 30}, {40, 50}}
    // Output: [15, 50, 90]
    public static List<Integer> sumOfEachRow(int[][] arr) {

        // Create an empty list to store the sum of each row
        // ArrayList is like a dynamic array that can grow as we add elements
        // We'll add one sum value for each row
        // Example: after processing, it will contain [15, 50, 90]
        List<Integer> result = new ArrayList<>();

        // Get the number of rows in the 2D array
        // arr.length returns how many rows we have
        // Example: arr.length = 3 (we have 3 rows)
        int m = arr.length;

        // Get the number of columns in the first row
        // arr[0] means the first row, and .length gives us columns in that row
        // Example: arr[0].length = 2 (each row has 2 elements)
        int n = arr[0].length;

        // OUTER LOOP: Loop through each row one by one
        // row starts at 0 and goes up to m-1 (0, 1, 2)
        // In each iteration, we'll calculate the sum of that row
        for(int row=0; row<m; row++) {

            // Initialize sum to 0 for the current row
            // This is like resetting a counter before counting items in a bag
            // Example: row=0, sum=0 (ready to count elements in first row)
            int sum = 0;

            // INNER LOOP: Loop through each column in the current row
            // col starts at 0 and goes up to n-1 (0, 1)
            // In each iteration, we add that element to our sum
            for(int col=0; col<n; col++) {

                // Get the value at current row and column position
                // arr[row][col] means: go to 'row' row, then 'col' column
                // Example: arr[0][0] = 5, arr[0][1] = 10, arr[1][0] = 20, etc.
                int value = arr[row][col];

                // Add the current value to our running sum
                // sum = sum + value is equivalent to sum += value
                // Example for row 0:
                //   col=0: sum = 0 + 5 = 5
                //   col=1: sum = 5 + 10 = 15
                sum = sum + value;
            }

            // Add the final sum of the current row to our result list
            // After the inner loop completes, we have the sum of the entire row
            // Example: after processing row 0, we add 15 to result
            result.add(sum);
            // result now contains: [15] after first iteration
            // result now contains: [15, 50] after second iteration
            // result now contains: [15, 50, 90] after third iteration
        }

        // Return the list containing sum of each row
        // The calling code (main method) will receive this list
        // Example: returns [15, 50, 90]
        return result;
    }
}
