package programs.program.newPrograms.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesOfString {

    static void subsequencesOfString(String s, int index, StringBuilder output, List<String> ans) {
        // Base case
        if(index >= s.length()) {
            ans.add(output.toString());
            return;
        }
        // include
        char ch = s.charAt(index);
        output.append(ch);
        subsequencesOfString(s, index+1, output, ans);
        // exclude
        output.deleteCharAt(output.length() - 1);
        subsequencesOfString(s, index+1, output, ans);
    }

    public static void main(String[] args) {
        String s = "abc";
        int index = 0;
        StringBuilder output = new StringBuilder();
        List<String> ans = new ArrayList<>();
        subsequencesOfString(s, index, output, ans);
        System.out.println(ans);
        System.out.println(ans.size());
    }
}
