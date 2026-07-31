package programs.program.newPrograms.stringPrograms;

public class RemovaAllAdajacentDuplicates {
    public static String removeAllAdjacentDuplicates(String str) {
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ans.length()> 0 && ans.charAt(ans.length()-1) == ch) {
                ans.deleteCharAt(ans.length()-1);
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(removeAllAdjacentDuplicates(str));
    }
}
