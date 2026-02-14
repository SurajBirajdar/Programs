// This line declares which package (folder structure) this class belongs to
package programs.program.newPrograms.queueLearn;

// This is our custom Queue class definition
// A Queue works like a line at a store - First In First Out (FIFO)
// The first person who joins the line is the first one to leave
public class MyQueue {

    // 'front' points to the index of the first element in the queue
    // It tells us where to remove elements from (like the front of a line)
    int front;

    // 'rear' points to the index where the next element will be inserted
    // It tells us where to add new elements (like the back of a line)
    int rear;

    // 'size' could track current number of elements (currently not used in this implementation)
    int size;

    // 'capacity' stores the maximum number of elements our queue can hold
    // It's the total capacity/limit of our queue
    int capacity;

    // 'queue' is the actual array that stores all queue elements
    // Think of it as the container holding all values in the queue
    int[] queue;

    // Constructor - This method runs when we create a new MyQueue object
    // It initializes/sets up our queue with a specific maximum capacity
    MyQueue(int capacity) {
        // Store the capacity parameter into our instance variable
        // This tells us the maximum size of our queue
        this.capacity = capacity;

        // Initialize both front and rear to -1
        // -1 means the queue is empty (no elements added yet)
        // We set both at once using: front = rear = -1
        front = rear = -1;

        // Create a new integer array with the specified capacity
        // This array will hold all our queue elements
        queue = new int[capacity];
    }

    // isEmpty() checks if the queue has any elements or not
    // Returns true if empty, false if it contains elements
    public boolean isEmpty() {
        // If front is -1 OR rear is -1, the queue is empty
        // Both would be -1 initially or after all elements are removed
        // We use || (OR) operator - if either condition is true, return true
        return front == -1 || rear == -1;
    }

    // isFull() checks if the queue has reached its maximum capacity
    // Returns true if full, false if there's still space
    public boolean isFull() {
        // Check if rear has reached the last valid index (capacity-1)
        // We use capacity-1 because array indices start from 0
        // Example: capacity=5 means indices 0,1,2,3,4 so last index is 4 (5-1)
        if(rear == capacity-1) {
            // If rear is at the last position, queue is full
            return true;
        }
        // If rear hasn't reached the end, queue is not full
        return false;
    }

    // enqueue() adds/inserts a new element at the rear end of the queue
    // This is like a new person joining the back of a line
    public void enqueue(int element) {
        // First, check if the queue is already full
        if(isFull()) {
            // If full, print error message and stop
            System.out.println("Queue is full. Cannot insert element now");
            // 'return' exits the method immediately without adding the element
            return;
        } else if (isEmpty()){
            // If queue is empty, this is the first element being added
            // Set both front and rear to 0 (first position in array)
            front = rear = 0;

            // Place the element at the rear position (which is 0)
            queue[rear] = element;

            // Move rear forward by 1 to point to the next empty position
            rear++;
        } else {
            // If queue has elements and is not full, add element normally
            // Place the new element at the current rear position
            queue[rear] = element;

            // Move rear forward by 1 to point to the next empty position
            rear++;
        }
    }

    // dequeue() removes the element from the front of the queue
    // This is like the first person in line leaving
    public void dequeue() {
        // First check if the queue is empty
        if(isEmpty()) {
            // If empty, print error message because we can't remove from empty queue
            System.out.println("Queue is already empty so cannot dequeue any element");

            // Reset front and rear to -1 to indicate empty queue
            front = rear = -1;
        } else {
            // If queue has elements, move front pointer forward by 1
            // This effectively "removes" the front element by ignoring it
            // The value still exists in the array but we don't access it anymore
            front++;
        }
    }

    // printQueue() displays all elements currently in the queue
    // It shows elements from front to rear (first to last)
    public void printQueue() {
        // Loop through the queue from front index to rear index
        // i=front is the first element, i<rear means we stop before rear
        // (rear points to the next empty position, not a valid element)
        for(int i= front; i<rear; i++) {
            // Print each element followed by a space (stays on same line)
            System.out.print(queue[i] + " ");
        }
        // After printing all elements, move to a new line for better formatting
        System.out.println();
    }

    // peek() returns the front element without removing it
    // This lets us see who's first in line without making them leave
    // Useful to check what element will be removed next
    public int peek() {
        // Return the element at the front index position
        // This doesn't modify the queue, just looks at the value
        return queue[front];
    }


    // main() method - Entry point where program execution starts
    // This is where we test our queue implementation
    public static void main(String[] args) {
        // Create a new queue object with maximum capacity of 5 elements
        // This queue can hold at most 5 integers
        MyQueue myQueue = new MyQueue(5);

        // Add element 20 to the queue (becomes the first element)
        myQueue.enqueue(20);

        // Check if queue is empty - should print "false" because we just added 20
        System.out.println(myQueue.isEmpty());

        // Check if queue is full - should print "false" because we've only used 1/5 spots
        System.out.println(myQueue.isFull());

        // Display all elements in the queue - should show: 20
        myQueue.printQueue();

        // Add element 30 to the queue (becomes second element, after 20)
        myQueue.enqueue(30);

        // Display all elements - should show: 20 30
        myQueue.printQueue();

        // Remove the front element (20 is removed, 30 becomes new front)
        myQueue.dequeue();

        // Display remaining elements - should show: 30
        myQueue.printQueue();

        // Peek at the front element without removing it - should print: 30
        System.out.println(myQueue.peek());
    }
}
