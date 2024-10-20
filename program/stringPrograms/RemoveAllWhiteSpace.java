package programs.program.stringPrograms;

public class RemoveAllWhiteSpace {

    public static void main(String[] args) {
        String str = "j    v   v  a";

        str = str.replaceAll("\\s","");
        System.out.println(str);
    }
}
