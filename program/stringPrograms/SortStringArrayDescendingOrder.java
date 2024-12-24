package programs.program.stringPrograms;

import java.util.Arrays;

public class SortStringArrayDescendingOrder {
    public static void main(String[] args) {
        String arr[] = {"suraj","lokesh","shankar","mayur"};
        for(int i=0; i<arr.length-1;i++) {
            for(int j=0; j<arr.length-1; j++) {
                if(arr[j].compareTo(arr[j+1]) < 0) {
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
