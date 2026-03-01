package programs.program.newPrograms.linkedList;

/*
 * ====== LINKED LIST - TRAIN ANALOGY ======
 * Think of a train with coaches:
 * [10] -> [20] -> [30] -> ENDS
 *
 * Each coach = Node (has data + pointer to next coach)
 * Head = Engine of train (points to 1st coach)
 * Null = No more coaches ahead
 */

// This is our custom Linked List class
public class MyLinkedList {

    /* 'head' = THE TRAIN ENGINE
     * Always points to the FIRST node
     * Example: head -> [10 | pointer] -> [20 | pointer] -> [30 | null]
     * If list is empty: head = null (no train)
     * 'static' means all objects share ONE head (not separate for each object)
     */
    static Node head;

    /* Constructor = Birth of LinkedList object
     * Runs automatically when we type: new MyLinkedList()
     * Like starting with an empty station - no trains yet
     */
    MyLinkedList() {
        /* head = null means EMPTY list, no nodes exist yet
         * Visualize: null (nothing here)
         * Once we add 1st node: head -> [data | pointer]
         */
        this.head = null;
    }

    /* insertFirst(int data) = ADD number at BEGINNING of list
     *
     * PURPOSE: Insert data at position 1 (before all other nodes)
     *
     * EXAMPLE FLOW:
     * Before: head -> [20] -> [30] -> null
     * Call: insertFirst(10)
     * After:  head -> [10] -> [20] -> [30] -> null
     *
     * TIME COMPLEXITY: O(1) - Always takes same time regardless of list size
     *                  (Just 2 pointer changes, no traversal needed)
     * SPACE: O(1) - Create 1 new node
     */
    public void insertFirst(int data) {
        /* Create a NEW NODE object
         * This node will hold the data we want to insert
         * Example: data = 10, creates Node object with 10 inside
         */
        Node newNode = new Node(data);

        /* QUESTION: Is the list empty?
         * Check: Does head == null?
         * If YES: This is the 1ST node ever (list completely empty)
         * If NO: List already has nodes, we insert before them
         */
        if (head == null) {
            /* CASE 1: LIST IS EMPTY (First node being added)
             * This new node becomes THE HEAD (first and only node)
             * Visual: null -> becomes -> head -> [10 | null]
             */
            head = newNode;

            /* Print confirmation
             * Output: "Data at first position is : 10"
             */
            System.out.println("Data at first position is : " + newNode.data);

            /* RETURN = Stop executing immediately
             * We're done with this function, skip remaining code
             * Why? Because the node is already in place, nothing more needed
             */
            return;
        }

        /* CASE 2: LIST IS NOT EMPTY (more nodes already exist)
         * Current state: head -> [20] -> [30] -> null
         * Goal: Insert new node at beginning
         * Target: head -> [10] -> [20] -> [30] -> null
         */

        /* STEP 1: Connect the new node to the current first node
         * Tell newNode: "The node after you will be the current head"
         *
         * Before this line:
         * newNode.next = null (nothing after it yet)
         * head -> [20] (head points to 20)
         *
         * After this line:
         * newNode.next = [20] (newNode now points to 20)
         * Visual: newNode -> [20] -> [30] -> null
         */
        newNode.next = head;

        /* STEP 2: Make new node the HEAD (new first node)
         * Tell the system: "newNode is now the first node"
         * Change who the head (engine) points to
         *
         * Before: head -> [20] -> [30] -> null
         * After:  head -> [10] -> [20] -> [30] -> null
         *
         * Now newNode is at the beginning!
         */
        head = newNode;

        /* Print confirmation message
         * Output: "Data at first position is : 10"
         */
        System.out.println("Data at first position is : " + newNode.data);
    }

