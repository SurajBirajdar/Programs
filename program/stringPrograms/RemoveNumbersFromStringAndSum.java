package programs.program.stringPrograms;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveNumbersFromStringAndSum {
    public static void main(String[] args) {
        String str = "AA34B678C1";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(str);
        int sum = 0;
        ArrayList<Integer> arrList = new ArrayList<>();
        while(m.find()) {
            arrList.add(Integer.parseInt(m.group()));
            sum = sum + Integer.parseInt(m.group());
        }
        System.out.println(sum);
        System.out.println(arrList);
    }
}
