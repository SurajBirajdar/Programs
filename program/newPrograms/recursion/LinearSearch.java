package programs.program.newPrograms.recursion;

public class LinearSearch {

    public static int linearSearch(int[] arr, int i, int target) {
        // Base condition
        if(i >= arr.length) {
            return -1;
        }
        // processing
        if(arr[i] == target) {
            return i;
        }
        // recursive consition
        int ans = linearSearch(arr, i+1, target);
        return  ans;
    }

    public static void main(String[] args) {
        int[] arr = {20, 30, 56, 70};
        int i = 0;
        int target = 70;
        int ans = linearSearch(arr, i, target);
        System.out.println(ans);

    }
}
