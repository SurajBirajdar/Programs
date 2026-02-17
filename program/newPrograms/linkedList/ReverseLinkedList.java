package programs.program.newPrograms.linkedList;

// This is a program to reverse a linked list
// Example: If linked list is 0 -> 1 -> 2 -> 3 -> 4
// After reversal it becomes: 4 -> 3 -> 2 -> 1 -> 0

public class ReverseLinkedList {

    /**
     * METHOD: printLinkedList - This prints all elements in the linked list
     * Example: If list is 0 -> 1 -> 2, it prints: 0 1 2
     */
    public static void printLinkedList(Node head) {
        // Step 1: Create a temporary pointer 'temp' that starts at the head (beginning) of the list
        // Think of 'temp' as your finger pointing at the first node
        // Example: If list is 0 -> 1 -> 2, temp points to node with data=0
        Node temp = head;

        // Step 2: Loop continues as long as temp is not null (meaning we haven't reached the end)
        // null means "nothing" or "end of list"
        while(temp != null) {
            // Step 3: Print the data stored in the current node
            // Example: First iteration prints "0 ", second prints "1 ", third prints "2 "
            System.out.print(temp.data + " ");

            // Step 4: Move temp to the next node in the list
            // This is like moving your finger to point at the next node
            // Example: temp was pointing at 0, now it points at 1
            temp = temp.next;
        }
        // After the loop, all elements are printed: 0 1 2 3 4
    }


    /**
     * MAIN METHOD: This is where the program starts execution
     */
    public static void main(String[] args) {
        // Step 1: Initialize head as null (empty list at start)
        // 'head' is a pointer to the first node of the linked list
        // Think of it as a bookmark pointing to the beginning of a chain
        Node head = null;

        // Step 2: Initialize tail as null (empty list at start)
        // 'tail' is a pointer to the last node of the linked list
        // This helps us add new nodes at the end quickly
        Node tail = null;

        // Step 3: Create a linked list with 5 nodes containing values 0, 1, 2, 3, 4
        // Loop runs 5 times: i=0, i=1, i=2, i=3, i=4
        for(int i=0; i<5; i++) {
            // Step 3a: Create a new node with data = i
            // Iteration 1: newNode has data=0
            // Iteration 2: newNode has data=1, and so on...
            Node newNode = new Node(i);

            // Step 3b: Check if this is the first node (list is empty)
            if(head == null) {
                // This runs only in the first iteration (i=0)
                // Set both head and tail to point to this first node
                // Now our list looks like: 0
                head = newNode;
                tail = newNode;
            } else {
                // This runs for iterations 2, 3, 4, 5 (i=1,2,3,4)
                // Connect the current tail's next pointer to the new node
                // Example at i=1: 0 -> 1
                // Example at i=2: 0 -> 1 -> 2
                tail.next = newNode;

                // Move tail pointer to the new last node
                // Now tail points to the newest node we just added
                tail = newNode;
            }
        }
        // After loop completes, our linked list is: 0 -> 1 -> 2 -> 3 -> 4

        // Step 4: Reverse the linked list
        // Before: 0 -> 1 -> 2 -> 3 -> 4
        // After:  4 -> 3 -> 2 -> 1 -> 0
        // The reverse method returns the new head (which will be 4)
        head = reverse((head));

        // Step 5: Print the reversed linked list
        // This will print: 4 3 2 1 0
        printLinkedList(head);
    }



