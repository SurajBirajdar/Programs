package programs.program.newPrograms.recursion;

public class MinimizeDifference {

    public static int solve(int sum, int[][] mat, int target, int row) {
        // base case
        if(row >= mat.length) {
            return Math.abs(sum- target);
        }
        // 1 case solve karo baki recursion dekh lega
        int mini = Integer.MAX_VALUE;
        for(int num : mat[row]) {
            int ans = solve(sum + num, mat, target, row+1);
            mini = Math.min(ans, mini);
        }
        return mini;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2}, {3,4}};
        int row = 0;
        int sum = 0;
        int target = 5;
        int ans = solve(sum, mat, target, row);
        System.out.println(ans);
    }
}
