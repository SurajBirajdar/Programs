package programs.program.stream;

import java.util.*;

public class SortHashMapValues {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('s',90);
        map.put('b',10);
        map.put('c', 8);
        map.put('d',88);

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.print(entry.getKey() + " : " + entry.getValue() + " "));
    }
}
