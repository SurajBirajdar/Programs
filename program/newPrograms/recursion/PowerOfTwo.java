package programs.program.newPrograms.recursion;

public class PowerOfTwo {

    public static int powerOfTwo(int n) {
        // base case
        if(n == 0) {
            return 1;
        }
        return 2 * powerOfTwo(n-1);
    }
    public static void main(String[] args) {
        int n = 5;
        int ans = powerOfTwo(n);
        System.out.println(ans);
    }
}
