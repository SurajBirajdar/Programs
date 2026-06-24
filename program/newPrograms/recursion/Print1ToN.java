package programs.program.newPrograms.recursion;

public class Print1ToN {

    public static void print1ToN(int n, int count) {
        if(count > n) {
            return;
        }

        print1ToN(n, count+1);
        System.out.println(count);
    }
    public static void main(String[] args) {
        int n = 5;
        int count = 1;
        print1ToN(n,count);
    }
}
