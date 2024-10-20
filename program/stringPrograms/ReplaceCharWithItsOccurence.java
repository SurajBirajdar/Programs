package programs.program.stringPrograms;

public class ReplaceCharWithItsOccurence {

    public static void main(String[] args) {
        String str = "opentext";
        char charToReplace = 't';

        if(str.indexOf(charToReplace) == -1) {
            System.out.println("Given character not present in string");
            System.exit(0);
        }
        int cnt = 1;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == charToReplace) {
                str = str.replaceFirst(String.valueOf(charToReplace),String.valueOf(cnt));
                cnt++;
            }
        }
        System.out.println(str);

        /*
        int cnt = 1;
        //now character present in string but I want to replace t with its occurrence
        char[] charArray = str.toCharArray();
        for(int i=0; i<charArray.length; i++) {
            if(charArray[i] == charToReplace) {
                charArray[i] = String.valueOf(cnt).charAt(0);
                cnt++;
            }
        }
        System.out.println(Arrays.toString(charArray)); */


    }
}
