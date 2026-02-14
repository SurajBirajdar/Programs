package programs.program.newPrograms.numberPrograms;

public class fibonacciSeriesWithoutThirdVariable {
    public static void main(String[] args) {
        //fibonacci series without using third variable
        // 0 1  1 2 3 5 8 13 21

        int a = 0;
        int b = 1;
        System.out.print(a + " " + b + " ");
        for(int i=0; i<7; i++) {
            b = a + b;
            a = b - a;
            System.out.print(b + " ");
        }
    }
}
