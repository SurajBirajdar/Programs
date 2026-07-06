package programs.program.newPrograms.linkedList;

public class LinkedListImplementation_2 {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class LL {
        Node head = null;
        Node tail = null;

        void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }

        void printLinkedList() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        void insertAtPosition(int position, int data) {
            Node temp = head;
            int counter = 1;
            int size = sizeOfLL(temp);
            if(size == position - 1) {
                insertAtEnd(data);
                return;
            }
            while(counter < position - 1) {
                counter++;
                temp = temp.next;
            }
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }

        int sizeOfLL(Node head) {
            Node temp = head;
            int count = 0;
            while(temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }

        void insertAtStart(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                
            }
        }
           
    }

    
}
