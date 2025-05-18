package programs.program.YT;

public class LowerUpperCase {

    public static String upperLowerConvert(String input) {
        char arr[] = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length;i++) {
            if(Character.isLowerCase(arr[i])) {
                sb.append(Character.toUpperCase(arr[i]));
            } else if(Character.isUpperCase(arr[i])) {
                sb.append(Character.toLowerCase(arr[i]));
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String str = "Hello World";
        String resultValue = upperLowerConvert(str);
        System.out.println("Result value is: " + resultValue);

    }

}
