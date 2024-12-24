package programs.program.arrayPrograms;

public class SortArrayOfZeroOneTwo {
    public static void main(String[] args) {
        int arr[] = {1,2,0,1,1,2,0,0,2};
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                zeroCount++;
            }
            else if(arr[i] == 1) {
                oneCount++;
            }
            else if(arr[i] == 2) {
                twoCount++;
            }
        }
        System.out.println(zeroCount);
        System.out.println(oneCount);
        System.out.println(twoCount);
        for(int i=0; i<arr.length;i++) {
            if(zeroCount > 0) {
                arr[i] = 0;
                zeroCount--;
            }
            else if(oneCount > 0) {
                arr[i] = 1;
                oneCount--;
            }
            else if(twoCount > 0) {
                arr[i] = 2;
                twoCount--;
            }
        }

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
