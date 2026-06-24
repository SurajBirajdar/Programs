package programs.program.newPrograms.recursion;

public class PrintMyName {

    // print my name 10 times
    public static void  printMyName(int count) {

        if(count == 0) {
            return;
        }
        System.out.println("Suraj");
        printMyName(count - 1);
    }

    public static void main(String[] args) {
        printMyName(10);
    }
}
