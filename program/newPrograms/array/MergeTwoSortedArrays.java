package programs.program.newPrograms.array;

// This line imports the Arrays class which helps us print arrays nicely
// Example: Arrays.toString([1,2,3]) will show "[1, 2, 3]" instead of memory address
import java.util.Arrays;

// This is our class name - like a container that holds our program
public class MergeTwoSortedArrays {

    // This is the starting point of our program - execution begins here
    // Think of it like pressing the "START" button on a game
    public static void main(String[] args) {

        // ============ STEP 1: CREATE TWO SORTED ARRAYS ============

        // First array with 4 numbers already sorted from small to big
        // Example: arr1 = {1, 2, 3, 4}
        // Position:      [0][1][2][3]  <- these are index positions
        int[] arr1 = {1,2,3,4};

        // Second array with 4 numbers also sorted from small to big
        // Example: arr2 = {5, 6, 7, 8}
        // Position:      [0][1][2][3]  <- these are index positions
        int[] arr2 = {5,6,7,8};

        // ============ STEP 2: FIND THE SIZES OF ARRAYS ============

        // 'n' stores how many elements are in arr1
        // Example: arr1 has 4 elements, so n = 4
        int n = arr1.length;

        // 'm' stores how many elements are in arr2
        // Example: arr2 has 4 elements, so m = 4
        int m = arr2.length;

        // 'result' is a new empty array that will hold all elements from both arrays
        // Size = n + m = 4 + 4 = 8 (big enough to hold everything)
        // Example: result = [_, _, _, _, _, _, _, _]  (8 empty spots)
        int[] result = new int[n + m];

        // ============ STEP 3: SET UP THREE POINTERS (like fingers pointing) ============
        // Think of pointers as bookmarks that track our position in each array

        // 'i' points to current position in arr1 (starts at 0, the first position)
        // Example: i=0 means we're looking at arr1[0] which is 1
        int i=0; // arr1 counter

        // 'j' points to current position in arr2 (starts at 0, the first position)
        // Example: j=0 means we're looking at arr2[0] which is 5
        int j=0; //arr2 counter

        // 'k' points to current position in result array (starts at 0)
        // Example: k=0 means we'll put the next element at result[0]
        int k=0; // result counter

        // ============ STEP 4: COPY ALL ELEMENTS FROM arr1 TO result ============

        // This while loop runs as long as 'i' is less than 'n' (number of elements in arr1)
        // It means: "While there are still elements in arr1 to copy..."
        // Example iterations:
        //   Loop 1: i=0, copy arr1[0]=1 to result[0], then i=1, k=1
        //   Loop 2: i=1, copy arr1[1]=2 to result[1], then i=2, k=2
        //   Loop 3: i=2, copy arr1[2]=3 to result[2], then i=3, k=3
        //   Loop 4: i=3, copy arr1[3]=4 to result[3], then i=4, k=4
        //   Loop 5: i=4, STOP! (because i is no longer less than n which is 4)
        while(i<n) {
            // Copy the current element from arr1 to result
            // Example: When i=0, k=0: result[0] = arr1[0] = 1
            result[k] = arr1[i];

            // Move pointer 'i' to the next position in arr1
            // Example: i goes from 0 to 1, then 1 to 2, etc.
            i++;

            // Move pointer 'k' to the next position in result
            // Example: k goes from 0 to 1, then 1 to 2, etc.
            k++;
        }
        // After this loop: result = [1, 2, 3, 4, _, _, _, _]
        //                            k now points here ↑ (position 4)

        // ============ STEP 5: COPY ALL ELEMENTS FROM arr2 TO result ============

        // This while loop runs as long as 'j' is less than 'm' (number of elements in arr2)
        // It means: "While there are still elements in arr2 to copy..."
        // Example iterations:
        //   Loop 1: j=0, copy arr2[0]=5 to result[4], then j=1, k=5
        //   Loop 2: j=1, copy arr2[1]=6 to result[5], then j=2, k=6
        //   Loop 3: j=2, copy arr2[2]=7 to result[6], then j=3, k=7
        //   Loop 4: j=3, copy arr2[3]=8 to result[7], then j=4, k=8
        //   Loop 5: j=4, STOP! (because j is no longer less than m which is 4)
        while(j<m) {
            // Copy the current element from arr2 to result
            // Example: When j=0, k=4: result[4] = arr2[0] = 5
            result[k] = arr2[j];

            // Move pointer 'j' to the next position in arr2
            // Example: j goes from 0 to 1, then 1 to 2, etc.
            j++;

            // Move pointer 'k' to the next position in result
            // Example: k goes from 4 to 5, then 5 to 6, etc.
            k++;
        }
        // After this loop: result = [1, 2, 3, 4, 5, 6, 7, 8]
        //                            All positions filled! ✓

        // ============ STEP 6: DISPLAY THE FINAL MERGED ARRAY ============

        // Print the result array in a nice readable format
        // Arrays.toString() converts [1, 2, 3, 4, 5, 6, 7, 8] to a string
        // Output: [1, 2, 3, 4, 5, 6, 7, 8]
        System.out.print(Arrays.toString(result));
    }
}
