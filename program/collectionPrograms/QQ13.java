package programs.program.collectionPrograms;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class QQ13 {
    public static void main(String[] args) {
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(1, "b");
        testMap.put(5, "e");
        testMap.put(9, "d");
        testMap.put(12, "c");
        testMap.put(7, "a");

//        java.util.LinkedHashMap finalMap = testMap.entrySet().stream().sorted((t1,t2)-> t1.getValue().compareTo(t2.getValue()))
//                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(t1, t2)->t1,java.util.LinkedHashMap::new));
//        TreeMap t = new TreeMap(testMap);











        LinkedHashMap map = testMap.entrySet().stream().sorted((t1,t2)-> t1.getValue().compareTo(t2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(t1,t2)->t1,LinkedHashMap::new));
        System.out.println(map);
    }
}
