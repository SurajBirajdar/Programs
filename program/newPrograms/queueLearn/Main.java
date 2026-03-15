// ============================================================================
// QUEUE IMPLEMENTATION USING TWO STACKS - COMPLETE EXPLANATION WITH EXAMPLES
// ============================================================================
// CONCEPT: A Queue is like a line at a movie theater - First person in is
// first person out (FIFO = First In First Out). We're using TWO stacks to
// simulate this behavior.
//
// REAL WORLD EXAMPLE:
// Imagine 3 people: Alice, Bob, Charlie joining queue in that order
// They should come out in same order: Alice first, then Bob, then Charlie
// ============================================================================

package programs.program.newPrograms.queueLearn;

import java.util.*; // Import Collections like Stack

class Main {
    // ========================================================================
    // LINE 1: static Stack<Integer> stack1 = new Stack<>();
    // ========================================================================
    // WHAT: Create first stack (data structure like a pile of plates)
    // WHY: This is our MAIN stack where we store queue elements
    // HOW: Stack<Integer> means each item is an Integer number
    // EXAMPLE: stack1 looks like: [10, 20, 30] (10 is at bottom, 30 at top)
    // NOTE: "static" means it's shared across all objects of this class
    static Stack<Integer> stack1 = new Stack<>();

    // ========================================================================
    // LINE 2: static Stack<Integer> stack2 = new Stack<>();
    // ========================================================================
    // WHAT: Create second stack (helper/temporary stack)
    // WHY: We use this to reverse elements and maintain FIFO property
    // HOW: Same as stack1 - stores Integer numbers
    // EXAMPLE: We move items here temporarily to rearrange them
    // REAL EXAMPLE: Like having a helper table in kitchen to prep ingredients
    static Stack<Integer> stack2 = new Stack<>();

    // ========================================================================
    // METHOD: public static void enqueue(int element)
    // ========================================================================
    // WHAT: Add a new element to the queue
    // WHY: Users need a way to put items in the queue
    // INTERVIEW EXPLANATION: "Enqueue means adding elements to the queue,
    // like a person joining a line at the theater"
    public static void enqueue(int element) {
        // ====================================================================
        // LINE 3: while(!stack1.isEmpty()) {
        // ====================================================================
        // WHAT: Keep running loop WHILE stack1 has items in it
        // WHY: We need to move everything out to add new element at bottom
        // HOW: !stack1.isEmpty() = "NOT empty" = if it has items, condition is TRUE
        // EXAMPLE: If stack1 = [10, 20, 30], loop runs 3 times
        // ANALOGY: Like removing all plates from a plate stack before adding new one
        while(!stack1.isEmpty()) {

            // ================================================================
            // LINE 4: stack2.push(stack1.pop());
            // ================================================================
            // WHAT: Take top item from stack1 and put it in stack2
            // WHY: We're reversing the order temporarily
            // HOW BREAKDOWN:
            //   - stack1.pop() = Remove and get top item from stack1
            //   - stack2.push(...) = Add that item to top of stack2
            // EXAMPLE: stack1=[10,20,30] → pop(30) → stack2=[30]
            //          stack1=[10,20] → pop(20) → stack2=[30,20]
            //          stack1=[10] → pop(10) → stack2=[30,20,10]
            // RESULT: Order is now reversed!
            stack2.push(stack1.pop());
        }
        // After loop: stack1 is EMPTY, stack2 = [30, 20, 10]

        // ====================================================================
        // LINE 5: stack1.push(element);
        // ====================================================================
        // WHAT: Add the new element (parameter) to stack1
        // WHY: This new element should be at the "back of queue" (bottom of stack)
        // HOW: push() means add to top of stack
        // EXAMPLE: If element=40, stack1 becomes [40]
        // IMPORTANCE: This ensures new element is added at the rear
        stack1.push(element);

        // ====================================================================
        // LINE 6: while(!stack2.isEmpty()) {
        // ====================================================================
        // WHAT: Keep running loop WHILE stack2 has items
        // WHY: We need to put everything back in stack1 (now in correct order)
        // EXAMPLE: If stack2 = [30, 20, 10], loop runs 3 times
        // ANALOGY: Putting back all the plates we removed
        while(!stack2.isEmpty()) {

            // ================================================================
            // LINE 7: stack1.push(stack2.pop());
            // ================================================================
            // WHAT: Take items from stack2 and put them back to stack1
            // WHY: We're re-reversing to maintain FIFO order
            // EXAMPLE: stack2=[30,20,10] → pop(10) → stack1=[40,10]
            //          stack2=[30,20] → pop(20) → stack1=[40,10,20]
            //          stack2=[30] → pop(30) → stack1=[40,10,20,30]
            // FINAL RESULT: stack1 = [40, 10, 20, 30]
            // This maintains QUEUE ORDER: first added (10,20,30) before new (40)
            stack1.push(stack2.pop());
        }
    }
    // END OF enqueue() - Queue now has new element properly added!

