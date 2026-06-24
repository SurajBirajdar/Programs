package programs.program.newPrograms.recursion;

public class MaxElementInArray {

    public static void maxElementInArray(int[] arr, int i, int maxi) {
        //Base case
        if(i>=arr.length) {
            System.out.println("Maximum value is: " + maxi);
            return;
        }
        //processing
        if(arr[i] > maxi) {
            maxi = arr[i];
        }
        //Recursive call
        maxElementInArray(arr, i + 1, maxi);
    }

    public static void main(String[] args) {
        int[] arr = {40,10,30,50,60};
        int i = 0;
        int maxi = Integer.MIN_VALUE;
        maxElementInArray(arr,i,maxi);
    }
}
