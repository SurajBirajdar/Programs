package programs.program.newPrograms.recursion;

public class JumpGame {
    static boolean solve(int[] nums, int index) {
        // base case
        if(index == nums.length-1) {
            return true;
        }
        if(index >= nums.length) {
            return false;
        }
        if(nums[index] == 0) {
            return false;
        }
        // 1 case solve karo baki recursion sambhal lega
        boolean overallAns = false;
        for(int jump =1; jump<=nums[index]; jump++) {
            boolean recAns = solve(nums, index + jump);
            overallAns = recAns || overallAns;
        }
        return  overallAns;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        //int[] nums = {2,3,1,1,4};
        int index = 0;
        boolean ans =solve(nums, index);
        System.out.println(ans);

    }
}
