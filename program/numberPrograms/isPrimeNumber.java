package programs.program.numberPrograms;

public class isPrimeNumber {
    public static void main(String[] args) {
        int n = 7;
        boolean flag = true;
        //prime number is something which divides by 1 or same number
        for(int i=2; i<n; i++) {
            if(n%i==0){
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println(n + " is a prime number");
        else
            System.out.println(n + " is not prime number");
    }
}
