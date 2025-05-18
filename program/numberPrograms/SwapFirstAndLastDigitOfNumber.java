package programs.program.numberPrograms;

public class SwapFirstAndLastDigitOfNumber {
    public static void main(String[] args) {
        int number = 1234;
        int lastDigit = number % 10;
        int firstDigit = extractFirstDigitOfNum(number);
        

    }

    public static int extractFirstDigitOfNum(int number) {
        while(number > 10) {
            number = number / 10;
        }
        return number;
    }
}
