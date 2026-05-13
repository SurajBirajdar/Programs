// PACKAGE DECLARATION
// This is like putting your code in a folder. It tells Java where this file belongs.
// It helps organize code in a library structure (folder hierarchy)
package programs.program.newPrograms.numberPrograms;

// CLASS DECLARATION: GCD
// This creates a container (box) called GCD where we'll store all our code
// Think of it as a box where we put all tricks/functions related to finding GCD
public class GCD_and_LCM {

    // MAIN METHOD - This is the starting point of the program
    // When you run the code, Java always starts executing from here (the entry gate)
    // String[] args means we can pass arguments when running the program from command line
    public static void main(String[] args) {

        // COMMENT: Explaining what GCD is
        // GCD = Greatest Common Divisor (also called HCF - Highest Common Factor)
        // It's the largest number that divides both numbers evenly
        // GCD of two numbers ( HUF - highest common factor)

        // VARIABLE DECLARATION - Creating a box called 'a' and putting number 18 in it
        int a = 18;

        // VARIABLE DECLARATION - Creating a box called 'b' and putting number 12 in it
        int b = 12;

        // CALLING THE FUNCTION AND PRINTING RESULT
        // We're calling findGCD function (giving it 18 and 12)
        // It calculates the GCD and returns the answer
        // System.out.println displays the result on the screen
        System.out.println(findGCD(18,12));
        System.out.println(findLCM(18,12));
    }

    // FUNCTION DEFINITION
    // This function takes TWO parameters: integer a and integer b
    // It returns an integer (the GCD of a and b)
    // This is like a calculator tool that we'll use to find GCD
    public static int findGCD(int a, int b) {

        // ALGORITHM EXPLANATION: Euclidean Algorithm
        // Mathematical trick: gcd(a,b) = gcd(b, a%b)
        // Keep repeating this process until b becomes 0
        // Then a will contain our GCD (Greatest Common Divisor)
        //gcd(a,b) -> gcd(b, a%b)

        // WHILE LOOP: Keep doing steps BELOW as long as b is NOT equal to 0
        // When b becomes 0, we stop and a will have our GCD answer
        // Think: "Keep stirring soup UNTIL it boils" (UNTIL condition is met)
        while(b != 0) {

            // STEP 1: SAVE THE VALUE OF B
            // We're creating a temporary box called 'temp' and copying b's value into it
            // Why? Because we're about to change b, so we need to save its current value first
            // This is called "swapping" technique
            int temp = b;

            // STEP 2: CALCULATE REMAINDER
            // The % symbol means "remainder after division"
            // Example: 18 % 12 = 6 (because 18 ÷ 12 = 1 remainder 6)
            // We're putting this remainder (a%b) into box 'b'
            b = a%b;

            // STEP 3: MOVE OLD B VALUE TO A
            // Now we put the old value of b (which we saved in temp) into a
            // This is how the swap completes!
            // After this:
            //   a gets the old value of b
            //   b gets the remainder
            // Example of one cycle:
            //   Before: a=18, b=12
            //   After:  a=12, b=6
            a = temp;

            // The loop repeats:
            // Cycle 1: a=18, b=12 → after swap → a=12, b=6
            // Cycle 2: a=12, b=6  → after swap → a=6, b=0
            // Now b=0, so loop stops. a=6 is our GCD!
        }

        // STORING THE ANSWER
        // After the loop stops, the value in 'a' is our GCD (Greatest Common Divisor)
        // We put it in a box called 'ans' (short for answer) for clarity
        int ans = a;

        // RETURNING THE ANSWER
        // We give back the GCD answer to whoever called this function
        // It's like a restaurant giving you cooked food - we return what was requested
        // The number 'ans' goes back to where this function was called (in main method)
        return ans;
    }

    // FUNCTION DEFINITION FOR LCM
    // This function takes TWO parameters: integer a and integer b
    // It returns an integer (the LCM of a and b)
    // LCM = Least Common Multiple (the smallest number that is divisible by both numbers)
    // This is like a calculator tool that we'll use to find LCM
    public static int findLCM(int a, int b) {

        // STEP 1: CALCULATE GCD FIRST
        // We call the findGCD function (which we created above) to find GCD of a and b
        // We pass 'a' and 'b' to it and get back the GCD
        // We store this GCD value in a box called 'gcd'
        // Why? Because there's a mathematical formula: LCM(a,b) = (a × b) / GCD(a,b)
        // Example: GCD(18, 12) = 6, so we store 6 in 'gcd' box
        int gcd = findGCD(a,b);

        // STEP 2: MULTIPLY THE TWO NUMBERS
        // We multiply a and b together (a × b)
        // We store this multiplication result in a box called 'product'
        // Example: 18 × 12 = 216, so 'product' = 216
        int product = a * b;

        // STEP 3: DIVIDE PRODUCT BY GCD
        // Now we take the product (216) and divide it by GCD (6)
        // 216 ÷ 6 = 36
        // We store this result in a box called 'ans' (short for answer)
        // This 36 is our LCM (Least Common Multiple)
        int ans = product/gcd;

        // STEP 4: RETURN THE ANSWER
        // We give back the LCM answer to whoever called this function
        // The number 'ans' (which is 36) goes back to where this function was called
        // In main method, System.out.println will print this value
        return ans;
    }

    // ============================================================
    // SIMPLE EXPLANATION OF HOW THIS PROGRAM WORKS:
    // ============================================================
    // 1. Program starts in main() with two numbers: 18 and 12
    //
    // PART 1 - FINDING GCD:
    // 2. We call findGCD(18, 12) function
    // 3. Inside findGCD, we use Euclidean Algorithm:
    //    - Keep dividing and finding remainders
    //    - Swap values in each cycle
    //    - Stop when remainder becomes 0
    // 4. The remaining number is our GCD
    // 5. We return 6 as the answer (GCD of 18 and 12 is 6)
    // 6. System.out.println prints: 6
    //
    // PART 2 - FINDING LCM:
    // 7. We call findLCM(18, 12) function
    // 8. Inside findLCM:
    //    - First, we calculate GCD(18, 12) = 6
    //    - Then, we multiply: 18 × 12 = 216
    //    - Finally, we divide: 216 ÷ 6 = 36
    // 9. We return 36 as the answer (LCM of 18 and 12 is 36)
    // 10. System.out.println prints: 36
    //
    // MATHEMATICAL FORMULA USED:
    // LCM(a, b) = (a × b) / GCD(a, b)
    // This formula always works!
    //
    // REAL WORLD EXAMPLES:
    //
    // GCD EXAMPLE:
    // If you have 18 apples and 12 oranges and want to divide them equally
    // into boxes with NO leftovers:
    // Maximum 6 boxes can be made (3 apples + 2 oranges in each box)
    // That's why GCD(18, 12) = 6
    //
    // LCM EXAMPLE:
    // If Train A comes every 18 minutes and Train B comes every 12 minutes,
    // When will they arrive at the same time again?
    // Answer: After 36 minutes (LCM of 18 and 12 is 36)
    // Because:
    //   Train A arrives at: 18, 36, 54, 72... minutes
    //   Train B arrives at: 12, 24, 36, 48... minutes
    //   They meet together at: 36 minutes (first common time after start)
    // ============================================================
}