    // ========================================================================
    // METHOD: public static int peek()
    // ========================================================================
    // WHAT: Look at the front element without removing it
    // WHY: Users want to see who's next in queue without removing them
    // INTERVIEW EXPLANATION: "Peek means seeing the front person in line
    // without making them come out"
    // EXAMPLE: If stack1 = [10, 20, 30], peek() returns 10 (doesn't remove it)
    public static int peek() {
        // ====================================================================
        // LINE 8: return stack1.peek();
        // ====================================================================
        // WHAT: Return the top element of stack1 (front of queue)
        // WHY: peek() method shows front element without removing
        // HOW: Returns the element, doesn't modify stack
        // EXAMPLE: stack1 = [10, 20, 30] → returns 10
        // AFTER: stack1 is still [10, 20, 30] (unchanged)
        return stack1.peek();
    }

    // ========================================================================
    // METHOD: public static int dequeue()
    // ========================================================================
    // WHAT: Remove and return the front element from queue
    // WHY: Users want to remove the first person from the line
    // INTERVIEW EXPLANATION: "Dequeue means removing elements from queue,
    // like a person leaving from the front of the line after their turn"
    public static int dequeue() {
        // ====================================================================
        // LINE 9: int element=-1;
        // ====================================================================
        // WHAT: Create variable to store the removed element
        // WHY: We need to store what we're removing before returning
        // VALUE: Initialize to -1 as default (when queue is empty)
        // EXAMPLE: If we remove 10, this variable becomes 10
        // LOGIC: -1 is a flag that indicates "queue was empty"
        int element=-1;

        // ====================================================================
        // LINE 10: if(stack1.isEmpty()) {
        // ====================================================================
        // WHAT: Check if stack1 is empty (no items in queue)
        // WHY: We can't dequeue from empty queue, need to handle this error
        // HOW: isEmpty() returns true if stack is empty
        // EXAMPLE: If stack1 = [], this condition is TRUE
        if(stack1.isEmpty()) {
            // ================================================================
            // LINE 11: System.out.println("queue is empty, cannot dequeue element");
            // ================================================================
            // WHAT: Print error message to user
            // WHY: Inform user that queue is empty
            // EXAMPLE OUTPUT: "queue is empty, cannot dequeue element" on screen
            // INTERVIEW POINT: This is error handling - we're being defensive
            System.out.println("queue is empty, cannot dequeue element");
        } else {
            // ================================================================
            // LINE 12: element = stack1.pop();
            // ================================================================
            // WHAT: Remove top element from stack1 and store in 'element'
            // WHY: We're removing the front person from queue
            // HOW: pop() removes AND returns the top element
            // EXAMPLE: stack1 = [10, 20, 30] → pop() returns 10
            // AFTER: stack1 becomes [20, 30] (10 is removed)
            element = stack1.pop();
        }

        // ====================================================================
        // LINE 13: return element;
        // ====================================================================
        // WHAT: Send back the removed element to caller
        // WHY: Caller wants to know which element was removed
        // EXAMPLE: If we removed 10, return 10 to the caller
        // IF EMPTY: Returns -1 (our error flag)
        return element;
    }

    // ========================================================================
    // METHOD: public static boolean isQueueEmpty()
    // ========================================================================
    // WHAT: Check if queue is empty (no elements)
    // WHY: Users might want to know if queue has any elements before dequeue
    // INTERVIEW EXPLANATION: "This method tells us if the queue is empty"
    // RETURN TYPE: boolean (true/false)
    public static boolean isQueueEmpty() {
        // ====================================================================
        // LINE 14: return stack1.isEmpty();
        // ====================================================================
        // WHAT: Return true if stack1 is empty, false otherwise
        // WHY: Direct check if queue has any elements
        // EXAMPLE 1: If stack1 = [], returns true (queue is empty)
        // EXAMPLE 2: If stack1 = [10, 20], returns false (queue has items)
        return stack1.isEmpty();
    }

