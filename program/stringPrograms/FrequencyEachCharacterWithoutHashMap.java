package programs.program.stringPrograms;

public class FrequencyEachCharacterWithoutHashMap {
    // Given a string calculate frequency of each character without HashMap

    public static void main(String[] args) {

        String s1 = "surajsu";
        //frequencyOfEachCharWithouthashMap(s1);
//        char[] arr = s1.toCharArray();
//        int fr[] = new int[arr.length];
//
//        int visited = -1;
//        int count = 1;
//
//        for (int i = 0; i < arr.length; ++i) {
//            count = 1;
//            for (int j = i + 1; j < arr.length; ++j) {
//                if (arr[i] == arr[j]) {
//                    ++count;
//                    fr[j] = visited;
//                }
//            }
//            if (fr[i] != visited) {
//                fr[i] = count;
//            }
//        }
//
//        for (int i = 0; i < fr.length; ++i) {
//            if (fr[i] != visited) {
//                System.out.println(arr[i] + "-->" + fr[i]);
//            }
//        }
        //===================Another approach=========================================================//
        // frequency of each character without using hashmap
        String str = "abcdabc";
        char[] ch = str.toCharArray();
        for(int i=0 ; i<ch.length; i++) {
            int count = 1;
            boolean alreadyCounted = false;
            for(int k=0; k<i; k++) {

                if(ch[i] == ch[k]) {
                    alreadyCounted = true;
                }
            }
            if(alreadyCounted)
                continue;

            for(int j=0; j<ch.length; j++) {
                if(ch[i] == ch[j] && i < j)  {
                    if(i != j) {
                        count++;
                    }
                }
            }
            System.out.println("Frequency of char " + ch[i] + " is " + count);
        }
    }

    public static void frequencyOfEachCharWithouthashMap(String str) {

        for(int i=0; i<str.length(); i++) {
            int count = 0;
            for(int j=0; j<str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    count++;
                }
                if(j<i && str.charAt(i) == str.charAt(j)) {
                    break;
                }
            }
            if(count != 0) {
                System.out.println("Frequency of character " + str.charAt(i) + " is: " + count);
            }
        }
    }

    public void frequencyWithoutHashMap(String str) {
        // Goal: print frequency of each character in the string without using HashMap.
        // Approach: for each position i, we count how many times str.charAt(i) occurs.
        // To avoid printing duplicates (same character multiple times), we skip counting/printing
        // when we detect that the same character already appeared at an earlier index.

        for (int i = 0; i < str.length(); i++) {              // Pick a character at index i.
            int count = 0;                                    // Will hold frequency of str.charAt(i).

            for (int j = 0; j < str.length(); j++) {          // Compare it with every character at index j.
                if (str.charAt(i) == str.charAt(j)) {         // Same character found at position j.
                    if (i > j) {                              // If we already saw this char earlier (j < i)...
                        break;                                // ...stop: this char was/will be handled at that earlier i.
                    } else {
                        count++;                              // Otherwise count this matching occurrence.
                    }
                }
            }

            if (count != 0) {                                 // count will be 0 only when we broke due to duplicate.
                System.out.println(str.charAt(i) + " : " + count); // Print character and its frequency.
            }
        }
    }

}
