package programs.program.stringPrograms;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateChar {

    public static void main(String[] args) {
        String str = "Programming";
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for(int i=0; i<str.length(); i++) {
            set.add(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(Character ch : set) {
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
