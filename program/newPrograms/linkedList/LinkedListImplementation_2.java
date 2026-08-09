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
            if(head == null && tail == null) {
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
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        int getValueAtIndex(int index) {
            Node temp = head;
            for(int i=0; i<index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        void deleteAt(int index) {
            Node temp = head;
            if(index == 0) {
                head = head.next;
                return;
            }

            int size = sizeOfLL(temp);

            for(int i=0; i<index-1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            if(size == index+1) {
                tail = temp;
            }
        }

        Node nthNodeFromEnd(int index) {
            Node fast = head;
            Node slow = head;
            for(int i=1; i<=index; i++) {
                fast = fast.next;
            }

            while(fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }

        void deleteNthNodeFromEnd(int index) {
            Node fast = head;
            Node slow = head;
            for(int i=1; i<=index; i++) {
                fast = fast.next;
            }

            if(fast == null) {
                head = head.next;
                return;
            }
            while(fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow .next = slow.next.next;
        }

        public static void main(String[] args) {
            LL ll = new LL();
            ll.insertAtEnd(5);
            ll.insertAtEnd(6);
            ll.insertAtEnd(7);
            ll.printLinkedList();
            ll.insertAtPosition(2,8);
            ll.printLinkedList();
            ll.insertAtStart(9);
            ll.printLinkedList();
            ll.insertAtPosition(6,10);
            ll.printLinkedList();
            System.out.println(ll.tail.data);
            System.out.println(ll.getValueAtIndex(3));
            ll.deleteAt(5);
            ll.printLinkedList();
            System.out.println(ll.tail.data);
            Node nthNodeFromEnd = ll.nthNodeFromEnd(2);
            System.out.println("Nth node from end data is :  " + nthNodeFromEnd.data);
            ll.deleteNthNodeFromEnd(2); // removing nth node from end
            ll.printLinkedList();
        }
           
    }

    
}
