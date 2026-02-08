package programs.program.slidingWindow.stringPrograms;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringLength {
    public static void main(String[] args) {
        //2. Longest substring length from a string without duplicate characters- input - abcabca output - abc
        //brute force approach
        int longestSubStringLength = 0;
        String str = "abcdab";
         for(int i=0; i<str.length() ; i++) {
             Set<Character> set = new HashSet<>();
             for(int j=i; j<str.length(); j++) {
                 if(set.contains(str.charAt(j))) {
                     break;
                 }
                 set.add(str.charAt(j));
                 if(set.size() > longestSubStringLength) {
                     longestSubStringLength = set.size();
                 }
             }
         }
         System.out.println(longestSubStringLength);

        //=======================================================//
        //optimized approach - using sliding window and hashmap
        int maxLength = 0;
        int left =0;
        Set<Character> set = new HashSet<>();
        for(int right=0; right<str.length(); right++) {
            //if duplicate found , shrink window from left using while loop
            while(set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }
            // add current character to window
            set.add(str.charAt(right));
            // update maxLength using simple condition
            if(set.size() > maxLength) {
                maxLength = set.size();
            }
        }
        System.out.println(maxLength);

        //========================================================//
        // optimized approach - using sliding window and hashset
        String str1 = "abcabcbb";
        int maxLength1 = 0;
        int left1 = 0;
        Set<Character> set1 = new HashSet<>();
        //find longest substring length of given string
        for(int i=0; i<str1.length(); i++) {

            if(set1.contains(str1.charAt(i))) {
                set1.remove(str1.charAt(left1));
                left1++;
            }
            set1.add(str1.charAt(i));
            if(set1.size() > maxLength1) {
                maxLength1 = set1.size();
            }
        }
        System.out.println(maxLength1);
    }
}

