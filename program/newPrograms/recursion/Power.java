package programs.program.newPrograms.recursion;

public class Power {

    public static int power(int a, int b) {
        if(b == 0) return 1;
        return a * power(a, b-1);
    }

    // another approach
    public static int pow(int a, int b) {
        if(b == 0) return 1;
        int call = pow(a,b/2);
        if(b%2 == 0) return call * call;
        else return a * call * call;
    }

    static void main() {
        int a = 2;
        int b = 3;
        int ans = pow(a,b);
        System.out.println(ans);
    }
}
