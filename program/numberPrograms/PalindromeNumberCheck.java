package programs.program.numberPrograms;

public class PalindromeNumberCheck {
    public static void main(String[] args) {
        int n = 122;
        int temp = n;
        // reverse also it should be same number to become palindrome ie, 121 in reverse is same
        int remainder;
        int reverseNumber = 0;
        while(n>0){
            remainder = n%10;
            n = n/10;
            reverseNumber = (reverseNumber*10) + remainder;
        }

        if(temp == reverseNumber)
            System.out.println(temp + " is palindrome number");
        else
            System.out.println(temp + " is not palindrome number");




    }
}
