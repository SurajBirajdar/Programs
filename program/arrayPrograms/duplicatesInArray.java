package programs.program.arrayPrograms;

import java.util.HashMap;
import java.util.Map;

public class duplicatesInArray {
    public static void main(String[] args) {
        int [] arr = {1,1,2,2,4,5,6};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        System.out.println(map);

        for(Map.Entry<Integer,Integer> m:map.entrySet()) {
            if(m.getValue() >= 2) {
                System.out.print(m.getKey() + " ");
            }
        }
        //Second Approach
        /*
        String[] arr = { "C","java", "python", "C", "C++", "java", "python" };

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i].equals(arr[j])) {
                    System.out.println("Found duplicate element " + arr[i]);
                }
            }
        }
        */
    }
}
