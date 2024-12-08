package programs.program.arrayPrograms;

public class SecondLargestElementArray {
    public static void main(String[] args) {

        //Given an array from 10,20,30 to n , find the second largest element in array

        int arr[]=new int[] {10,20,30};
        int largest = Integer.MIN_VALUE;
        int second_largest = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;++i)
        {
            if(arr[i]>largest)
            {
                second_largest=largest;
                largest=arr[i];
            }
            else if(arr[i]>second_largest && arr[i]!=largest)
            {
                second_largest = arr[i];
            }
        }

        if(second_largest == Integer.MIN_VALUE)
        {
            System.out.println("There is no second largest element present");
        }

        else {
            System.out.println("Second largest element is ="+second_largest);
        }

    }
}
