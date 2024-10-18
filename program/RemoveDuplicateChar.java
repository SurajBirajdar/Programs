package programs.program;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateChar {

    public static void main(String[] args) {
        String str = "Programming";
        Set<Character> set = new HashSet<>();
        for(int i=0; i<str.length()-1; i++) {
            set.add(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(Character ch : set) {
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
