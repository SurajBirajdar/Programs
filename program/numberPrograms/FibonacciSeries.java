package programs.program.numberPrograms;

public class FibonacciSeries {
    public static void main(String[] args) {
        //0 1 1 2 3 5 8 13 21 34
        //    a b c
        //here we are changing values of a and b in a loop by swapping and doing addition of previous two elements

        int a = 0;
        int b = 1;
        int c = 0;
        System.out.print(a + " " + b);
        for(int i=1; i<10; i++){
            c = a + b;
            System.out.print(" " + c + " ");
            a = b;
            b = c;
        }
    }
}
