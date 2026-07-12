package programs.program.newPrograms.recursion;

public class PartitionEqualSubsetSum {

    static boolean solve(int[] arr, int target, int index) {
        if(target == 0) {
            return true;
        }
        if(target < 0) {
            return false;
        }
        if(index >= arr.length) {
            return false;
        }
        // include exclude pattern
        boolean includeKaAns = solve(arr, target-arr[index], index+1);
        boolean excludeKaAns = solve(arr, target, index+1);
        return includeKaAns || excludeKaAns;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,11,7};
        int index = 0;
        int sum = 0;
        for(int num : arr) {
            sum = sum + num;
        }
        if((sum & 1) == 1) {
            System.out.println("False");
            System.exit(0);
        }
        int target = sum/2;
        boolean ans = solve(arr, target, index);
        System.out.println(ans);
    }

}
