package programs.program.stringPrograms;

import java.util.Arrays;
import java.util.Comparator;

public class LongLengthPalindromicString {


    public static void main(String[] args) {
        // 1. Find max length palindromic string in array of strings - {“madam”, “level”, “Mohan”, "racecar"};

        //bruteforce approach
        String[] str = {"madam", "level", "Mohan","racecar"};
        String maxLengthPalindrome = "";
        for(int i=0; i<str.length; i++) {
            if(isPalindrome(str[i])) {
                if(str[i].length() > maxLengthPalindrome.length()) {
                    maxLengthPalindrome = str[i];
                }
            }
        }
        System.out.println(maxLengthPalindrome);

        // optimized approach - using streams

        String result = Arrays.stream(str).filter(word -> isPalindrome(word)).max(Comparator.comparingInt(word -> word.length())).orElse("");
        System.out.println(result);
    }

    public static boolean isPalindrome(String str) {
        String reverse= "";
        for(int i= str.length()-1; i>=0; i--) {
            reverse = reverse + str.charAt(i);
        }
        return str.equals(reverse);
    }

}