    /* insertTail(int data) = ADD number at END of list
     *
     * PURPOSE: Insert data at the last position (after all existing nodes)
     *
     * EXAMPLE FLOW:
     * Before: head -> [10] -> [20] -> null
     * Call: insertTail(30)
     * After:  head -> [10] -> [20] -> [30] -> null
     *
     * TIME COMPLEXITY: O(n) - We must traverse from head to tail
     *                  Takes longer with bigger lists
     * SPACE: O(1) - Create 1 new node
     *
     * USE CASE: Adding at end (like appending to a to-do list)
     */
    public void insertTail(int data) {
        /* Step 1: Create a new node with the data
         * This node will be added at the end
         * Example: data = 30, creates Node with 30
         */
        Node newNode = new Node(data);

        /* Step 2: Check if list is EMPTY
         * If YES: The new node becomes the first (and only) node
         * If NO: We need to find the last node and attach new node there
         */
        if(head == null) {
            /* LIST IS EMPTY! This is the first node
             * Visual: null -> head -> [30 | null]
             */
            head = newNode;

            /* Exit here, we're done
             * No need to traverse, already inserted
             */
            return;
        }

        /* Step 3: LIST IS NOT EMPTY!
         * We need to find the LAST node (the one whose next is null)
         *
         * Current state: head -> [10] -> [20] -> null
         * Goal: Find the node pointing to null (which is [20])
         * Then attach our new node after it
         */

        /* Create a temporary pointer 'temp' starting at head
         * temp = temp pointer that we'll move forward
         * head = the permanent first node (doesn't change)
         *
         * Why temp? Because we need to traverse, but don't want to lose head
         * If we changed head, we'd lose track of the beginning!
         *
         * Example: If head -> [10], then temp starts at [10]
         */
        Node temp = head;

        /* While LOOP: Keep moving forward until we reach LAST node
         * CONDITION: temp.next != null (as long as there's a node after temp)
         * WHEN it stops: When temp.next == null (no more nodes, we're at end)
         *
         * Visual walkthrough for list [10] -> [20] -> null:
         * Iteration 1: temp = [10], temp.next = [20] (not null, continue)
         *             temp moves to [20]
         * Iteration 2: temp = [20], temp.next = null (IS null, stop loop)
         * After loop: temp points to [20] (the last node)
         */
        while(temp.next != null) {
            /* MOVE TO NEXT NODE
             * temp currently at node X
             * temp.next = node Y (node after X)
             * Set temp = Y (move temp forward to Y)
             *
             * Example:
             * Before: temp -> [10], temp.next -> [20]
             * After:  temp -> [20], temp.next -> null
             * Next iteration: Stop! (because temp.next is null)
             */
            temp = temp.next;
        }

        /* AFTER LOOP: temp is now at the LAST NODE
         * temp.next = null (there's no node after it)
         *
         * Now attach our new node to the end
         * Visual before: ... -> temp -> null
         * Visual after:  ... -> temp -> newNode -> null
         */
        temp.next = newNode;

        /* That's it! New node is now at the end
         * Final list: head -> [10] -> [20] -> [30] -> null
         * The newNode has next = null (already set in constructor)
         */
    }

