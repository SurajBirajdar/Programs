package programs.program.newPrograms.stringPrograms;
import java.util.*;

public class AllStringPermutations {
    public static void solve(String s, String output, List<String> ans) {
        // base case
        // if input string becomes empty, it means permutation/output string is ready, ans wali list me store karlo and return
        if(s.isEmpty()) {
            ans.add(new String(output));
            return;
        }
        // hr character ko current position pr try keke dekho
        // and baki recursion ko dedo
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            String remString = s.substring(0, i) + s.substring(i+1);
            // recursion use karo
            solve(remString, output + ch, ans);
        }
    }
    public static void main(String[] args) {
        String s = "abc";
        List<String> ans = new ArrayList<>();
        String output = "";
        solve(s, output, ans);
        System.out.println(ans);
    }
}
