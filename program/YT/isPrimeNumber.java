package programs.program.YT;

public class isPrimeNumber {
    public static void isPrime(int number) {
        boolean flag = true;
        //if number divides by 1 or by the same number then it is prime number
        for(int i=2; i<number; i++) {
            if(number%i==0) {
                flag = false;
                break;
            }
        }
        if(flag) {
            System.out.println("Given number " + number + " is prime number");
        } else {
            System.out.println("Given number " + number + " is not a prime number");
        }
    }

    public static void main(String[] args) {
        isPrime(10);

    }

}