    /* insertAtPosition(int data, int position) = ADD number at SPECIFIC POSITION
     *
     * PURPOSE: Insert data at a particular position in the list
     * Position counting: 1 = first, 2 = second, 3 = third, etc.
     *
     * EXAMPLE FLOW:
     * Before: head -> [10] -> [20] -> [30] -> null
     *         Pos:   1      2      3      4
     * Call: insertAtPosition(15, 2)
     * After:  head -> [10] -> [15] -> [20] -> [30] -> null
     *         Pos:   1      2      3      4      5
     *
     * TIME COMPLEXITY: O(n) - Must traverse to the position
     * SPACE: O(1) - Create 1 new node
     *
     * USE CASE: Insert in the middle (like inserting into a ranked list)
     */
    public void insertAtPosition(int data, int position) {
        /* STEP 1: Create a counter starting at 1
         * We use this to track which position we're currently at
         *
         * Example:
         * counter = 1 (we're at position 1)
         * As we move forward, counter increases: 2, 3, 4...
         * We stop when counter reaches the position before our target
         */
        int counter = 1;

        /* STEP 2: Create a new node with the given data
         * This node will be inserted at the specified position
         * Example: data = 15, creates Node with 15
         */
        Node newNode = new Node(data);

        /* STEP 3: Create temp pointer starting at head
         * temp = starting point for our traversal
         * head = remains unchanged (always points to 1st node)
         *
         * Example: If list is [10] -> [20] -> [30]
         *          head and temp both point to [10]
         */
        Node temp = head;

        /* STEP 4: WHILE LOOP - Move forward until we reach the node BEFORE target
         *
         * KEY INSIGHT: To insert at position 3, we need to stop at position 2!
         * Why? Because position 2 node's 'next' should point to our new node
         *
         * CONDITIONS:
         * 1. counter < position-1: Keep moving while we haven't reached the node before
         * 2. temp != null: Safety check - stop if we run out of nodes
         *
         * EXAMPLE (insert at position 3):
         * List: [10] -> [20] -> [30] -> null
         * Pos:  1     2     3
         * Want to insert at position 3
         * So we need: position - 1 = 3 - 1 = 2
         * Stop when counter = 2 (at [20])
         *
         * Loop walkthrough:
         * Start: temp = [10], counter = 1
         * Check: 1 < 2? YES, continue
         * Iteration 1: counter++, temp moves to [20]
         * Check: 2 < 2? NO, stop loop
         * Result: temp is now at position 2 ([20])
         */
        while(counter < position-1 && temp != null) {
            /* Increment counter: We're moving to the next position
             * Example: counter was 1, now becomes 2
             */
            counter++;

            /* Move temp forward to next node
             * Before: temp = [10], temp.next = [20]
             * After:  temp = [20], temp.next = [30]
             */
            temp = temp.next;
        }

        /* AFTER LOOP: temp is now at the node BEFORE our insertion point
         *
         * EXAMPLE (insert at position 3 in [10] -> [20] -> [30]):
         * temp is at [20]
         * temp.next = [30]
         *
         * Now we need to:
         * 1. Make newNode.next point to [30] (what came after temp)
         * 2. Make temp.next point to newNode
         * Result: [10] -> [20] -> [new] -> [30]
         */

        /* CRUCIAL STEP A: Connect new node to what comes AFTER temp
         *
         * Visual before:
         * temp -> [20] -> next pointer -> [30]
         *
         * Visual after:
         * newNode.next = [30]
         * temp -> [20] -> still points to [30] (not changed yet)
         *
         * This is important! We save the "old next" before changing it
         */
        newNode.next = temp.next;

        /* CRUCIAL STEP B: Connect temp to the new node
         * Now we insert the new node into the chain
         *
         * Before: temp -> [20] ---> [30]
         * After:  temp -> [20] -> [new] -> [30]
         *
         * temp.next now points to newNode
         * newNode.next already points to [30]
         * Perfect! New node is sandwiched in between
         *
         * FINAL RESULT:
         * [10] -> [20] -> [new] -> [30] -> null
         */
        temp.next = newNode;
    }

