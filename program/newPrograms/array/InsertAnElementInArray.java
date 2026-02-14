package programs.program.newPrograms.array;

import java.util.Arrays;

public class InsertAnElementInArray {
    public static void main(String[] args) {
        // insert an element in array
        int[] arr = {10, 30, 50, 90};
        int[] newArr = new int[5];

        // insert 40 at index 2

        for(int i=0; i<arr.length; i++) {
            newArr[i] = arr[i];
        }

        for(int i=0; i<newArr.length; i++) {
            if(i == 2) {
                for(int j=newArr.length -1; j>i; j--) {
                    newArr[j] = newArr[j-1];
                }
                newArr[i] = 40;
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
}
