package programs.program.newPrograms.recursion.string;

public class RemoveOccOfSpecificChar {

    public static String remove(String str, int index, char charToRemove) {
        if(index == str.length()) {
            return "";
        }
        String smallAns = remove(str, index+1, charToRemove);
        char ch = str.charAt(index);
        if(ch != charToRemove) {
            return ch + smallAns;
        } else {
            return smallAns;
        }
    }

    public static void main(String[] args) {
        String str = "abcax";
        int index = 0;
        char charToRemove = 'a';
        String ans = remove(str, index, charToRemove);
        System.out.println(ans);
    }
}