    /* printList() = DISPLAY all data in the linked list
     *
     * PURPOSE: Show all the numbers in the list from beginning to end
     *
     * EXAMPLE:
     * List: head -> [10] -> [20] -> [30] -> null
     * Output: 10 20 30
     * (each number separated by a space, then new line)
     *
     * TIME COMPLEXITY: O(n) - Must visit every node once
     * SPACE: O(1) - No extra space needed, just reading
     *
     * USE CASE: Debugging, showing results, verifying list contents
     */
    public void printList() {
        /* STEP 1: Create a temporary pointer starting at head
         * temp = pointer to traverse the list
         * head = remains unchanged (still points to 1st node)
         *
         * Why use temp?
         * Because if we used head directly, we might lose track of the beginning!
         * temp allows us to move forward without affecting head
         *
         * Example:
         * List: head -> [10] -> [20] -> [30]
         * temp points to [10] initially
         */
        Node temp = head;

        /* STEP 2: WHILE LOOP - Keep going through list until we reach the end
         *
         * CONDITION: temp != null
         * - Continue: temp still points to a valid node (not null)
         * - Stop: temp becomes null (we've passed the last node)
         *
         * EXAMPLE (List: [10] -> [20] -> [30] -> null):
         * Iteration 1: temp = [10], print "10 ", temp.next = [20]
         * Iteration 2: temp = [20], print "20 ", temp.next = [30]
         * Iteration 3: temp = [30], print "30 ", temp.next = null
         * Iteration 4: temp = null, STOP! (condition fails)
         */
        while(temp != null) {
            /* Print the data of current node
             * System.out.print() = print WITHOUT new line (stays on same line)
             *
             * What happens:
             * temp.data = the number stored in current node
             * Print it with a space after: "10 "
             *
             * Example progression:
             * "10 " (after 1st node)
             * "10 20 " (after 2nd node)
             * "10 20 30 " (after 3rd node)
             */
            System.out.print(temp.data + " ");

            /* Move temp to the next node
             * Before: temp -> [10], temp.next -> [20]
             * After:  temp -> [20], temp.next -> [30]
             *
             * Loop continues with temp now pointing to next node
             */
            temp = temp.next;
        }

        /* STEP 3: Print a new line after all nodes printed
         * System.out.println() = print a fresh new line
         *
         * Why separate?
         * The while loop only prints spaces between numbers
         * After all numbers, we want to move to the next line
         *
         * Output example:
         * "10 20 30 " (from while loop)
         * Then println() adds a newline
         * So next print starts on new line
         *
         * Final output appearance:
         * 10 20 30
         * (cursor moves to next line)
         */
        System.out.println();
    }

