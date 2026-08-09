package programs.program.newPrograms.linkedList;

public class DoublyLinkedList {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        //if LL is empty
        if(head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            //if more than 1 elements present
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void printLL() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        //if LL is empty
        if(head == null && tail == null) {
            tail = newNode;
            head = newNode;
        } else if(head == tail){
            // single element present
            tail.next = newNode;
            newNode.prev = tail;
        } else {
            // more than 1 element present
            Node temp = head;
            for(int i=1; i<=size-1; i++) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            tail = newNode;
        }
        size++;
    }

    public void insertAtPosition(int position, int data) {
        Node newNode = new Node(data);
        if(position<1 || position > size+1) {
            System.out.println("Invalid input position given");
            return;
        }
        //if LL is empty
        if(head == null && tail== null) {
            head = newNode;
            tail = newNode;
        } else if(position == 1) {
            // if single element
            insertAtHead(data);
        } else if(position == size+1) {
            insertAtTail(data);
        } else {
            Node currNode = head;
            for(int i=1; i<=position-1; i++) {
                currNode = currNode.next;
            }
            Node prevNode = currNode.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = currNode;
            currNode.prev = newNode;
        }
        size++;
    }

    public boolean searchLL(int target) {
        Node temp = head;
        while(temp != null) {
            if(temp.data == target) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    public void updateValue(int oldValue, int newValue) {
        Node temp = head;
        while(temp != null) {
            if(temp.data == oldValue) {
                temp.data = newValue;
                temp = temp.next;
            } else {
                temp = temp.next;
            }
        }
    }

    public void deleteAtHead() {
        if(head == null && tail == null) {
            System.out.println("There is no node to delete");
            return;
        } else if(head == tail) {
            // single element
            head = null;
            tail = null;
        } else {
            //more than 1 element
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void deleteAtTail() {
        // if LL is empty
        if(head == null && tail == null) {
            System.out.println("There is no node to delete");
            return;
        } else if(head == tail) {
            // single element
            head = null;
            tail = null;
        } else {
            //more than 1 element
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void deleteAtPosition(int position) {
        // invalid position
        if(position<1 && position>size+1) {
            System.out.println("Invalid position. Give valid input to delete");
            return;
        }

        //position==1
        else if(position == 1) {
            deleteAtHead();
            return;
        }
        // position == size
        else if(position == size) {
            deleteAtTail();
            return;
        }
        else {
            // more than 1 element and in between somewhere position
            Node currNode = head;
            for(int i=1; i<=position-1; i++) {
                currNode = currNode.next;
            }
            Node prevNode = currNode.prev;
            Node nextNode = currNode.next;;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            currNode.next = null;
            currNode.prev = null;
        }
    }

    static void main() {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insertAtHead(10);
        myList.insertAtHead(40);
        myList.insertAtHead(60);
        myList.printLL();
        myList.insertAtTail(50);
        myList.printLL();
        myList.insertAtTail(70);
        myList.printLL();
        myList.insertAtPosition(3,30);
        myList.printLL();
        System.out.println("Size is: " + myList.size);
        myList.insertAtPosition(7,100);
        myList.printLL();
        myList.insertAtPosition(1,500);
        myList.printLL();
        System.out.println(myList.searchLL(60));
        System.out.println(myList.searchLL(20));
        myList.updateValue(60,90);
        myList.printLL();
        myList.deleteAtHead();
        myList.printLL();
        myList.deleteAtTail();
        myList.printLL();
        myList.deleteAtPosition(3);
        myList.printLL();
        myList.deleteAtPosition(4);
        myList.printLL();
    }
}
