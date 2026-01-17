package programs.program.arrayPrograms;

import java.util.*;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        // merge two sorted arrays without using extra space

        // brute force approach
        /* Algorithm:
        Compare biggest element of arr1 with smallest of arr2
        If bigger → swap
        After all swaps → sort both arrays
        */
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        int i= arr1.length -1;
        int j = 0;

        while(i >=0 && j < arr2.length) {
            if(arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        // optimal approach - gap method
    }
}