    // ========================================================================
    // METHOD: public static void printList()
    // ========================================================================
    // WHAT: Display all elements currently in the queue
    // WHY: Users want to see the entire queue visually
    // INTERVIEW EXPLANATION: "This prints all elements in queue order"
    public static void printList() {
        // ====================================================================
        // LINE 15: for(int i=stack1.size()-1; i>=0; i--) {
        // ====================================================================
        // WHAT: Loop through stack from top to bottom
        // WHY BREAKDOWN:
        //   - int i = stack1.size()-1 : Start at last index (top of stack)
        //   - i >= 0 : Continue while i is 0 or positive (not negative)
        //   - i-- : Decrease i by 1 each time (go downward)
        // EXAMPLE: If stack1 has 3 items (indices: 0,1,2)
        //   - i starts at 2 (top), then 1, then 0 (bottom)
        //   - Loop runs 3 times
        // WHY REVERSE ORDER: To print queue order (front to back)
        for(int i=stack1.size()-1; i>=0; i--) {

            // ================================================================
            // LINE 16: System.out.print(stack1.get(i) + " ");
            // ================================================================
            // WHAT: Print element at index i, followed by space
            // HOW BREAKDOWN:
            //   - stack1.get(i) : Get element at position i
            //   - System.out.print(...) : Print to screen (no newline)
            //   - + " " : Add space after element for readability
            // EXAMPLE: If stack1 = [10, 20, 30]
            //   - When i=2: prints "30 "
            //   - When i=1: prints "20 "
            //   - When i=0: prints "10 "
            // OUTPUT: "30 20 10 "
            System.out.print(stack1.get(i) + " ");
        }

        // ====================================================================
        // LINE 17: System.out.println();
        // ====================================================================
        // WHAT: Print a newline (go to next line on screen)
        // WHY: Separate queue display from next output
        // EXAMPLE: After printing "30 20 10 ", moves cursor to new line
        // RESULT: Next output appears on a fresh line
        System.out.println();
    }

    // ========================================================================
    // METHOD: public static void main(String[] args)
    // ========================================================================
    // WHAT: Main entry point - where program execution starts
    // WHY: Java requires main() method to run the program
    // INTERVIEW EXPLANATION: "This is where we test our queue implementation"
    public static void main(String[] args) {

        // ====================================================================
        // LINE 18: Main.enqueue(10);
        // ====================================================================
        // WHAT: Add number 10 to the queue
        // WHY: We're testing the enqueue functionality
        // STATE AFTER: stack1 = [10] (10 is in queue)
        // INTERVIEW ANALOGY: "Alice (10) joins the queue"
        Main.enqueue(10);

        // ====================================================================
        // LINE 19: Main.enqueue(20);
        // ====================================================================
        // WHAT: Add number 20 to the queue
        // WHY: Testing adding another element
        // STATE AFTER: stack1 = [10, 20] (20 joins behind 10)
        // INTERVIEW ANALOGY: "Bob (20) joins the queue behind Alice"
        Main.enqueue(20);

        // ====================================================================
        // LINE 20: Main.enqueue(30);
        // ====================================================================
        // WHAT: Add number 30 to the queue
        // WHY: Testing adding third element
        // STATE AFTER: stack1 = [10, 20, 30] (Queue fully built)
        // INTERVIEW ANALOGY: "Charlie (30) joins the queue behind Bob"
        Main.enqueue(30);

        // ====================================================================
        // LINE 21: System.out.println(Main.peek());
        // ====================================================================
        // WHAT: Look at front element and print it
        // WHY: Test peek() functionality
        // EXECUTION: peek() returns 10 (first person in queue)
        // OUTPUT: "10" is printed
        // INTERVIEW ANALOGY: "Who's at the front? It's Alice (10)"
        System.out.println(Main.peek());

        // ====================================================================
        // LINE 22: Main.printList();
        // ====================================================================
        // WHAT: Print all elements in the queue
        // WHY: Visualize current queue state
        // EXECUTION: Prints "10 20 30 " (in queue order)
        // INTERVIEW EXPLANATION: "Current queue has: Alice(10), Bob(20), Charlie(30)"
        Main.printList();

        // ====================================================================
        // LINE 23: System.out.println(Main.dequeue());
        // ====================================================================
        // WHAT: Remove front element and print it
        // WHY: Test dequeue() functionality
        // EXECUTION: dequeue() removes 10 and returns it
        // OUTPUT: "10" is printed (Alice leaves)
        // STATE AFTER: stack1 = [20, 30] (Alice removed, Bob is now first)
        // INTERVIEW ANALOGY: "Alice (10) is called and leaves the queue"
        System.out.println(Main.dequeue());

        // ====================================================================
        // LINE 24: System.out.println(Main.isQueueEmpty());
        // ====================================================================
        // WHAT: Check if queue is empty and print result
        // WHY: Test isQueueEmpty() functionality
        // EXECUTION: isQueueEmpty() checks stack1
        // CURRENT STATE: stack1 = [20, 30] (has elements)
        // OUTPUT: "false" (queue is NOT empty)
        // INTERVIEW EXPLANATION: "Queue still has Bob(20) and Charlie(30), so not empty"
        System.out.println(Main.isQueueEmpty());
    }
}

// ============================================================================
// COMPLETE TEST OUTPUT EXPLANATION:
// ============================================================================
// Program Output:
// 10         ← From Main.peek() - Front person
// 10 20 30   ← From Main.printList() - Entire queue
// 10         ← From Main.dequeue() - Person who left
// false      ← From isQueueEmpty() - Queue still has people
//
// FINAL QUEUE STATE: [20, 30]
// ============================================================================

