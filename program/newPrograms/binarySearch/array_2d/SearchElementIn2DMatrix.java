package programs.program.newPrograms.binarySearch.array_2d;

public class SearchElementIn2DMatrix {

    public static int searchIn2DMatrix(int[][] arr, int target) {
        int totalRow = arr.length;
        int totalCol = arr[0].length;
        int s = 0;
        int n = totalRow * totalCol;
        int e = n - 1;
        while(s <= e) {
            int mid = s + (e - s)/2;
            int rowIndex = mid / totalCol;
            int colIndex = mid % totalCol;
            if(arr[rowIndex][colIndex] == target) {
                return mid;
            } else if(arr[rowIndex][colIndex] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = { {1,3,5,7},
                             {10,11,16,20},
                             {23,30,34,60}

        };
        int target = 5;
        System.out.println(searchIn2DMatrix(arr, target));
    }
}
