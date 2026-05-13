package programs.program.newPrograms.array_2D;
// EXPLANATION: This line tells Java which folder/organization this file belongs to.
// Think of it like your address - it helps Java find this file among many files.
// Example: Just like your home address helps the postman find your house!

import java.util.*;
// EXPLANATION: This imports ALL utility classes from java.util library.
// We need this to use ArrayList and List classes.
// Think of it as borrowing tools from a toolbox - we're importing List and ArrayList here.

public class SumOfEachColumn2DArray {
    // EXPLANATION: This is the class definition. A class is like a blueprint for creating objects.
    // It's public, meaning anyone can use it.
    // The name describes what it does: "SumOfEachColumn2DArray"
    // Example: Think of a class as a cookie cutter - it defines the shape!

    public static void main(String[] args) {
        // EXPLANATION: This is the entry point of the program - where execution starts.
        // "public" = anyone can call this method
        // "static" = you don't need to create an object to run this
        // "void" = this method doesn't return any value, it just executes
        // "String[] args" = receives command-line arguments (we're not using them here)
        // Example: When you run the program, Java looks for main() first, like starting a car engine!

        // sum of each column in 2D array
        // EXPLANATION: This is a comment explaining what the code does next.
        // Comments help YOU (and others) understand the code later.
        // They are NOT executed by Java, just for humans to read!

        int[][] matrix = {
                // EXPLANATION: We're creating a 2D array (table-like structure with rows and columns).
                // "int[][]" means array of arrays - it can hold multiple rows and columns of integers.
                // Think of it like an Excel spreadsheet with rows and columns!
                // Example:
                //     Column 0  Column 1
                //     --------  --------
                // Row 0:   5      10
                // Row 1:   20      30
                // Row 2:   40      50

                {5, 10},  // Row 0 - EXPLANATION: First row with 2 values. 5 is at column 0, 10 is at column 1
                {20, 30}, // Row 1 - EXPLANATION: Second row with 2 values. 20 is at column 0, 30 is at column 1
                {40, 50}  // Row 2 - EXPLANATION: Third row with 2 values. 40 is at column 0, 50 is at column 1
        };
        // EXPLANATION: The closing brace finishes the matrix definition.

        List<Integer> result = sumOfEachRow(matrix);
        // EXPLANATION: We're calling the method sumOfEachRow() and passing our matrix to it.
        // The method will calculate the sum of each column and return it as a List.
        // "List<Integer>" means a list that holds Integer values.
        // "result" will store: [65, 90] because:
        //   - Column 0: 5 + 20 + 40 = 65
        //   - Column 1: 10 + 30 + 50 = 90

        for(int i=0; i<result.size(); i++) {
            // EXPLANATION: This is a FOR loop - it repeats code multiple times.
            // "int i=0" = start with i = 0 (first position)
            // "i<result.size()" = continue loop while i is less than the size of result list
            // "i++" = after each iteration, increase i by 1
            // Think of it like counting: 0, 1, 2, ... until you reach the end!
            // Example: If result has 2 elements, loop runs twice (i=0, i=1)

            System.out.print(result.get(i) + " ");
            // EXPLANATION: This line prints the current element from the list.
            // "System.out.print" = display something on the screen
            // "result.get(i)" = get the element at position i from the result list
            // "+ " " = add a space after each number for readable output
            // Example: If result = [65, 90], this prints: "65 90 "
        }
    }

    public static List<Integer> sumOfEachRow(int[][] arr) {
        // EXPLANATION: This method definition. It takes a 2D array as input and returns a List of Integers.
        // "public static" = anyone can call this method without creating an object
        // "List<Integer>" = this method returns a list of integers
        // "sumOfEachRow" = the name describes what it does
        // "int[][] arr" = the input parameter - a 2D array called "arr"
        // Example: Input is our matrix, Output is the sum of each column as a list!

        List<Integer> result = new ArrayList<>();
        // EXPLANATION: We create an empty ArrayList to store our results.
        // "List<Integer>" = variable that can hold a list of integers
        // "new ArrayList<>()" = creates a new, empty list
        // Think of it as an empty basket where you'll put the sums!
        // Example: result = [] (empty at first, will become [65, 90] at the end)

        int m = arr.length;
        // EXPLANATION: Get the number of rows in the array.
        // "arr.length" = how many rows the 2D array has
        // "m" = store this value in variable m (m for "rows" or "matrix rows")
        // In our example: arr has 3 rows, so m = 3
        // Think of it as: "How many shelves does my bookshelf have?"

        int n = arr[0].length;
        // EXPLANATION: Get the number of columns in the array.
        // "arr[0]" = the first row (row at index 0)
        // "arr[0].length" = how many elements are in the first row = number of columns
        // "n" = store this value in variable n (n for "columns")
        // In our example: first row {5, 10} has 2 elements, so n = 2
        // Think of it as: "How many items fit in each shelf?"

        for(int col=0; col<n; col++) {
            // EXPLANATION: Outer loop - repeats for each column in the array.
            // "int col=0" = start with column index = 0 (first column)
            // "col<n" = continue while col is less than number of columns (2 in our case)
            // "col++" = move to next column after each iteration
            // This loop runs 2 times: col=0, col=1
            // Think of it as: "Process each column one by one"

            int sum =0;
            // EXPLANATION: Create a variable to store the sum of current column.
            // "int sum = 0" = start with sum as 0
            // We reset sum to 0 for each new column
            // Example: For column 0, sum starts as 0, then becomes 5, then 25, then 65

            for(int row=0; row<m; row++) {
                // EXPLANATION: Inner loop - repeats for each row in the current column.
                // "int row=0" = start with row index = 0 (first row)
                // "row<m" = continue while row is less than number of rows (3 in our case)
                // "row++" = move to next row after each iteration
                // This loop runs 3 times: row=0, row=1, row=2
                // Think of it as: "For this column, go through all rows one by one"

                int value = arr[row][col];
                // EXPLANATION: Get the element at current row and column position.
                // "arr[row][col]" = access the element at specific row and column
                // "value" = store this element in a variable
                // Example: When col=0, row=0: arr[0][0] = 5 (store 5 in value)
                //          When col=0, row=1: arr[1][0] = 20 (store 20 in value)
                //          When col=0, row=2: arr[2][0] = 40 (store 40 in value)
                // Think of it as: "Pick the cell at this row and column from the table"

                sum = sum + value;
                // EXPLANATION: Add the current element to the running sum.
                // "sum = sum + value" means: take current sum, add the value to it, store back in sum
                // Example:
                //   First iteration (row=0): sum = 0 + 5 = 5
                //   Second iteration (row=1): sum = 5 + 20 = 25
                //   Third iteration (row=2): sum = 25 + 40 = 65
                // Think of it as: "Keep adding numbers one by one, like a running total"
            }

            result.add(sum);
            // EXPLANATION: Add the total sum of current column to the result list.
            // "result.add(sum)" = append the sum to the end of the result list
            // After column 0: result = [65]
            // After column 1: result = [65, 90]
            // Think of it as: "Write down the total, then move to next column"
        }

        return result;
        // EXPLANATION: This method is finished. Return the result list to whoever called this method.
        // "return result" = send back the list containing all column sums
        // In our example: returns [65, 90]
        // Think of it as: "Give back the answer you calculated"
    }
}

