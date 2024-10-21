package programs.program.stringPrograms;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatChar {
    public static void main(String[] args) {
        String str = "MBAABCD";
        //Approach-1
        for(int i=0; i<str.length(); i++){
            boolean flag = true;
            for(int j=0; j<str.length(); j++) {
                if(i!=j && str.charAt(i) == str.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println(str.charAt(i));
                break;
            }
        }

        //String str = "AABCDD";
        //Approach-2
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch,map.get(ch)+1);
            } else {
                map.put(ch,1);
            }
        }
        System.out.println(map);
        
        //Traversing through map and checking for key which having value as 1
        char nonRepeatChar = 0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                nonRepeatChar = entry.getKey();
                break;
            }
        }
        System.out.println(nonRepeatChar);

        
    }
}
