package programs.program.newPrograms.array_2D;

public class SearchElementIn2DRowColSortedArr {

    public static boolean searchIn2DRowColSortedArr(int[][] arr, int target) {
        int rowCount = arr.length;
        int colCount = arr[0].length;
        int row = 0;
        int col = colCount - 1;

        while(row < rowCount && col >= 0) {
            if(arr[row][col] == target) {
                return true;
            } else if(arr[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    static void main() {
        int[][] arr = {{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};

        int target = 13;
        System.out.println(searchIn2DRowColSortedArr(arr, target));
    }
}
