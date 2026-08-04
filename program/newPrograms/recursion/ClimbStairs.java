package programs.program.newPrograms.recursion;

public class ClimbStairs {
    public static int climbStair(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        // number of ways to reach nth stair = number of ways to reach (n-1) stair + number of ways to reach (n-2) stair
        int ans = climbStair(n-1) + climbStair(n-2);
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStair(n));
    }
}
