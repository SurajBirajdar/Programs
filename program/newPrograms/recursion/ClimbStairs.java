package programs.program.newPrograms.recursion;

public class ClimbStairs {
    public static int climbStair(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int ans = climbStair(n-1) + climbStair(n-2);
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStair(n));
    }
}
