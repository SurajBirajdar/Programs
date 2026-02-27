// This tells Java where this program lives in the folder structure
// Like saying: "This class lives in programs → program → newPrograms → stringPrograms"
package programs.program.newPrograms.stringPrograms;

// This is the name of our program (class). Think of it like a container that holds our code.
// public = anyone can use it
// class = a blueprint for Java objects
public class ReverseStringMaintainingSpaces {

    // This is the main method - the starting point when we run the program
    // It's like pressing the START button on a video game
    // String[] args = way to pass information to the program
    public static void main(String[] args) {
        // STEP 1: Create a string with spaces
        // Original: "abc de f" (that's 8 characters including spaces)
        // Goal: Reverse ONLY the letters, keep spaces in same place
        // Expected output: "fed cb a" (letters reversed, spaces stay at positions 3 and 6)
        String str = "abc de f";
        //output after reverse - fed cb a

        // STEP 2: Create a pointer called 'l' (LEFT pointer) starting at position 0
        // Position 0 is the first character 'a'
        // Think of it as putting your LEFT finger on the first character
        // Array positions: [0]a [1]b [2]c [3]  [4]d [5]e [6]  [7]f
        int l = 0;

        // STEP 3: Create a pointer called 'r' (RIGHT pointer) starting at the LAST position
        // str.length() = 8 (total characters)
        // str.length()-1 = 7 (last valid position, because we count from 0)
        // So 'r' starts at position 7, which is 'f' (the last character)
        // Think of it as putting your RIGHT finger on the last character
        int r = str.length()-1;

        // STEP 4: Convert the string into an array of characters
        // String "abc de f" becomes ['a','b','c',' ','d','e',' ','f']
        // This is like breaking a sentence into individual letters
        // We do this because strings can't be changed, but char arrays can
        char[] ch = str.toCharArray();

        // STEP 5: Keep swapping characters from left and right until they meet in middle
        // while(l<r) = "keep doing this as long as left pointer is before right pointer"
        // Example: l=0, r=7 → keep going. l=3, r=4 → keep going. l=4, r=3 → STOP (they passed each other)
        while(l<r) {

            // STEP 6A: Check if LEFT character is a space
            // if(ch[l] == ' ') = "Is the character at position l a space?"
            // Example: At position 0, ch[0]='a' which is NOT a space, so skip this
            //          At position 3, ch[3]=' ' which IS a space, so we go inside
            if(ch[l] == ' ') {
                // If LEFT character is a space, skip it by moving left pointer right
                // l++ means l = l + 1 (move forward by 1 position)
                // We DON'T swap spaces - they stay where they are!
                // Example: Left finger was at space (position 3), now jump to position 4
                l++;
            }
            // STEP 6B: Else-if check if RIGHT character is a space
            // else if(ch[r] == ' ') = "If left is NOT space, is right a space?"
            // Example: At position 7, ch[7]='f' which is NOT a space, so skip this
            //          At position 6, ch[6]=' ' which IS a space, so we go inside
            else if(ch[r] == ' ') {
                // If RIGHT character is a space, skip it by moving right pointer left
                // r-- means r = r - 1 (move backward by 1 position)
                // We DON'T swap spaces - they stay where they are!
                // Example: Right finger was at space (position 6), now jump back to position 5
                r--;
            }
            // STEP 6C: If BOTH characters are NOT spaces, we can swap them!
            else {
                // Create a temporary storage called 'temp' to hold one character
                // Think of it like a helper hand that holds one thing while we swap
                // char temp = ch[l] means: temp = the character at left position
                // Example: if ch[0]='a', then temp='a'
                char temp = ch[l];

                // Put the RIGHT character into the LEFT position
                // ch[l] = ch[r] means: position l now gets character from position r
                // Example: ch[0] now becomes 'f' (from ch[7])
                // Array state after this line: ['f','b','c',' ','d','e',' ','a']
                ch[l] = ch[r];

                // Put the TEMPORARY character (the old left one) into the RIGHT position
                // ch[r] = temp means: position r now gets the old left character
                // Example: ch[7] now becomes 'a' (from temp, which was ch[0])
                // Array state after this line: ['f','b','c',' ','d','e',' ','a']
                // We successfully swapped 'a' and 'f'!
                ch[r] = temp;

                // Move left pointer to the RIGHT (one step forward)
                // l++ means l = l + 1
                // Example: l was 0, now l becomes 1
                l++;

                // Move right pointer to the LEFT (one step backward)
                // r-- means r = r - 1
                // Example: r was 7, now r becomes 6
                r--;

                // After these 4 lines, we've swapped the current pair and moved both pointers
                // Next loop iteration will check the new characters at l and r
            }
        }

        // STEP 7: Convert the modified character array back into a String
        // new String(ch) = "Turn this array back into a readable sentence"
        // The character array ['f','e','d',' ','c','b',' ','a'] becomes "fed cb a"
        // System.out.println() = "Print this to the screen"
        System.out.println(new String(ch));

        // Final result printed: "fed cb a"
        // The spaces stayed at positions 3 and 6 (never moved)
        // Only the letters got reversed!
    }
}
