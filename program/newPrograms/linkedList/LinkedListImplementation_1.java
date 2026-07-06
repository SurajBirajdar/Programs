package programs.program.newPrograms.linkedList;

public class LinkedListImplementation_1 {
    public static class Node {
        int data;
        Node next;

        Node(int data)  {
            this.data = data;
        }
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static int lengthOfLL(Node head) {
        Node temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void printRecursionWay(Node head) {
        if(head == null) return;
        System.out.print(head.data + " ");
        printLinkedList(head.next);
    }

    public static void printRecursionWayInReverseOrder(Node head) {
        if(head == null) return;
        printRecursionWayInReverseOrder(head.next);
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(10);
        Node c = new Node(12);
        a.next = b;
        b.next = c;
        printLinkedList(a);
        System.out.println();
        printRecursionWay(a);
        System.out.println();
        printRecursionWayInReverseOrder(a);
    }



}
