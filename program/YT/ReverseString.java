package programs.program.YT;

public class ReverseString {
    public static void main(String[] args) {
        String name = "rahul";
        int len = name.length();
        String result = "";
        for(int i= len -1; i>=0; i--) {
            result = result + name.charAt(i);
        }

        System.out.println(result);
    }
}
