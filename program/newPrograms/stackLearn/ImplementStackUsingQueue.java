// This line tells Java where this file belongs in your project structure
// Think of it like your home address - it helps Java find this file
package programs.program.newPrograms.stackLearn;

// This line imports (brings in) the LinkedList class from Java's library
// LinkedList is a built-in class that helps us create a list of items
// Example: Like bringing a toolbox from storage to use tools
import java.util.LinkedList;

// This line imports the Queue interface from Java's library
// Queue is like a line at a movie theater - first person in is first person out (FIFO)
// Example: People waiting in line for tickets
import java.util.Queue;

// This line starts defining our class (blueprint) called ImplementStackUsingQueue
// A class is like a blueprint for building something
// public means everyone can use it, class is the keyword to define a blueprint
public class ImplementStackUsingQueue {

    // This creates our first queue (like a waiting line)
    // Queue<Integer> means this queue can only hold whole numbers (integers)
    // queue1 is the name we give to this queue
    // = new LinkedList<>() creates an actual empty queue
    // Think of it like: "Create an empty waiting line called queue1 that holds numbers"
    // Example: queue1 = [] (empty line)
    Queue<Integer> queue1 = new LinkedList<>();

    // This creates our second queue (another waiting line)
    // We use two queues to simulate stack behavior (Last In First Out)
    // queue2 is temporary storage to help us rearrange elements
    // Example: queue2 = [] (empty line)
    Queue<Integer> queue2 = new LinkedList<>();

    // This method adds (pushes) a new element to our stack
    // In a stack, new items go on top (like stacking plates)
    // 'void' means this method doesn't return any value
    // 'int element' means we receive a whole number to add
    // Example: If element = 50, we want to add 50 to the top of our stack
    public void push(int element) {

        // STEP 1: Move all existing elements from queue1 to queue2
        // This while loop keeps running as long as queue1 is not empty
        // !queue1.isEmpty() means "while queue1 has elements"
        // Example: If queue1 = [10, 20, 30], we move all to queue2
        while(!queue1.isEmpty()) {
            // queue1.poll() removes and returns the front element from queue1
            // queue2.offer() adds that element to the back of queue2
            // This line combines both: remove from queue1 and add to queue2
            // Example: If queue1 = [10, 20, 30], after loop queue2 = [10, 20, 30]
            queue2.offer(queue1.poll());
        }

        // STEP 2: Now queue1 is empty, so we add our new element to queue1
        // queue1.offer(element) adds the new element to queue1
        // Since queue1 is empty, this element becomes the first element
        // This ensures the newest element is at the front (stack behavior!)
        // Example: If element = 40, queue1 = [40]
        queue1.offer(element);

        // STEP 3: Move all old elements back from queue2 to queue1
        // This while loop keeps running as long as queue2 is not empty
        // Now we move everything back, putting them after our new element
        // Example: If queue2 = [10, 20, 30], we move them back to queue1
        while(!queue2.isEmpty()) {
            // queue2.poll() removes from front of queue2
            // queue1.offer() adds to back of queue1
            // Result: queue1 = [40, 10, 20, 30] - new element is at front!
            queue1.offer(queue2.poll());
        }
        // Now queue1 has the new element at front (most recent = first to remove)
        // This is how we achieve stack behavior (LIFO - Last In First Out)
    }

    // This method looks at the top element without removing it
    // 'int' means this method returns a whole number
    // In a stack, peek shows you the top item without taking it off
    // Example: Looking at the top plate in a stack without removing it
    public int peek() {
        // Check if queue1 is empty (no elements in our stack)
        // if(queue1.isEmpty()) asks "Is queue1 empty?"
        // Example: If queue1 = [], this is true
        if(queue1.isEmpty()) {
            // Print a message to tell the user the stack is empty
            // System.out.println() displays text on the screen
            // Example: Shows "Stack is empty" on screen
            System.out.println("Stack is empty");
            // return -1 sends back -1 to indicate there's no element
            // -1 is used as an error signal (since we store positive numbers)
            // Example: Like saying "nothing to show"
            return -1;
        }
        // If queue1 is not empty, return the front element
        // queue1.peek() looks at the front element without removing it
        // Since we arranged elements with newest at front, this is the "top" of stack
        // Example: If queue1 = [30, 20, 10], returns 30
        return queue1.peek();
    }

