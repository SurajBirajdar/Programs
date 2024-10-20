package programs.program.collectionPrograms;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortedMapValues {
    public static void main(String[] args) {
        Map<String,Integer> testMap = new HashMap<>();
        testMap.put("l",1);
        testMap.put("b",8);
        testMap.put("m",5);
        testMap.put("k",1);

        java.util.LinkedHashMap finalMap = testMap.entrySet().stream().sorted((t1,t2)-> t1.getValue().compareTo(t2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(t1,t2)->t1,java.util.LinkedHashMap::new));

        System.out.println(finalMap);
    }
}
