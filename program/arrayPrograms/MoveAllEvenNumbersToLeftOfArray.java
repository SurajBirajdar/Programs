package programs.program.arrayPrograms;

import java.util.Arrays;

public class MoveAllEvenNumbersToLeftOfArray {

    public static void main(String[] args) {
        int arr[] = {2,1,3,7,8,10};
        moveAllEvenNumbersToLeftOfArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveAllEvenNumbersToLeftOfArray(int arr[]) {
        //Two pointer approach
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            if(isEven(arr[left])) {
                left++;
            } else if(!isEven(arr[right])) {
                right--;
            }
            else if(!isEven(arr[left]) && isEven(arr[right])) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else {
                left++;
                right--;
            }
        }
    }

    public static boolean isEven(int number) {
        boolean flag = false;
        if(number%2 == 0) {
            return true;
        }
        return false;
    }
}