    /* main() = THE ENTRY POINT - Where program starts executing
     *
     * PURPOSE: Test all the linked list operations we built
     * Run this as a Java program, this method automatically starts
     *
     * FLOW: Create a list, insert elements, print results, test special methods
     */
    public static void main(String[] args) {
        /* STEP 1: Create a new empty linked list object
         * MyLinkedList obj = new MyLinkedList()
         *
         * What happens:
         * 1. Creates new MyLinkedList instance
         * 2. Calls the constructor (sets head = null)
         * 3. List is now empty, ready for insertions
         *
         * Visual: obj -> LinkedList { head = null }
         */
        MyLinkedList obj = new MyLinkedList();

        /* STEP 2: Insert 20 at the beginning
         * obj.insertFirst(20)
         *
         * What happens:
         * - Creates Node with data=20
         * - List is empty (head=null), so this becomes 1st node
         * - head -> [20 | null]
         * Output: "Data at first position is : 20"
         */
        obj.insertFirst(20);

        /* STEP 3: Insert 30 at the beginning
         * obj.insertFirst(30)
         *
         * What happens:
         * - Creates Node with data=30
         * - List NOT empty (has [20])
         * - newNode.next = head ([20])
         * - head = newNode ([30])
         * Result: head -> [30 | next] -> [20 | null]
         * Output: "Data at first position is : 30"
         */
        obj.insertFirst(30);

        /* STEP 4: Print the list
         * obj.printList()
         *
         * Traverses from head: [30] -> [20]
         * Prints each number with space
         * Output: "30 20 " then newline
         *
         * Current list state:
         * head -> [30] -> [20] -> null
         */
        obj.printList();

        /* STEP 5: Insert 40 at the end (tail)
         * obj.insertTail(40)
         *
         * What happens:
         * - Creates Node with data=40
         * - List NOT empty, so traverse to find last node
         * - Start: temp = [30]
         * - Check: [30].next = [20] (not null), move temp to [20]
         * - Check: [20].next = null (IS null, stop)
         * - Attach [40] after [20]
         * Result: head -> [30] -> [20] -> [40] -> null
         */
        obj.insertTail(40);

        /* STEP 6: Print the list again
         * obj.printList()
         *
         * Traverses: [30] -> [20] -> [40]
         * Output: "30 20 40 " then newline
         *
         * Current list state:
         * head -> [30] -> [20] -> [40] -> null
         */
        obj.printList();

        /* STEP 7: Insert 60 at position 2
         * obj.insertAtPosition(60, 2)
         *
         * What happens:
         * - Creates Node with data=60
         * - counter=1, temp=[30]
         * - Loop condition: 1 < 2-1 (1 < 1)? NO, stop immediately
         * - temp still at [30]
         * - newNode.next = temp.next = [20]
         * - temp.next = newNode = [60]
         * Result: head -> [30] -> [60] -> [20] -> [40] -> null
         *
         * Visual transformation:
         * Before: [30] -> [20] -> [40]
         * After:  [30] -> [60] -> [20] -> [40]
         */
        obj.insertAtPosition(60, 2);

        /* STEP 8: Insert 70 at the end
         * obj.insertTail(70)
         *
         * What happens:
         * - Creates Node with data=70
         * - Traverse: [30]->[60]->[20]->[40], temp stops at [40]
         * - [40].next = [70]
         * Result: head -> [30] -> [60] -> [20] -> [40] -> [70] -> null
         */
        obj.insertTail(70);

        /* STEP 9: Print the list final state
         * obj.printList()
         *
         * Traverses: [30] -> [60] -> [20] -> [40] -> [70]
         * Output: "30 60 20 40 70 " then newline
         *
         * Final list state:
         * head -> [30] -> [60] -> [20] -> [40] -> [70] -> null
         */
        obj.printList();

        /* STEP 10: Find the middle node
         * Node middleNode = middleOfLinkedList(head)
         *
         * What happens:
         * - Uses two pointers: slow (1 step) and fast (2 steps)
         * - When fast reaches end, slow is at middle
         * - List has 5 nodes: [30]-[60]-[20]-[40]-[70]
         * - Middle node = [20] (3rd node out of 5)
         */
        Node middleNode = middleOfLinkedList(head);

        /* Print the middle node's data
         * middleNode.data = 20
         * Output: "20"
         */
        System.out.println(middleNode.data);

        /* STEP 11: Detect if there's a cycle
         * boolean hasCycle = detectCycle(head)
         *
         * What happens:
         * - Checks if list has a cycle (loop back to itself)
         * - Current list: [30]-[60]-[20]-[40]-[70]->null
         * - NO cycle detected (ends at null)
         * - Returns: false
         * Output: "false"
         */
        System.out.println(detectCycle(head));
    }

    /* ====== NODE CLASS ======
     *
     * WHAT IS A NODE?
     * A Node is like a COACH in a train!
     *
     * Each coach has:
     * 1. DATA: The cargo/passenger (the number we want to store)
     * 2. NEXT: A connection to the next coach (pointer to next Node)
     *
     * EXAMPLE VISUALIZATION:
     * One Node:
     * +--------+---------+
     * | data:5 | next:[] |----> (points to next node)
     * +--------+---------+
     *
     * Think of it like:
     * [Box with 5 inside] [Arrow pointing to next box]
     */
    public static class Node {
        /* 'data' = STORAGE for the actual value
         *
         * What it stores:
         * - int data: An integer number (whole number like 5, 10, 20, -30, etc.)
         *
         * EXAMPLES:
         * Node myNode -> data = 42 (the node holds number 42)
         * Node myNode -> data = 100 (the node holds number 100)
         * Node myNode -> data = -5 (the node holds number -5)
         *
         * Like a box with a number written on it!
         * Box with "42" written inside
         */
        int data;

        /* 'next' = POINTER to the NEXT NODE
         *
         * What it does:
         * - Node next: Points to the next Node object (or null if last node)
         *
         * EXAMPLES:
         * If we have: [Node1] -> [Node2] -> [Node3]
         * - Node1.next points to Node2
         * - Node2.next points to Node3
         * - Node3.next points to null (no more nodes)
         *
         * Like an arrow connecting boxes in a train!
         * [Box1] ---arrow---> [Box2] ---arrow---> [Box3]
         *
         * WHY IS IT CALLED 'next'?
         * Because it literally points to the NEXT node in sequence!
         *
         * Special case (last node):
         * [Box3].next = null (no box after this one)
         */
        Node next;

