package programs.program.newPrograms.recursion.string;

public class ReverseString {

    public static void reverseString(char[] charArray, int i, int j) {
        if(i > j) {
            System.out.println(new String(charArray));
            return;
        }

        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        i++;
        j--;
        reverseString(charArray, i, j);
    }
    public static void main(String[] args) {
        String str = "abcax";
        int i = 0;
        int j = str.length()-1;
        char[] charArray = str.toCharArray();
        reverseString(charArray, i, j);

    }
}


