// This line tells Java where this file belongs in our project folder structure
package programs.program.newPrograms.stackLearn;

// This is the beginning of our custom Stack class definition
// A Stack is like a stack of plates - you can only add/remove from the top (LIFO - Last In First Out)
public class MyStack {

    // 'top' keeps track of the index position of the topmost element in our stack
    // It's like a pointer that tells us where the last element was added
    int top;

    // 'stack' is an array that actually stores all our stack elements
    // Think of it as the container that holds all the values
    int[] stack;

    // 'size' stores the maximum capacity of our stack
    // It tells us how many elements our stack can hold at most
    int size;

    // This is the constructor - it runs when we create a new MyStack object
    // It sets up/initializes our stack with a specific size
    MyStack(int size) {
        // Store the size parameter into our instance variable
        this.size = size;

        // Initialize top to -1 because our stack is empty at the start
        // -1 means "no elements in the stack yet"
        top = -1;

        // Create a new integer array with 10 spaces to store our stack elements
        // NOTE: This should probably be 'new int[size]' instead of hardcoded 10
        stack = new int[10];
    }

    // push() method adds a new element to the top of the stack
    // Think of it like placing a new plate on top of a stack of plates
    public void push(int element) {
        // Check if stack is full: top reaches (size-1) means all positions are filled
        // We use size-1 because array index starts at 0
        if(top == size-1) {
            // If full, print error message and don't add the element
            System.out.println("Stack is full.");
        } else {
            // If not full, first increment top to point to the next empty position
            top++;

            // Then place the new element at the top position in the array
            stack[top] = element;
        }
    }

    // isEmpty() checks if our stack has any elements or not
    // Returns true if empty, false if it has elements
    public boolean isEmpty() {
        // If top is -1, that means we never added any elements (or removed all)
        if(top == -1) {
            // Print message saying stack is empty
            System.out.println("Stack is empty");

            // Return true to indicate the stack is indeed empty
            return true;
        } else {
            // If top is NOT -1, there are elements in the stack
            System.out.println("Stack is not empty");
        }

        // Return false to indicate stack has elements
        return false;
    }

    // printStack() displays all elements currently in the stack
    // It shows elements from bottom to top (index 0 to top)
    public void printStack() {
        // Loop through the stack array from index 0 to the current top position
        // i=0 is the bottom, i=top is the topmost element
        for(int i=0; i<=top; i++) {
            // Print each element followed by a space (not a new line)
            System.out.print(stack[i] + " ");
        }

        // After printing all elements, move to a new line for better formatting
        System.out.println();
    }

    // pop() removes the topmost element from the stack
    // Think of it like removing the top plate from a stack of plates
    public void pop() {
        // First check if stack is empty using our isEmpty() method
        if(isEmpty()) {
            // If empty, print error message because we can't remove from an empty stack
            System.out.println("Stack is empty, cannot pop any element");
        } else {
            // If not empty, simply decrement top by 1
            // This effectively "removes" the top element by moving the pointer down
            // The old value is still in the array, but we ignore it since it's above 'top'
            top--;
        }
    }

    // main() method is the entry point where program execution begins
    public static void main(String[] args) {
        // Create a new stack object with maximum capacity of 20 elements
        MyStack myStack = new MyStack(20);

        // Add the number 20 to the stack (becomes the first/bottom element)
        myStack.push(20);

        // Display all elements in the stack - should show: 20
        myStack.printStack();

        // Check if stack is empty - should print "Stack is not empty"
        myStack.isEmpty();

        // Add 30 to the stack (becomes second element, on top of 20)
        myStack.push(30);

        // Display all elements - should show: 20 30
        myStack.printStack();

        // Add 40 to the stack (becomes third element, on top of 30)
        myStack.push(40);

        // Display all elements - should show: 20 30 40
        myStack.printStack();

        // Remove the topmost element (40 gets removed)
        myStack.pop();

        // Print a separator line for visual clarity
        System.out.println("-------------");

        // Display remaining elements - should show: 20 30
        myStack.printStack();

        // Remove the topmost element (30 gets removed)
        myStack.pop();

        // Display remaining elements - should show: 20
        myStack.printStack();

        // Remove the topmost element (20 gets removed, stack becomes empty)
        myStack.pop();

        // Display remaining elements - should show nothing (empty line)
        myStack.printStack();

        // Try to remove from empty stack - should print error message
        myStack.pop();

        // Display stack again - should still show nothing (empty line)
        myStack.printStack();

    }
}
