package programs.program.stringPrograms;

public class ReverseEachWordInString {
    public static void main(String[] args) {
        String str = "java compiler";
        String[] strArray = str.split(" ");
        String reverseFullString = "";
        for(String word:strArray) {
            String reversedWord = "";
            for(int i=word.length()-1; i>=0; i--) {
                reversedWord = reversedWord + word.charAt(i);
            }
            reverseFullString = reverseFullString + reversedWord +  " " ;
        }
        System.out.println(reverseFullString);
    }
}