        /* Node(int data) = CONSTRUCTOR
         *
         * PURPOSE: Create a new Node object with the given data
         * Called automatically when we write: new Node(5)
         *
         * ANALOGY: Blueprint for creating a train coach
         * When you want a new coach, you specify what cargo to put in it
         *
         * EXAMPLE:
         * Node myNode = new Node(42)
         * - Creates a new Node
         * - Sets data = 42
         * - Sets next = null (no node attached yet)
         *
         * Visual result:
         * myNode: [42 | null] (data=42, no next node yet)
         */
        Node(int data) {
            /* Set the data field to the parameter value
             *
             * What happens:
             * this.data = the instance variable 'data'
             * data = the parameter passed to constructor
             *
             * EXAMPLE:
             * new Node(25)
             * this.data = 25 (set our data to 25)
             *
             * ANALOGY:
             * I have a box, I put the number 25 in it
             * this.data (my box's content) = 25 (the number)
             */
            this.data = data;

            /* Set next to null (initially)
             *
             * What happens:
             * When a new node is created, it's alone at first
             * It doesn't point to any other node
             * this.next = null (no connection yet)
             *
             * EXAMPLE:
             * new Node(25)
             * Result: [25 | null] (data=25, no next node)
             *
             * WHY null?
             * Because this node is just created, not linked to anything yet!
             * Later, we'll change 'next' to point to other nodes
             *
             * ANALOGY:
             * A new train coach is created alone
             * No coach connected after it yet (next = null)
             * Later, we'll attach it to other coaches
             */
            this.next = null;
        }
    }

