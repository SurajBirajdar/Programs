package programs.program.arrayPrograms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {23, 67, 12, 89};
        int len = arr.length;
        int temp;
        for(int i=0; i<len-1; i++) { // number of passes
            for(int j=0; j<len-1; j++) {
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
