package programs.program.newPrograms.tree;


public class SizeMaxSumHeight  {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    private static void display(Node root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        display(root.left);
        display(root.right);
    }

    public static int size(Node root) {
        if(root == null) return 0;
        return 1+ size(root.left) + size(root.right);
    }

    public static int sum(Node root) {
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    public static int max(Node root) {
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(max(root.left), max(root.right)));
    }



    public static void main(String[] args) {
        Node root = new Node(2);
        Node a = new Node(4);
        Node b = new Node(10);
        root.left = a;
        root.right = b;
        Node c = new Node(6);
        Node d = new Node(5);
        a.left = c;
        a.right = d;
        Node e = new Node(11);
        b.right = e;
        display(root);
        System.out.println();
        System.out.println("size of tree is: " + size(root));
        System.out.println("Sum of tree elements is: " + sum(root));
    }



}