    /* middleOfLinkedList(Node head) = FIND THE MIDDLE NODE
     *
     * PURPOSE: Return the node at the middle of the linked list
     *
     * ALGORITHM: TWO POINTERS (Slow and Fast)
     * ANALOGY: Tortoise and Hare race!
     * - Tortoise (slow): Moves 1 step at a time (slowly)
     * - Hare (fast): Moves 2 steps at a time (quickly)
     * - When hare reaches the end, tortoise is at the middle!
     *
     * EXAMPLE:
     * List: [10] -> [20] -> [30] -> [40] -> [50] -> null
     * Pos:  1     2     3     4     5
     * Middle = position 3 = [30]
     *
     * HOW IT WORKS:
     * Start: slow=[10], fast=[10]
     * Step1: slow=[20], fast=[30]  (fast moves 2, slow moves 1)
     * Step2: slow=[30], fast=[50]  (fast moved 2 more, slow moved 1 more)
     * Step3: slow=[40], fast=null  (fast.next.next is null, STOP!)
     * Result: slow is now at the middle!
     *
     * TIME COMPLEXITY: O(n) - Visit each node once
     * SPACE: O(1) - Just two pointers, no extra space
     *
     * USE CASE: Finding middle element for splitting, testing algorithms
     */
    public static Node middleOfLinkedList(Node head) {
        /* STEP 1: Create 'slow' pointer pointing to head
         * slow = TORTOISE that moves 1 step at a time
         *
         * Visual:
         * slow
         *  ↓
         * [10] -> [20] -> [30] -> [40] -> [50] -> null
         */
        Node slow = head;

        /* STEP 2: Create 'fast' pointer pointing to head
         * fast = HARE that moves 2 steps at a time
         *
         * Visual:
         * fast
         *  ↓
         * [10] -> [20] -> [30] -> [40] -> [50] -> null
         */
        Node fast = head;

        /* STEP 3: WHILE LOOP - Keep moving until fast reaches the end
         *
         * CONDITIONS:
         * 1. fast != null: There's a node where fast is pointing
         * 2. fast.next != null: There's a node AFTER where fast is pointing
         *    (This allows fast to move 2 steps without going past the end)
         *
         * WHY these conditions?
         * - If fast == null: No node here, can't move 2 steps
         * - If fast.next == null: Only 1 node ahead, can't move 2 steps
         * - So we check: Is there a node 2 steps ahead? If YES, continue
         *
         * WHEN TO STOP:
         * When fast reaches null or fast.next reaches null (approaching the end)
         * At that point, slow is at the middle!
         *
         * EXAMPLE walkthrough for list [10]-[20]-[30]-[40]-[50]:
         * Start:
         *   slow -> [10]
         *   fast -> [10]
         *
         * Check: fast != null? YES ([10])
         *        fast.next != null? YES ([20])
         *   -> ENTER LOOP
         *
         * Iteration 1:
         *   slow = slow.next -> [20]
         *   fast = fast.next.next -> [30] (skipped [20])
         *   Check: fast != null? YES ([30])
         *          fast.next != null? YES ([40])
         *   -> CONTINUE
         *
         * Iteration 2:
         *   slow = slow.next -> [30] (NOW AT MIDDLE!)
         *   fast = fast.next.next -> [50] (skipped [40])
         *   Check: fast != null? YES ([50])
         *          fast.next != null? NO (null)
         *   -> EXIT LOOP (can't take 2 more steps)
         *
         * Result: slow -> [30] (the middle node!)
         */
        while(fast != null && fast.next != null) {
            /* Move slow pointer 1 step forward
             * slow goes to the next node
             *
             * Before: slow -> [10], slow.next -> [20]
             * After:  slow -> [20], slow.next -> [30]
             *
             * ANALOGY: Tortoise moves 1 step forward on the track
             */
            slow = slow.next;

            /* Move fast pointer 2 steps forward
             * fast.next = skip 1 node
             * fast.next.next = skip 2 nodes total
             *
             * Before: fast -> [10], fast.next.next -> [30]
             * After:  fast -> [30], fast.next.next -> [50]
             *
             * ANALOGY: Hare jumps 2 steps forward on the track
             */
            fast = fast.next.next;
        }

        /* AFTER LOOP: slow pointer is at the MIDDLE
         *
         * Return the slow pointer (which is now at middle node)
         * EXAMPLE: For list [10]-[20]-[30]-[40]-[50]
         * Returns the Node containing 30 (the middle)
         *
         * ANALOGY: When hare reaches the finish, tortoise is at the middle!
         */
        return slow;
    }

