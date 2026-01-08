package programs.program.stringPrograms;

import java.util.HashSet;
import java.util.Set;

public class GetDuplicateCharactersFromString {
    public static void main(String[] args) {
        // give duplicate characters from string
        String str = "asunajja";
        char[] ch = str.toCharArray();
        Set<Character> set = new HashSet<>();
        Set<Character> set2= new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ch.length; i++) {
            if(set.add(ch[i]) == false) {
                set2.add(ch[i]);
            } else {
                set.add(ch[i]);
            }
        }
        System.out.println(set2);
    }
}
