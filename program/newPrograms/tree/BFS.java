package programs.program.newPrograms.tree;
import java.util.*;
public class BFS {
    static class TreeNode<E> {
        E data;
        TreeNode left;
        TreeNode right;

        public TreeNode(E data) {
            this.data = data;
        }
    }

    public static ArrayList<Integer> levelOrderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add((Integer) node.data);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(7);
        TreeNode c = new TreeNode(9);
        TreeNode d = new TreeNode(8);
        TreeNode e = new TreeNode(10);
        TreeNode f = new TreeNode(15);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        d.left = f;
        b.left = e;
        ArrayList<Integer> res = levelOrderTraversal(root);
        System.out.print(res + " ");

    }
}
