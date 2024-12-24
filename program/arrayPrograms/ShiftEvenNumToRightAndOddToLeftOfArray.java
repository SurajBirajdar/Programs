package programs.program.arrayPrograms;

import java.util.Arrays;

public class ShiftEvenNumToRightAndOddToLeftOfArray {
    public static void main(String[] args) {
        int arr[] = {22, 56, 33, 20, 77, 99, 7, 12};
        shiftEvenNumsToLeftOfArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shiftEvenNumsToLeftOfArray(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            //if left side element is already even, then no need to swap, just increment left pointer
            if(arr[left] % 2 == 0) {
                left++;
            }
            // if right side element is already odd then no need to swap, just decrement right pointer
            else if (arr[right] % 2 != 0){
                right--;
            }
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
}
