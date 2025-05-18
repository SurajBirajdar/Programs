package programs.program.YT;

public class AllSubStringOfString {

    String value = "abc";
    // a ab abc b bc c

    public static void subString(String inputValue) {
        int lengthOfString = inputValue.length();
        for(int startIndex=0; startIndex<lengthOfString; startIndex++) {
            for(int endIndex=startIndex+1; endIndex<=lengthOfString; endIndex++) {
                String value = inputValue.substring(startIndex,endIndex) + " ";
                System.out.print(value);
            }
        }
    }

    public static void main(String[] args) {
        subString("abc");
    }

}
