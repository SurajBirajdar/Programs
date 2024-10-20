package programs.program.arrayPrograms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {23, 12, 89, 100, 11};
        int temp;
        int length = arr.length;
        for(int i=0; i<length-1; i++){
            for(int j=0; j<length-1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
