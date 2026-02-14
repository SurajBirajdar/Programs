package programs.program.newPrograms.stringPrograms;

import java.util.ArrayList;
import java.util.List;

// This class will create all permutations (all different orders) of a string.
// Example: "ABC" -> ABC, ACB, BAC, BCA, CAB, CBA
public class PermutationsOfString {

    // This method returns a list that contains ALL permutations of the input string.
    // It does this WITHOUT recursion. Only loops + lists.
    public static List<String> findPermutations(String str) {

        // result = our "final basket" where we keep permutations.
        List<String> result = new ArrayList<>();

        // If str is null (nothing) OR str is empty (""), return list with just "".
        // (Permutation of empty string is empty string.)
        if (str == null || str.isEmpty()) {
            result.add("");
            return result;
        }

        // Put the 1st character into the list.
        // Example: str="ABC" -> result=["A"]
        result.add(String.valueOf(str.charAt(0)));

        // Now we take remaining characters one by one: B then C then ...
        // i starts from 1 because 0th character is already used.
        for (int i = 1; i < str.length(); i++) {

            // currentChar = the new character we are inserting everywhere.
            // Example: for "ABC": i=1 -> 'B', i=2 -> 'C'
            char currentChar = str.charAt(i);

            // tempList = new basket for NEW permutations after inserting currentChar.
            List<String> tempList = new ArrayList<>();

            // For every permutation we already have in result...
            // Example after "A": result has only "A"
            // Example after inserting B: result has "BA", "AB"
            for (String perm : result) {

                // We insert currentChar at EVERY position in perm.
                // If perm is "AB" (length 2), positions are:
                // j=0 _AB  -> put at start
                // j=1 A_B  -> put in middle
                // j=2 AB_  -> put at end
                for (int j = 0; j <= perm.length(); j++) {

                    // Build new permutation by splitting perm into 2 parts:
                    // left  = perm.substring(0, j)
                    // right = perm.substring(j)
                    // newPerm = left + currentChar + right
                    // Example: perm="AB", currentChar='C'
                    // j=0: ""  + C + "AB" -> "CAB"
                    // j=1: "A" + C + "B"  -> "ACB"
                    // j=2: "AB"+ C + ""   -> "ABC"
                    String newPerm = perm.substring(0, j) + currentChar + perm.substring(j);

                    // Put this new permutation into tempList.
                    tempList.add(newPerm);
                }
            }

            // Now tempList has all new permutations. Make it the new result.
            result = tempList;
        }

        // Finally return all permutations.
        return result;
    }

    // main() is only for testing/printing. It is not required for the algorithm.
    public static void main(String[] args) {

        // ---- Test Case 1 ----
        String input1 = "ABC";
        System.out.println("Permutations of '" + input1 + "':");

        // Call our method to get permutations.
        List<String> perms1 = findPermutations(input1);

        // Print each permutation with a number.
        for (int i = 0; i < perms1.size(); i++) {
            System.out.println((i + 1) + ". " + perms1.get(i));
        }
        System.out.println("Total: " + perms1.size() + " permutations\n");

        // ---- Test Case 2 ----
        String input2 = "AB";
        System.out.println("Permutations of '" + input2 + "':");
        List<String> perms2 = findPermutations(input2);
        for (int i = 0; i < perms2.size(); i++) {
            System.out.println((i + 1) + ". " + perms2.get(i));
        }
        System.out.println("Total: " + perms2.size() + " permutations\n");

        // ---- Test Case 3 ----
        // "1234" has 4! = 24 permutations.
        String input3 = "1234";
        System.out.println("Permutations of '" + input3 + "':");
        List<String> perms3 = findPermutations(input3);
        System.out.println("Total: " + perms3.size() + " permutations");

        // Print only first 10 so output doesn't become huge.
        System.out.println("First 10 permutations:");
        for (int i = 0; i < Math.min(10, perms3.size()); i++) {
            System.out.println((i + 1) + ". " + perms3.get(i));
        }

        // ---- Test Case 4 ----
        String input4 = "XY";
        System.out.println("\nPermutations of '" + input4 + "':");
        List<String> perms4 = findPermutations(input4);

        // Another way to print: forEach prints each element.
        perms4.forEach(System.out::println);
    }
}
