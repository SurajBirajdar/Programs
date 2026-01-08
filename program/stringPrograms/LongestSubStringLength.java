package programs.program.stringPrograms;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringLength {
    public static void main(String[] args) {
        //2. Longest substring length from a string without duplicate characters- input - abcabca output - abc
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
    }
    }
