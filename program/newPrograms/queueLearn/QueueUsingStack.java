// LINE 1: This tells Java where this file lives in your project structure
// Like your home address: "programs.program.newPrograms.queueLearn"
package programs.program.newPrograms.queueLearn;

// LINE 3: Import the Stack tool from Java's toolbox
// Stack = A pile of items where you can only add/remove from the TOP
// Think of it like a stack of plates - you add on top, remove from top
import java.util.Stack;

// LINE 5: The name of our class/program
// We're building a QUEUE (line) using two STACKS (piles)
// 🎯 GOAL: Make a queue (First In, First Out) using stacks (Last In, First Out)
public class QueueUsingStack {

    // LINE 7-8: Create two empty stacks (two empty piles of plates)
    // Stack<Integer> means "a stack that holds whole numbers"
    // stack1 = our main storage pile
    // stack2 = our helper pile (temporary workspace)
    //
    // 📚 ANALOGY:
    // Imagine you have two tables (stack1 and stack2)
    // You can stack books on either table
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // ==================== ENQUEUE METHOD ====================
    // LINE 10: "enqueue" means "add someone to the back of the line"
    // Like when you join a queue at a movie theater - you go to the BACK
    // void = this method doesn't return anything, it just does something
    public void enqueue(int element) {

        // LINE 11: Push (add) the element to the top of stack1
        // push = put on top of the pile
        //
        // 📖 EXAMPLE:
        // enqueue(20): stack1 = [20]           (20 is at bottom)
        // enqueue(30): stack1 = [20, 30]       (30 is on top)
        // enqueue(40): stack1 = [20, 30, 40]   (40 is on top)
        //
        // Visual (top to bottom):
        //   40  ← top of stack
        //   30
        //   20  ← bottom of stack
        stack1.push(element);
    }

