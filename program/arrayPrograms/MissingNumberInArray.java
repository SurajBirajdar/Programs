package programs.program.arrayPrograms;

public class MissingNumberInArray {

    public static void main(String[] args) {
        int [] arr = {1,3,5,4};
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum = sum + arr[i];
        }

        System.out.println("sum of array elements is: " + sum);
        int n1 = 5;
        int actualSum = n1*(n1+1)/2;
        System.out.println("Actual sum : " + actualSum);

        int missingNum = actualSum - sum;
        System.out.println("missingNumber is: " + missingNum);
    }
}
