package programs.program.stringPrograms;

public class ReverseEachWordInStr {
    public static <StringBulder> void main(String[] args) {
        String str = "my name is suraj";
        String[] strArray = str.split(" ");
        String reverseFullString = "";
        for(int i=0; i<strArray.length; i++) {
            String reverseString = "";
            for(int j=strArray[i].length()-1; j>=0; j--) {
                reverseString = reverseString + strArray[i].charAt(j);
            }
            reverseFullString = reverseFullString + reverseString + " ";
        }
        System.out.println(reverseFullString);

    }
}
