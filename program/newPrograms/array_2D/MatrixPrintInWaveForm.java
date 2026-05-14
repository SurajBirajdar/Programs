package programs.program.newPrograms.array_2D;
import java.util.*;
public class MatrixPrintInWaveForm {
    public static void main(String[] args) {
        // print matrix in wave form
        int[][] matrix = {{  1,   2,   3,   4},
                {  5,   6,   7,   8},
                {  9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}};
        List<Integer> result = waveFormMatrix(matrix);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> waveFormMatrix(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for(int col=0; col<n; col++) {
            // if even index of column then top to bottom
            if((col& 1) == 0 ) {
                // even - top to bottom
                for(int row=0; row<m; row++) {
                    result.add(matrix[row][col]);
                }
            } else {
                // odd - bottom to up
                for(int row= m-1; row>=0; row--) {
                    result.add(matrix[row][col]);
                }
            }
        }
        return result;
    }
}
