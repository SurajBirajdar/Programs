package programs.program.arrayPrograms;

import java.util.Arrays;

public class MoveAllNegativeNumbersToLeftOfArray {

    public static void main(String[] args) {
        int arr[] = {2,-3,5,-8,-4,7};
        moveAllNegativeNumToLeftOfArray(arr);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void moveAllNegativeNumToLeftOfArray(int arr[]) {
        int l = 0;
        int r = arr.length - 1;
        while(l<=r) {
            if(arr[l] > 0 && arr[r] > 0) {
                r--;
            } else if(arr[l] > 0 && arr[r] < 0) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
//                swap(arr,arr[l],arr[r]);
                l++;
                r--;
            }
            else if( arr[l] < 0 && arr[r] < 0) {
                l++;
            }
            else {
                l++;
                r--;
            }
        }
    }

    public static void swap(int arr[],int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
