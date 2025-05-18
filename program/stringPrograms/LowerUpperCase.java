package programs.program.stringPrograms;

public class LowerUpperCase {

    public static String lowerUpperCase(String input) {
        char ch[] = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ch.length; i++) {
            if(Character.isLowerCase(ch[i])) {
                sb.append(Character.toUpperCase(ch[i]));
            } else if(Character.isUpperCase(ch[i])) {
                sb.append(Character.toLowerCase(ch[i]));
            } else {
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String value = lowerUpperCase("Hello World");
        System.out.println(value);
    }

}
