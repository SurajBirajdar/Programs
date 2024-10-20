package programs.program.stringPrograms;

public class RemoveSpecialChar {

    public static void main(String[] args) {
        String str = "@ja*(va^&";
        str = str.replaceAll("[^a-zA-Z0-9]","");
        System.out.println(str);

    }
}
