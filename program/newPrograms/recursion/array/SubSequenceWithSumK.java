package programs.program.newPrograms.recursion.array;

public class SubSequenceWithSumK {
    static boolean solve(int[] arr, int index, int sum, int k) {
        //base case
        if(index >= arr.length) {
            if(sum == k) {
                return true;
            } else {
                return false;
            }
        }
        //include-exclude pattern
        boolean includeAns = solve(arr, index+1, sum+arr[index] , k);
        boolean excludeAns = solve(arr, index+1, sum, k);

        return includeAns || excludeAns;
    }
    public static void main(String[] args) {
        //subsequence with sum k
        int[] arr = {1,2,1,3,5};
        int index = 0;
        int sum = 0;
        int k = 9;
        boolean ans = solve(arr, index, sum, k);
        System.out.println(ans);

    }
}
