package programs.program.arrayPrograms;

import java.util.*;
public class MoveZeroesToEndWithOrderMaintainOfNonZero {
    public static void main(String[] args) {
        // Write a Java program to move all 0s to the end of the array, while keeping the order of non-zero elements the same.
        /*int[] arr = {0,1,0,3,12};
        int length = arr.length;
        List<Integer> newArr = new ArrayList<>();
        int count=1;
        for(int i=0; i<length; i++) {
            if(arr[i] != 0) {
                newArr.add(arr[i]);
                count++;
            }
        }
        while(count <= length) {
            newArr.add(0);
            count++;
        }
        System.out.println(newArr.toString());
        */

        //=====================Another approach=========================//
        // Write a Java program to move all 0s to the end of the array, while keeping the order of non-zero elements the same.
        int[] arr = {0,1,0,3,12};
        int length = arr.length;
        int count=0;
        for(int i=0; i<length; i++) {
            if(arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }
        while(count < length) {
            arr[count] = 0;
            count++;
        }
        System.out.println(Arrays.toString(arr));

    }
}
