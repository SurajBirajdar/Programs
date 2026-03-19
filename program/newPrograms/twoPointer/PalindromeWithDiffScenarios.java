package programs.program.newPrograms.twoPointer;

public class PalindromeWithDiffScenarios {


    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        //str = str.replaceAll(" ", "");
        str = str.replaceAll("[^a-zA-Z]", "");
        char[] charArray = str.toCharArray();
        for(int i=0; i<charArray.length; i++) {
            if(Character.isUpperCase(charArray[i])) {
                charArray[i] = Character.toLowerCase(charArray[i]);
            }
        }
        String newStr = new String(charArray);
        System.out.println(newStr);
        System.out.println(palindromecheck(newStr));
    }

    public static boolean palindromecheck(String str) {
        char[] ch = str.toCharArray();
        int left = 0;
        int right = ch.length-1;
        while(left<right) {
            if(ch[left] == ch[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
