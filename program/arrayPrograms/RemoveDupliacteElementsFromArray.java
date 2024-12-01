package programs.program.arrayPrograms;

public class RemoveDupliacteElementsFromArray {
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,3,4};
        int j = removeDuplicateElementsFromArray(arr);
        System.out.println(j);
        for(int i=0; i<=j; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static int removeDuplicateElementsFromArray(int arr[]){

        //1,2,2,3,3,4
        int j = 0;
        for(int i=0; i<arr.length-1; i++) { //6-1 =5 less than 5 means till 4
            if(arr[i] != arr[i+1]) {
                arr[j] = arr[i];
                j++;
            }
        }
        arr[j] = arr[arr.length-1];
        return j;
    }
}
