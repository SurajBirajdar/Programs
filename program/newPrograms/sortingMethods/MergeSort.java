package programs.program.newPrograms.sortingMethods;

public class MergeSort {

    public static void merge(int[] arr, int s, int e, int mid) {
        int leftArrLen = mid -s +1;
        int rightArrLen = e - mid;
        int[] leftArray = new int[leftArrLen];
        int[] rightArray = new int[rightArrLen];

        int k = s;
        for(int i=0; i<leftArrLen; i++) {
            leftArray[i] = arr[k];
            k++;
        }

        for(int j=0; j<rightArrLen; j++) {
            rightArray[j] = arr[k];
            k++;
        }

        k = s;
        int i = 0;
        int j = 0;
        while(i<leftArrLen && j<rightArrLen) {
            if(leftArray[i] < rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
                k++;
            } else {
                arr[k] = rightArray[j];
                j++;
                k++;
            }
        }

        // if leftarray is consumed and right array elements are remaining then fill those elements in output array as it is
        while(j<rightArrLen) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
        // if rightarray is consumed fully and leftarray are remaining then fill those elements in output array as it is
        while(i<leftArrLen) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

    }

    public static void mergeSort(int[] arr, int s, int e) {
        // base case
        if(s >= e) return;
        // find mid of array
        int mid = s + (e-s)/2;
        // sort left part of array
        mergeSort(arr, s, mid);
        // sort right part of array
        mergeSort(arr, mid+1, e);
        // merge two sorted arrays
        merge(arr, s,e, mid);
    }
    public static void main(String[] args) {
        int[] arr = {40,10,50,20,60,30,70};
        int s = 0;
        int e = arr.length -1;
        mergeSort(arr,s,e);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }




}