    /**
     * METHOD: reverse - This reverses the direction of links in the linked list
     *
     * HOW IT WORKS (Step by step example):
     * Original: 0 -> 1 -> 2 -> 3 -> 4 -> null
     *
     * We need to change the arrows (next pointers) to point backwards:
     * null <- 0 <- 1 <- 2 <- 3 <- 4
     *
     * This makes 4 the new head and 0 the new tail
     */
    public static Node reverse(Node head) {
        // Step 1: Create a 'prev' pointer initialized to null
        // 'prev' will point to the previous node during reversal
        // Initially null because there's no node before the first node
        Node prev = null;

        // Step 2: Create a 'current' pointer that starts at head
        // 'current' is the node we're currently working on
        // Example: current points to node with data=0
        Node current = head;

        // Step 3: Loop continues until we process all nodes
        // Loop runs while current is not null
        while(current != null) {
            // Step 3a: Save the next node before we change the link
            // We need to remember where to go next because we're about to change current.next
            // Example (1st iteration): temp points to node with data=1
            Node temp = current.next;

            // Step 3b: REVERSE THE LINK - Make current node point backwards to prev
            // This is the key step! We're changing the arrow direction
            // Example (1st iteration): Node 0 now points to null instead of 1
            //   Before: 0 -> 1
            //   After:  0 -> null (and we still have temp pointing to 1)
            current.next = prev;

            // Step 3c: Move prev forward to current node
            // Now prev points to the node we just processed
            // Example (1st iteration): prev now points to node with data=0
            prev = current;

            // Step 3d: Move current forward to the next node (which we saved in temp)
            // This moves us to the next node in the original list
            // Example (1st iteration): current now points to node with data=1
            current = temp;
        }
        // After all iterations:
        // Iteration 1: null <- 0    1 -> 2 -> 3 -> 4
        // Iteration 2: null <- 0 <- 1    2 -> 3 -> 4
        // Iteration 3: null <- 0 <- 1 <- 2    3 -> 4
        // Iteration 4: null <- 0 <- 1 <- 2 <- 3    4
        // Iteration 5: null <- 0 <- 1 <- 2 <- 3 <- 4

        // Step 4: Return prev as the new head
        // After the loop, current is null and prev points to the last node (4)
        // This last node is now the new head of the reversed list
        return prev;
    }


    /**
     * INNER CLASS: Node - This represents one element (node) in the linked list
     * Each node contains:
     * 1. data: The actual value stored (like 0, 1, 2, etc.)
     * 2. next: A reference/pointer to the next node in the chain
     */
    public static class Node {
        // Variable to store the actual data/value
        // Example: For first node, data = 0
        int data;

        // Variable to store reference to the next node
        // Example: If current node is 0, next points to the node containing 1
        // If this is the last node, next is null (meaning no more nodes after this)
        Node next;

        /**
         * CONSTRUCTOR: Creates a new node with given data
         * Example: new Node(5) creates a node with data=5 and next=null
         */
        public Node(int data) {
            // Set the data field to the value passed to constructor
            this.data = data;

            // Set next to null (this node doesn't point to anything yet)
            // We'll connect it later using tail.next = newNode
            this.next = null;
        }
    }
}

/*
 * ==================== COMPLETE EXAMPLE WALKTHROUGH ====================
 *
 * Creating the list: 0 -> 1 -> 2 -> 3 -> 4
 *
 * After i=0: head -> [0|null]  (data=0, next=null)
 * After i=1: head -> [0|·] -> [1|null]  (0 points to 1)
 * After i=2: head -> [0|·] -> [1|·] -> [2|null]
 * After i=3: head -> [0|·] -> [1|·] -> [2|·] -> [3|null]
 * After i=4: head -> [0|·] -> [1|·] -> [2|·] -> [3|·] -> [4|null]
 *
 * Reversing the list:
 *
 * Before: head -> 0 -> 1 -> 2 -> 3 -> 4 -> null
 *
 * Iteration 1: prev=null, current=0, temp=1
 *   Action: 0 -> null (reversed first link)
 *   After: null <- 0    1 -> 2 -> 3 -> 4
 *
 * Iteration 2: prev=0, current=1, temp=2
 *   Action: 1 -> 0 (reversed second link)
 *   After: null <- 0 <- 1    2 -> 3 -> 4
 *
 * Iteration 3: prev=1, current=2, temp=3
 *   Action: 2 -> 1 (reversed third link)
 *   After: null <- 0 <- 1 <- 2    3 -> 4
 *
 * Iteration 4: prev=2, current=3, temp=4
 *   Action: 3 -> 2 (reversed fourth link)
 *   After: null <- 0 <- 1 <- 2 <- 3    4
 *
 * Iteration 5: prev=3, current=4, temp=null
 *   Action: 4 -> 3 (reversed fifth link)
 *   After: null <- 0 <- 1 <- 2 <- 3 <- 4
 *
 * Final: new head -> 4 -> 3 -> 2 -> 1 -> 0 -> null
 *
 * Output: 4 3 2 1 0
 */

