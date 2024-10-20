package programs.program.numberPrograms;

public class FactorialNumber {
    public static void main(String[] args) {
        int n = 4;

        //using recursion
        System.out.println(factorial(n));
    }

    public static int factorial(int n){

        if(n == 1)
            return 1;
        else
            return n * factorial(n-1);
    }
}
