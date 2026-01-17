package programs.program.arrayPrograms;
import java.util.*;

public class IntersectionOfTwoElements {
    public static void main(String[] args) {
        // This program finds the INTERSECTION of two arrays
        // Intersection means: the elements that are PRESENT in BOTH arrays
        // Example: Array a = {1, 2, 3, 4} and Array b = {3, 4, 5}
        // Intersection = {3, 4} because 3 and 4 are in both arrays

        // Step 1: Create the first array with some numbers
        int[] a = {1, 2, 3, 4};

        // Step 2: Create the second array with some numbers
        int[] b = {3, 4, 5};

        // Step 3: Create a HashSet to store elements from the first array
        // A HashSet is a data structure that stores unique values and helps us find elements quickly
        Set<Integer> set = new HashSet<>();

        // Step 4: Loop through each element in the first array (a)
        // The syntax "for(int i: a)" means: take each element from array 'a' one by one and call it 'i'
        for(int i: a) {
            // Step 5: Add each element from array 'a' into the HashSet
            // This stores all elements from the first array for later comparison
            set.add(i);
        }
        // After this loop, our set contains: {1, 2, 3, 4}

        // Step 6: Loop through each element in the second array (b)
        // The syntax "for(int j : b)" means: take each element from array 'b' one by one and call it 'j'
        for(int j : b) {
            // Step 7: Try to add the current element from array 'b' to the set
            // The key trick: set.add(j) returns FALSE if the element already exists in the set
            // It returns TRUE if the element is new and was successfully added
            if(set.add(j) == false) {
                // Step 8: If set.add(j) returned FALSE, it means 'j' was already in the set
                // This means 'j' exists in BOTH array 'a' and array 'b'
                // So we print it as part of the intersection
                System.out.print(j + " ");
            }
        }
        // Output: 3 4
        // This is because 3 and 4 are the only elements that appear in both arrays
    }
}
