package programs.program.newPrograms.stackLearn;

import java.util.*;

/**
 * ========== STACK USING QUEUES - COMPLETE EXPLANATION ==========
 *
 * WHAT IS A STACK?
 * A Stack is like a stack of plates. You add plates on top and remove from top.
 * This is called LIFO (Last In First Out) - Last thing added comes out first
 * Example: [Bottom] 1 -> 2 -> 3 [Top]  --> Remove 3 first, then 2, then 1
 *
 * WHAT IS A QUEUE?
 * A Queue is like a line at a restaurant. First person in is first person out.
 * This is called FIFO (First In First Out) - First thing added comes out first
 * Example: [Front] 1 -> 2 -> 3 [Back]  --> Remove 1 first, then 2, then 3
 *
 * THE TRICK:
 * We use 2 queues to make a Stack work.
 * Queue1 is where we store elements (acts like stack)
 * Queue2 is temporary storage to rearrange elements
 *
 * ================================================================
 */

class Main {

    // queue1: Main storage - stores elements in STACK order (LIFO)
    // LinkedList is used because it's efficient for adding/removing from both ends
    // Example: queue1 = [3, 2, 1] (3 is at front - will be removed first)
    static Queue<Integer> queue1 = new LinkedList<>();

    // queue2: Temporary storage - helps us rearrange elements during push
    // We move elements here temporarily and then move them back
    static Queue<Integer> queue2 = new LinkedList<>();

    /**
     * PUSH METHOD - Add element to stack
     *
     * How it works:
     * Step 1: Move ALL elements from queue1 to queue2 (reverse the order)
     * Step 2: Add new element to queue1 (becomes top of stack)
     * Step 3: Move ALL elements back from queue2 to queue1 (restore reversed order)
     *
     * Why? Because queues remove from front, but stacks remove from top.
     * This reorganization makes new element come out first (LIFO behavior)
     *
     * Example: Push 30 to stack [10, 20]
     * - Start: queue1 = [10, 20] (10 at front)
     * - Step 1 (move to queue2): queue1 = [], queue2 = [10, 20]
     * - Step 2 (add new): queue1 = [30]
     * - Step 3 (move back): queue1 = [30, 10, 20] (30 at front, will be removed first!)
     *
     * @param element - The number to add to the stack
     */
    public static void push(int element) {
        // Step 1: Transfer all elements from queue1 to queue2
        // This empties queue1 and reverses the order in queue2
        // Example: queue1 has [10, 20] -> move to queue2 as [10, 20]
        while(!queue1.isEmpty()) {
            // queue1.poll() - removes and returns element from FRONT of queue
            // queue2.offer() - adds element to BACK of queue
            queue2.offer(queue1.poll());
        }
        // After loop: queue1 = [] (empty), queue2 = [10, 20]

        // Step 2: Add new element to queue1
        // This new element is now at the front (top of stack)
        // Example: queue1 = [30]
        queue1.offer(element);

        // Step 3: Move all elements from queue2 back to queue1
        // Now queue1 has new element at front, then all old elements behind it
        // Example: queue1 = [30, 10, 20]
        while(!queue2.isEmpty()) {
            // This maintains LIFO order: newest element comes out first
            queue1.offer(queue2.poll());
        }
        // After loop: queue1 = [30, 10, 20], queue2 = [] (empty)
    }

    /**
     * POP METHOD - Remove and return top element from stack
     *
     * LIFO Behavior: Removes the LAST element that was added
     *
     * Example: Pop from [30, 20, 10]
     * - Returns: 30 (was added last)
     * - Remaining: [20, 10]
     *
     * @return the top element of stack, or -1 if stack is empty
     */
    public static int pop() {
        // Check if stack is empty before trying to remove
        // isEmpty() checks if queue1 has no elements
        if(queue1.isEmpty()) {
            // Warn user that stack is empty
            System.out.println("Stack is Empty");
            // Return -1 as error code (indicates failure)
            return -1;
        }

        // queue1.poll() - removes element from FRONT of queue
        // Since we arranged queue1 in LIFO order during push,
        // front element is the top of stack (most recently added)
        // Example: queue1 = [30, 20, 10] -> poll returns 30
        return queue1.poll();
    }

    /**
     * PEEK METHOD - View top element WITHOUT removing it
     *
     * Different from pop(): pop removes the element, peek just looks
     *
     * Example: Peek at [30, 20, 10]
     * - Returns: 30 (top of stack)
     * - Remaining: [30, 20, 10] (unchanged!)
     *
     * @return the top element of stack without removing it, or -1 if empty
     */
    public static int peek() {
        // Check if stack is empty
        if(queue1.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        // queue1.peek() - returns element from FRONT without removing it
        // Compare with poll(): poll() removes, peek() doesn't
        // Example: queue1 = [30, 20, 10] -> peek returns 30, queue1 still = [30, 20, 10]
        return queue1.peek();
    }

    /**
     * ISEMPTY METHOD - Check if stack is empty
     *
     * Useful to check before doing pop or peek operations
     *
     * @return true if stack has no elements, false if has elements
     */
    public static boolean isEmpty() {
        // queue1.isEmpty() returns true if queue has 0 elements, false otherwise
        // Example:
        // - If queue1 = [] then isEmpty() returns true
        // - If queue1 = [10, 20] then isEmpty() returns false
        return queue1.isEmpty();
    }

    /**
     * PRINTLIST METHOD - Display all elements in stack
     *
     * Helpful for debugging and understanding order of elements
     * Shows which element is at top (will be removed first)
     */
    public static void printList() {
        // Prints the entire queue1 contents
        // First element shown is at FRONT (top of stack, removes first)
        // Example output: [30, 20, 10]
        // Means: 30 is at top (removes first), then 20, then 10
        System.out.println(queue1);
    }


    /**
     * MAIN METHOD - Test the Stack implementation
     *
     * This demonstrates how to use the Stack implemented with Queues
     */
    public static void main(String[] args) {
        // SCENARIO: Implementing a stack using two queues
        // We want to add 10, then 20, then 30
        // When we pop, we expect to get 30 first (LIFO behavior)

        // Push 10 onto stack
        // After: stack = [10]
        Main.push(10);

        // Push 20 onto stack
        // After: stack = [20, 10]
        Main.push(20);

        // Push 30 onto stack
        // After: stack = [30, 20, 10]
        Main.push(30);

        // Print entire stack to see arrangement
        // Output: [30, 20, 10]
        // This shows 30 is at top (front), will be removed first
        Main.printList();

        // Pop from stack - removes and prints top element
        // Output: 30 (the last element we added)
        // After: stack = [20, 10]
        System.out.println(Main.pop());

        /**
         * INTERVIEW EXPLANATION:
         *
         * "I've implemented a Stack using two Queues.
         *
         * A Stack is LIFO (Last In First Out) - imagine a stack of plates.
         * A Queue is FIFO (First In First Out) - like waiting in line.
         *
         * I use queue1 for storage and queue2 as temporary buffer.
         *
         * For PUSH: I move all elements to queue2, add new element to queue1,
         * then move everything back. This ensures newest element is at front.
         *
         * For POP: I simply remove from front of queue1 (which is top of stack).
         *
         * In my test:
         * - Push 10, 20, 30
         * - Stack looks like [30, 20, 10] (30 at top)
         * - Pop returns 30 first (LIFO behavior achieved!)"
         */
    }

}