    // ==================== DEQUEUE METHOD ====================
    // LINE 14: "dequeue" means "remove the person from the FRONT of the line"
    // In a real queue, the FIRST person who arrived leaves FIRST (FIFO)
    // This method returns an int = the number that was removed
    public int dequeue() {

        // LINE 15-18: Check if stack1 is empty (no elements)
        // isEmpty() = returns true if stack is empty, false otherwise
        // If empty, we can't remove anything, so return -1 (error code)
        //
        // 📖 EXAMPLE:
        // If stack1 = [] (empty), print error and return -1
        if(stack1.isEmpty()) {
            System.out.println("Queue is empty, there is nothing to dequeue");
            return -1;
        }

        // LINE 20-22: THE MAGIC TRICK! 🎩✨
        // We need to reverse the order to get the bottom element
        // Move all elements from stack1 to stack2 (flips the order!)
        //
        // 📖 EXAMPLE:
        // BEFORE:
        //   stack1 = [20, 30, 40]  (40 on top)
        //   stack2 = []
        //
        // STEP BY STEP:
        //   Pop 40 from stack1, push to stack2: stack1=[20,30], stack2=[40]
        //   Pop 30 from stack1, push to stack2: stack1=[20], stack2=[40,30]
        //   Pop 20 from stack1, push to stack2: stack1=[], stack2=[40,30,20]
        //
        // AFTER:
        //   stack1 = []
        //   stack2 = [40, 30, 20]  (20 is now on top! Perfect!)
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());  // pop = remove from top, push = add to top
        }

        // LINE 23: Remove and get the top element from stack2
        // This is the element that was at the BOTTOM of stack1
        // In our example: val = 20 (the first one we added!)
        int val = stack2.pop();

        // LINE 25-27: Move everything back to stack1
        // This restores the original order for future operations
        //
        // 📖 EXAMPLE:
        // BEFORE:
        //   stack1 = []
        //   stack2 = [40, 30]  (we already removed 20)
        //
        // AFTER:
        //   stack1 = [30, 40]  (30 at bottom, 40 on top)
        //   stack2 = []
        while(!stack2.isEmpty()) {
            stack1.push((stack2.pop()));
        }

        // LINE 28: Return the value we removed (20 in our example)
        return val;
    }

    // ==================== PEEK METHOD ====================
    // LINE 31: "peek" means "look at the front person WITHOUT removing them"
    // Like looking at who's first in line, but not asking them to leave
    // Returns int = the number at the front (doesn't remove it)
    public int peek() {

        // LINE 32-35: Check if stack1 is empty
        // If empty, nothing to peek at, so return -1
        if(stack1.isEmpty()) {
            System.out.println("Queue is empty, there is nothing to peek");
            return -1;
        }

        // LINE 37-39: Same flipping trick as dequeue!
        // Move all elements to stack2 to access the bottom one
        //
        // 📖 EXAMPLE:
        // stack1 = [20, 30, 40] becomes stack2 = [40, 30, 20]
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // LINE 40: LOOK at the top of stack2 (DON'T remove it)
        // peek() = look at top without removing
        // pop() = look at top AND remove it
        //
        // In our example: val = 20 (but 20 stays in stack2!)
        int val = stack2.peek();

        // LINE 42-44: Move everything back to stack1
        // Restore original order
        while(!stack2.isEmpty()) {
            stack1.push((stack2.pop()));
        }

        // LINE 45: Return the value we peeked at (20)
        return val;
    }

    // ==================== MAIN METHOD ====================
    // LINE 48: Where our program starts running
    public static void main(String[] args) {

        // LINE 49: Create a new QueueUsingStack object
        // Think: "I'm building a new queue machine"
        QueueUsingStack queueUsingStack = new QueueUsingStack();

        // LINE 50-52: Add three people to the queue
        // enqueue(20) = Person with number 20 joins the line (first)
        // enqueue(30) = Person with number 30 joins the line (second)
        // enqueue(40) = Person with number 40 joins the line (third)
        //
        // 📖 VISUAL QUEUE (left = front, right = back):
        // [20] ← front (first in line)
        // [30]
        // [40] ← back (last in line)
        queueUsingStack.enqueue(20);
        queueUsingStack.enqueue(30);
        queueUsingStack.enqueue(40);

        // LINE 54: Peek at the front person (don't remove)
        // Should print: 20 (because 20 was first to join)
        // 📖 OUTPUT: 20
        System.out.println(queueUsingStack.peek());

        // LINE 56: Remove the front person from the queue
        // dequeue() removes and returns 20
        // Now queue looks like: [30, 40]
        // 📖 OUTPUT: 20
        System.out.println(queueUsingStack.dequeue());

        // LINE 57: Peek at the NEW front person
        // After removing 20, now 30 is at the front
        // 📖 OUTPUT: 30
        System.out.println(queueUsingStack.peek());
    }

}

/*
 * ====== COMPLETE EXAMPLE WALKTHROUGH ======
 *
 * STEP 1: enqueue(20)
 *   stack1: [20]
 *   Queue view: [20] ← front
 *
 * STEP 2: enqueue(30)
 *   stack1: [20, 30]
 *   Queue view: [20, 30] ← front to back
 *
 * STEP 3: enqueue(40)
 *   stack1: [20, 30, 40]
 *   Queue view: [20, 30, 40] ← front to back
 *
 * STEP 4: peek()
 *   - Flip stack1 to stack2: stack2 = [40, 30, 20]
 *   - Look at top of stack2: 20 ✓
 *   - Flip back: stack1 = [20, 30, 40]
 *   - Return: 20
 *   Output: 20
 *
 * STEP 5: dequeue()
 *   - Flip stack1 to stack2: stack2 = [40, 30, 20]
 *   - Remove top of stack2: 20 (stack2 now = [40, 30])
 *   - Flip back: stack1 = [30, 40]
 *   - Return: 20
 *   Output: 20
 *
 * STEP 6: peek()
 *   - Flip stack1 to stack2: stack2 = [40, 30]
 *   - Look at top of stack2: 30 ✓
 *   - Flip back: stack1 = [30, 40]
 *   - Return: 30
 *   Output: 30
 *
 * 🎯 KEY CONCEPT:
 * - Stack = LIFO (Last In, First Out) - like a pile of plates
 * - Queue = FIFO (First In, First Out) - like a line at a store
 * - We use TWO stacks to simulate ONE queue by flipping the order!
 * - Flipping stack1 → stack2 reverses the order, making the bottom become the top
 */

