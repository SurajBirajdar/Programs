package programs.program.newPrograms.linkedList;

// This is our custom Linked List class
public class MyLinkedList {

    // 'head' is a pointer that always points to the first node in the list
    // If list is empty, head will be null
    Node head;

    // Constructor - runs when we create a new LinkedList object
    MyLinkedList() {
        // Initially, the list is empty, so head points to nothing (null)
        this.head = null;
    }

    // Method to insert a new node at the BEGINNING of the list
    public void insertFirst(int data) {
        // Step 1: Create a new node with the given data
        Node newNode = new Node(data);

        // Check if the list is empty (head is null)
        if (head == null) {
            // If empty, the new node becomes the first node (head)
            head = newNode;
            // Print message to show what we inserted
            System.out.println("Data at first position is : " + newNode.data);
            // Exit the method early since we're done
            return;
        }

        // If list is NOT empty:
        // Step 2: Point the new node's 'next' to the current head
        // (so new node points to the old first node)
        newNode.next = head;

        // Step 3: Make the new node as the new head (new first node)
        head = newNode;

        // Print message to show what we inserted
        System.out.println("Data at first position is : " + newNode.data);
    }

    // Method to insert a new node at the END of the list (tail)
    public void insertTail(int data) {
        // Step 1: Create a new node with the given data
        Node newNode = new Node(data);

        // Check if the list is empty
        if(head == null) {
            // If empty, the new node becomes the first node (head)
            head = newNode;
            // Exit the method since we're done
            return;
        }

        // If list is NOT empty:
        // Step 2: Create a temporary pointer starting at head
        // We'll use this to travel through the list
        Node temp = head;

        // Step 3: Keep moving forward until we reach the last node
        // Last node has 'next' = null (no node after it)
        while(temp.next != null) {
            // Move to the next node
            temp = temp.next;
        }

        // Step 4: Now temp is at the last node
        // Attach our new node after the last node
        temp.next = newNode;
    }

    // Method to insert a new node at a SPECIFIC POSITION in the list
    // Position starts from 1 (1 = first position, 2 = second position, etc.)
    public void insertAtPosition(int data, int position) {
        // Counter to track which position we're at while traversing
        int counter = 1;

        // Step 1: Create a new node with the given data
        Node newNode = new Node(data);

        // Step 2: Start from the head of the list
        Node temp = head;

        // Step 3: Move forward until we reach the node BEFORE our target position
        // For example: to insert at position 3, we need to reach position 2
        // We also check temp != null to avoid errors if position is too large
        while(counter < position-1 && temp != null) {
            // Increase the counter (move to next position number)
            counter++;
            // Move to the next node
            temp = temp.next;
        }

        // Step 4: Insert the new node
        // First, point new node's 'next' to the node that comes after temp
        newNode.next = temp.next;

        // Then, point temp's 'next' to our new node
        // Now the new node is inserted between temp and temp's old next
        temp.next = newNode;
    }

    // Method to print all the data in the list from start to end
    public void printList() {
        // Step 1: Start from the head (first node)
        Node temp = head;

        // Step 2: Keep printing until we reach the end (temp becomes null)
        while(temp != null) {
            // Print the data of current node (with a space after it)
            System.out.print(temp.data + " ");
            // Move to the next node
            temp = temp.next;
        }

        // Print a new line after all nodes are printed (for clean output)
        System.out.println();
    }

    // Main method - this is where our program starts running
    public static void main(String[] args) {
        // Create a new empty linked list object
        MyLinkedList obj = new MyLinkedList();

        // Insert 20 at the beginning (List: 20)
        obj.insertFirst(20);

        // Insert 30 at the beginning (List: 30 -> 20)
        obj.insertFirst(30);

        // Print the list (Output: 30 20)
        obj.printList();

        // Insert 40 at the end (List: 30 -> 20 -> 40)
        obj.insertTail(40);

        // Print the list (Output: 30 20 40)
        obj.printList();

        // Insert 60 at position 2 (List: 30 -> 60 -> 20 -> 40)
        obj.insertAtPosition(60,2);

        // Print the list (Output: 30 60 20 40)
        obj.printList();
    }

    // Inner class to represent a single node in the linked list
    public static class Node {
        // 'data' stores the actual value/number in this node
        int data;

        // 'next' is a pointer/reference to the next node in the list
        // If this is the last node, next will be null
        Node next;

        // Constructor to create a new node with given data
        Node(int data) {
            // Set the data for this node
            this.data = data;

            // Initially, this node doesn't point to any other node
            // So next is set to null
            this.next = null;
        }
    }

}
