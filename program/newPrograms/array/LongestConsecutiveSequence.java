package programs.program.newPrograms.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        // longest consecutive subsequence length and print those numbers also
        int[] arr = {100, 34, 3,2,1,0,-1};
        Set<Integer> set = new HashSet<>();

        for(int num : arr) {
            set.add(num);
        }
        int longest = 0;
        for(int num : set) {
            int tempNum = num;
            int count = 1;
            if(!set.contains(tempNum-1)) {

                while(set.contains(tempNum+1)) {
                    System.out.print(tempNum + " ");
                    tempNum++;
                    count++;
                }
            }
            longest = Math.max(longest,count);
        }
        System.out.println();
        System.out.println(longest);
    }
}
