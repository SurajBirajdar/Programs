package programs.program.stringPrograms;

public class AllSubstringOfString {
    public static void allSubString(String inputString){
        int length = inputString.length();
        for(int startIndex=0; startIndex<length; startIndex++) {
            for(int endIndex=startIndex+1; endIndex<=length; endIndex++){
                System.out.println(inputString.substring(startIndex,endIndex));
            }
        }
    }
    public static void main(String[] args) {
        allSubString("abc");

    }
}

