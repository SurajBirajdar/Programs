package programs.program.stringPrograms;

public class StringCompression {
    public static void main(String[] args) {
        // This program compresses a string by counting consecutive same characters
        // Example: "aabcccccaaa" becomes "a2b1c5a3"
        // Meaning: 'a' appears 2 times, 'b' appears 1 time, 'c' appears 5 times, 'a' appears 3 times

        // Step 1: Create a string that we want to compress
        String str = "aabcccccaaa";

        // Step 2: Convert the string into an array of characters
        // This helps us access each character one by one using an index
        char[] ch = str.toCharArray();

        // Step 3: Create a variable 'count' to keep track of how many times a character repeats
        // We start with 1 because we'll be comparing each character with the one before it
        int count = 1;

        // Step 4: Create a StringBuilder to build our result string
        // StringBuilder is used for efficient string concatenation
        StringBuilder sb = new StringBuilder();

        // Step 5: Loop through the character array starting from index 1 (second character)
        // We start from index 1 because we need to compare with the previous character (index 0)
        for(int i = 1; i < ch.length; i++) {

            // Step 6: Check if the current character is the same as the previous character
            if(ch[i] == ch[i-1]) {
                // If they are the same, increase the count
                count++;
            } else {
                // If they are different, we found a new character
                // So append the previous character and its count to our result
                sb.append(ch[i-1]).append(count);
                // Reset the count to 1 for the new character
                count = 1;
            }
        }

        // Step 7: After the loop ends, we need to add the last character and its count
        // because the loop exits before processing the last character
        sb.append(ch[str.length()-1]).append(count);

        // Step 8: Print the compressed string result
        System.out.println(sb.toString());
    }
}
