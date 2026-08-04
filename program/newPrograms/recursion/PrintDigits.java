package programs.program.newPrograms.recursion;

public class PrintDigits {
    static void printDigits(int num) {
        //base case
        if(num == 0) {
            return;
        }
        // processing work
        int digit = num % 10;
        num = num / 10;
        // recursive call
        printDigits(num);
        System.out.print(digit + " ");
    }
    static void main() {
        printDigits(137);
    }
}
