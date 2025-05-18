package programs.program.YT;

public class SumOfWholeNumbersFromString {

    public static void main(String[] args) {
        String str = "123str45";
        //output = 123 + 456 = 579 // 23ft45hj78
        int result = 0;
        for(String number : str.split("\\D+")) {
            result = result + Integer.parseInt(number);
        }
        System.out.println("Final result is: " + result);
    }





}
