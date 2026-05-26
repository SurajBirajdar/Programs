package programs.program.newPrograms.binarySearch;

public class PaintersPartition {
    public static void main(String[] args) {
        int[] arr = {5,10,30,20,15};
        int k = 3;
        System.out.println(paintersPartition(arr, 3));
    }

    public static boolean isValidAns(int[] arr, int k, int mid) {
        int painterCount = 1;
        int boardLength = 0;
        for(int i=0; i<arr.length; i++) {
            if(boardLength + arr[i] <= mid ) {
                boardLength = boardLength + arr[i];
            } else {
                painterCount++;
                if(painterCount > k || boardLength > mid) {
                    return false;
                } else {
                    boardLength = 0;
                    boardLength = boardLength + arr[i];
                }
            }
        }
        return true;
    }

    public static int paintersPartition(int[] arr, int k) {
        // k - number of painters
        // need to sum of all elememts of array to get end index
        int s = 0;
        int sum =0;
        for(int i=0; i<arr.length; i++) {
            sum = sum + arr[i];
        }
        int e = sum;
        int ans = 0;
        while(s<=e) {
            int mid = s + (e-s)/2;

            if(isValidAns(arr, k, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}
