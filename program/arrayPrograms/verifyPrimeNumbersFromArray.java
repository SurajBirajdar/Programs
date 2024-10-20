package programs.program.arrayPrograms;

public class verifyPrimeNumbersFromArray {
    public static void main(String[] args) {
        int [] arr = {7, 28, 13, 5, 12, 99, 19};
        for(int i=0; i<arr.length; i++){
            if(verifyPrime(arr[i])){
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static boolean verifyPrime(int num){
        //prime number gets divide by itself or 1, so now I want to check numbers in between 1 and that number whether they gets divide and if reminder is 0 then that is not prime number
        for(int i=2; i<num; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