    // This method removes and returns the top element from the stack
    // 'int' means this method returns a whole number
    // In a stack, pop removes the top item and gives it to you
    // Example: Taking the top plate off a stack of plates
    public int pop() {
        // Check if queue1 is empty (no elements to remove)
        // if(queue1.isEmpty()) asks "Is queue1 empty?"
        // Example: If queue1 = [], this is true
        if(queue1.isEmpty()) {
            // Print a message to tell the user the stack is empty
            // System.out.println() displays text on the screen
            // Example: Shows "Stack is empty, there is no element to poll" on screen
            System.out.println("Stack is empty, there is no element to poll");
            // return -1 sends back -1 to indicate there's no element to remove
            // -1 is used as an error signal
            // Example: Like saying "nothing to remove"
            return -1;
        }
        // If queue1 is not empty, remove and return the front element
        // queue1.poll() removes the front element and returns it
        // Since newest element is at front, this removes the "top" of stack
        // Example: If queue1 = [30, 20, 10], removes and returns 30, queue1 becomes [20, 10]
        return queue1.poll();
    }


    // This is the main method - the starting point of our program
    // When you run this program, Java starts here
    // public static void main(String[] args) is required to run a Java program
    // Think of it as the "START" button of your program
    public static void main(String[] args) {

        // Create a new ImplementStackUsingQueue object (instance)
        // This creates an actual stack that we can use
        // 'new' keyword creates a new object
        // ImplementStackUsingQueue() calls the constructor (creates the object)
        // 'stack' is the name we give to this object
        // Example: Like building an actual stack from the blueprint
        ImplementStackUsingQueue stack = new ImplementStackUsingQueue();

        // Push (add) the number 10 to our stack
        // stack.push(10) calls the push method with 10 as input
        // After this: stack looks like [10]
        // Example: Placing first plate (with number 10) on the table
        stack.push(10);

        // Push (add) the number 20 to our stack
        // stack.push(20) calls the push method with 20 as input
        // After this: stack looks like [20, 10] (20 is on top)
        // Example: Placing second plate (with number 20) on top of first plate
        stack.push(20);

        // Push (add) the number 30 to our stack
        // stack.push(30) calls the push method with 30 as input
        // After this: stack looks like [30, 20, 10] (30 is on top)
        // Example: Placing third plate (with number 30) on top of the stack
        stack.push(30);

        // Look at the top element without removing it
        // stack.peek() returns the top element (30)
        // System.out.println() prints it to the screen
        // Output: 30
        // Stack still looks like [30, 20, 10]
        // Example: Looking at the top plate - you see 30
        System.out.println(stack.peek());

        // Remove and return the top element
        // stack.pop() removes the top element (30) and returns it
        // System.out.println() prints the removed element to the screen
        // Output: 30
        // Stack now looks like [20, 10]
        // Example: Taking the top plate off - you get plate with 30
        System.out.println(stack.pop());

        // Look at the new top element without removing it
        // stack.peek() returns the new top element (20)
        // System.out.println() prints it to the screen
        // Output: 20
        // Stack still looks like [20, 10]
        // Example: Looking at the top plate now - you see 20
        System.out.println(stack.peek());
    }


}

/*
 * SUMMARY FOR BEGINNERS:
 *
 * What is a Stack?
 * - A stack is like a stack of plates: Last plate you put on top is the first one you take off
 * - This is called LIFO: Last In, First Out
 * - Example: Stack of books - you add/remove from the top only
 *
 * What is a Queue?
 * - A queue is like a line at a store: First person in line is first to be served
 * - This is called FIFO: First In, First Out
 * - Example: People waiting for a bus - first person in line gets on first
 *
 * The Challenge:
 * - We want stack behavior (LIFO) but we can only use queues (FIFO)
 * - Solution: Use 2 queues and rearrange elements cleverly!
 *
 * How it Works (Push Operation Example):
 * Initial state: queue1 = [10, 20], queue2 = []
 * Want to push 30:
 *
 * Step 1: Move everything to queue2
 *   queue1 = []
 *   queue2 = [10, 20]
 *
 * Step 2: Add new element to queue1
 *   queue1 = [30]
 *   queue2 = [10, 20]
 *
 * Step 3: Move everything back
 *   queue1 = [30, 10, 20]  <- 30 is at front (top of stack!)
 *   queue2 = []
 *
 * Now when we pop(), we remove from front of queue1, which is 30 (most recent)
 * This gives us stack behavior using queues!
 */