    /* detectCycle(Node head) = CHECK IF THERE'S A CYCLE/LOOP IN THE LIST
     *
     * PURPOSE: Detect if the linked list has a cycle
     * A cycle = when a node points back to a previous node (creates a loop)
     *
     * ANALOGY:
     * Normal list = a straight road from start to finish (ends at null)
     * Cycled list = a circular track (ends back at starting point!)
     *
     * EXAMPLE OF CYCLE:
     * Normal: [10] -> [20] -> [30] -> null (safe, no cycle)
     * Cycled: [10] -> [20] -> [30] -> points back to [10] (CYCLE!)
     *         ↑______________________________↓
     *
     * ALGORITHM: TWO POINTERS (Tortoise and Hare)
     * - Same idea as finding middle!
     * - If there's NO cycle: fast pointer reaches null (end of list)
     * - If there's a CYCLE: fast and slow pointers will MEET (same position)
     *   Because in a cycle, fast will eventually lap slow!
     *
     * WHY THIS WORKS:
     * In a cycle, fast moves 2 steps while slow moves 1 step
     * The difference increases each iteration
     * Eventually, they'll be at the same node = CYCLE DETECTED!
     *
     * EXAMPLE WITH CYCLE:
     * List: [10] -> [20] -> [30] -> [40] -> points back to [20]
     *                       ↑__________________↓
     *
     * Start: slow=[10], fast=[10]
     * Step1: slow=[20], fast=[30]
     * Step2: slow=[30], fast=[20]  (fast went [40]->[20])
     * Step3: slow=[40], fast=[40]  (fast went [20]->[30]->[40])
     * Step4: slow=[20], fast=[30]  (both cycling now)
     * Step5: slow=[30], fast=[20]
     * Step6: slow=[40], fast=[40]  (THEY MEET! CYCLE FOUND!)
     *
     * TIME COMPLEXITY: O(n) - At most visit each node once
     * SPACE: O(1) - Just two pointers
     *
     * USE CASE: Detecting infinite loops, memory leak detection
     *
     * RETURN VALUES:
     * - true: Cycle detected (slow == fast)
     * - false: No cycle (fast reached null/end)
     */
    public static boolean detectCycle(Node head) {
        /* STEP 1: Create 'slow' pointer starting at head
         * slow = TORTOISE that moves 1 step at a time
         */
        Node slow = head;

        /* STEP 2: Create 'fast' pointer starting at head
         * fast = HARE that moves 2 steps at a time
         */
        Node fast = head;

        /* STEP 3: WHILE LOOP - Keep moving until we find cycle or reach end
         *
         * CONDITIONS:
         * 1. fast != null: fast pointer points to a valid node
         * 2. fast.next != null: there's a node after fast (safe to move 2 steps)
         *
         * WHAT HAPPENS:
         * If NO cycle: fast reaches null first, loop stops, return false
         * If CYCLE: slow and fast will eventually meet, loop continues until they match
         *
         * EXAMPLE (Normal list without cycle: [10] -> [20] -> [30] -> null):
         * Start: slow=[10], fast=[10]
         * Check: fast != null? YES, fast.next != null? YES
         * Step1: slow=[20], fast=[30]
         * Check: fast != null? YES, fast.next != null? NO (next is null)
         * -> STOP (no more 2-step moves possible)
         * slow ≠ fast, so return false (no cycle)
         *
         * EXAMPLE (List with cycle: [10] -> [20] -> [30] -> back to [20]):
         * Start: slow=[10], fast=[10]
         * Step1: slow=[20], fast=[30]
         * Step2: slow=[30], fast=[20] (fast cycled back)
         * Step3: slow=[20], fast=[30]
         * Step4: slow=[30], fast=[20]
         * (pattern repeats, but eventually...)
         * Step N: slow=[20], fast=[20] (THEY MEET!)
         * return true (cycle detected!)
         */
        while(fast != null && fast.next != null) {
            /* Move slow pointer 1 step forward
             * slow = slow.next (go to next node)
             *
             * Example:
             * Before: slow -> [10]
             * After:  slow -> [20]
             *
             * In a cycle, slow will go around and around
             * In normal list, slow will eventually hit null
             */
            slow = slow.next;

            /* Move fast pointer 2 steps forward
             * fast = fast.next.next (skip one node, move to the next)
             *
             * Example:
             * Before: fast -> [10]
             * After:  fast -> [30] (jumped over [20])
             *
             * In a cycle, fast will lap around faster than slow
             * Eventually they'll be at same node = CYCLE!
             */
            fast = fast.next.next;

            /* CRUCIAL CHECK: Do slow and fast point to the SAME node?
             *
             * If slow == fast:
             * Both pointers are at the same location!
             * This is impossible unless there's a cycle
             * (In a normal list without cycle, fast would reach null first)
             *
             * RETURN TRUE IMMEDIATELY = CYCLE FOUND!
             *
             * Example:
             * slow points to Node [20]
             * fast also points to Node [20]
             * slow == fast? YES! Return true!
             */
            if(slow == fast) {
                /* CYCLE DETECTED!
                 * We found that slow and fast point to the same node
                 * This only happens in a cyclic list
                 *
                 * Example output: "true"
                 */
                return true;
            }
        }

        /* AFTER LOOP: fast reached null without meeting slow
         *
         * This means the list is normal (no cycle)
         * fast was able to reach the end (null)
         * slow and fast never met
         *
         * NO CYCLE FOUND! Return false
         *
         * Example:
         * List: [10] -> [20] -> [30] -> null
         * fast reached null
         * slow never caught up
         * return false (no cycle)
         */
        return false;
    }


}
