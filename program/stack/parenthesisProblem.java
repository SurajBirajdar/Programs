package programs.program.stack;

import java.util.*;
public class parenthesisProblem {
    public static void main(String[] args) {
        // Step 1: We have a string with different types of brackets
        String str = "{[()]}";

        // Step 2: Create a Stack to store opening brackets like a pile of plates
        Stack<Character> stack = new Stack<>();

        // Step 3: Go through each character in the string one by one
        for (int i = 0; i < str.length(); i++) {
            // Step 4: Pick one character at a time
            char ch = str.charAt(i);

            // Step 5: Check if this character is an OPENING bracket ( { [ (
            if (ch == '{' || ch == '[' || ch == '(') {
                // Step 6: If it's opening bracket, put it in the stack (like putting a plate on top)
                stack.push(ch);
            }
            // Step 7: If it's not opening bracket, then it must be a CLOSING bracket ) ] }
            else {
                // Step 8: Before popping, check if stack is empty (no opening bracket to match)
                if (stack.isEmpty()) {
                    // Step 9: If stack is empty, it means closing bracket has no opening - WRONG!
                    System.out.println("false");
                    return;
                }

                // Step 10: Take out the top bracket from stack (like removing the top plate)
                char top = stack.pop();

                // Step 11: Check if the opening and closing brackets MATCH
                // If closing ) but top is not (  OR
                // If closing ] but top is not [  OR
                // If closing } but top is not {  - then WRONG!
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    // Step 12: Brackets don't match - this is WRONG!
                    System.out.println("false");
                    return;
                }
            }
        }

        // Step 13: After checking all characters, if stack is empty = all brackets matched = TRUE
        // If stack is NOT empty = some opening brackets were never closed = FALSE
        System.out.println(stack.isEmpty());
    }
}
