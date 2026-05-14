package programs.program.newPrograms.array_2D;

public class TransposeMatrix {
    // This is the main method - Program execution starts from here
    public static void main(String[] args) {
        // Transpose means: Convert Rows into Columns and Columns into Rows
        // Original: 3 rows × 2 columns => After Transpose: 2 rows × 3 columns

        // Creating a 2D array (Matrix) with 3 rows and 2 columns
        int[][] matrix = {{10, 11},
                {12, 13},
                {14, 15} };

        // Call the transposeMatrix function and store the result
        int[][] result = transposeMatrix(matrix);

        // Print the transposed matrix
        // Outer loop: Goes through each row
        for(int i=0; i<result.length; i++) {
            // Inner loop: Goes through each column in the row
            for(int j=0; j<result[0].length; j++) {
                // Print each element with a space after it
                System.out.print(result[i][j] + " ");
            }
            // After printing one complete row, move to next line
            System.out.println();
        }
    }

    // This function takes a 2D array (matrix) and returns its transpose
    public static int[][] transposeMatrix(int[][] matrix) {

        // Count total number of rows in the original matrix
        // In our example: matrix.length = 3 (we have 3 rows)
        int totalRows = matrix.length;

        // Count total number of columns in the original matrix
        // In our example: matrix[0].length = 2 (each row has 2 columns)
        int totalCols = matrix[0].length;

        // transpose means jo number of rows hai wo no of cols honge and vice versa

        // The new transposed matrix will have totalCols number of rows
        // In our example: newTotalRows = 2
        int newTotalRows = totalCols;

        // The new transposed matrix will have totalRows number of columns
        // In our example: newTotalCols = 3
        int newTotalCols = totalRows;

        // create new array in which I wanted to store new transpose elements
        int[][] result = new int[newTotalRows][newTotalCols];

        // now traversing old array and will add values in new array
        for(int i=0; i<totalRows; i++) {
            // Inner loop: Goes through each column of original matrix (0, 1)
            for(int j=0; j<totalCols; j++) {
                // Transpose Logic:
                // Take element from original matrix at position [i][j]
                // Put it in new matrix at position [j][i]
                // This swaps rows and columns
                // Example: matrix[0][1]=11 becomes result[1][0]=11
                result[j][i]=matrix[i][j];
            }
        }

        // Return the transposed matrix
        return result;
    }
}
