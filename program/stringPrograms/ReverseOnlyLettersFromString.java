package programs.program.stringPrograms;

import java.util.Arrays;

public class ReverseOnlyLettersFromString {
    public static void main(String[] args) {
        String str = "a8b-cd123";
        reverseLettersOnly(str);
    }
    public static void reverseLettersOnly(String str){
        //ab-cd
        //dc-ba
        int i = 0;
        int j = str.length()-1;
        char[] ch = str.toCharArray();
        char temp;
        while(i<=j){
            if(!Character.isLetter(ch[i])) {
                i++;
            } else if(!Character.isLetter(ch[j])) {
                j--;
            } else {
                temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : ch) {
            sb.append(c);
        }
        System.out.println(sb);


    }
}
