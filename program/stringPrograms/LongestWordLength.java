package programs.program.stringPrograms;
import java.lang.*;
public class LongestWordLength {
    public static void main(String[] args) {
        String str = "My name is Suraj";
        int maxLength = 0;
        String[] strArr = str.split(" ");
        for(int i=0; i<strArr.length; i++){
            if(strArr[i].length() > maxLength) {
                maxLength = strArr[i].length();
            }
        }
        System.out.println(maxLength);
    }
}
