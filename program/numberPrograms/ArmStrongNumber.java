package programs.program.numberPrograms;

public class ArmStrongNumber {
    public static void main(String[] args) {
        int n = 100;
        // 1*1*1 + 5*5*5 + 3*3*3

        int temp = n;
        int sum = 0;
        int remainder = 0;
        int noOfDigits = noOfDigits(n);
        System.out.println(noOfDigits);
        while(n>0) {
            remainder = n%10;
            n = n/10;
            sum = (int) (sum + Math.pow(remainder,noOfDigits));
        }
        if(temp == sum)
            System.out.println(temp + " is a armstrong number");
        else
            System.out.println(temp + " is not armstrong number");

    }
    public static int noOfDigits(int n) {
        int cnt = 0;
        while(n>0) {
            n = n/10;
            cnt++;
        }
        return cnt;
    }
}
