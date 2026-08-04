package programs.program.newPrograms.recursion.binarySearch;

public class BinarySearchRecursive {

    public static int solve(int[] arr, int target, int s, int e) {
        // base case
        if(s > e) {
            return -1;
        }
        // processing work
        int mid = s + (e-s)/2;
        if(arr[mid] == target) return mid;
        else if(arr[mid] > target) e = mid - 1;
        else if(arr[mid] < target) s = mid + 1;

        //recursive call
        return solve(arr, target, s, e);

    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
        int target = 80;
        int s = 0;
        int e = arr.length -1;
        int ans = solve(arr, target, s, e);
        System.out.println(ans);
    }
}
