package programs.program.newPrograms.recursion;

public class PrintArray {

    public static void printArray(int[] arr, int i) {
        //B.C
        if(i >= arr.length) {
            return;
        }
        //processing
        System.out.println(arr[i]);
        //recursive relation
        printArray(arr, i+1);

    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60};
        int i = 0;
        printArray(arr,i);
    }
}
