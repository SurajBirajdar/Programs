package programs.program.newPrograms.recursion;

public class MinElementInArray {

    public static void minElementInArray(int[] arr, int i, int mini) {
        // base case
        if(i >= arr.length) {
            System.out.println("Mini Element in array: " + mini);
            return;
        }
        // processing
        if(arr[i] < mini) {
            mini = arr[i];
        }
        //recursive condition
        minElementInArray(arr, i + 1, mini);
    }

    public static void main(String[] args) {
        int[] arr = {30,10,20,60,56};
        int i = 0;
        int mini = Integer.MAX_VALUE;
        minElementInArray(arr, i, mini);

    }

}


