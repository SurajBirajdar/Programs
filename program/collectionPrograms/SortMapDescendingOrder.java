package programs.program.collectionPrograms;

import java.util.*;

public class SortMapDescendingOrder {
    public static void main(String[] args) {

        HashMap<String,Integer> map = new HashMap<>();
        map.put("a",7);
        map.put("m",9);
        map.put("r", 1);
        map.put("q",10);

        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(map.entrySet());
        //sort by value
        Collections.sort(entryList,(t1,t2)-> t2.getValue().compareTo(t1.getValue()));
        //sort by key
        Collections.sort(entryList,(t1,t2)-> t2.getKey().compareTo(t1.getKey()));
        System.out.println(entryList);
    }
}
