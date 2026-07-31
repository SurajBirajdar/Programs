package programs.program.newPrograms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NArrayTree {

    static class NArrTreeNode {
        int data;
        ArrayList<NArrTreeNode> childrens;

        public NArrTreeNode(int data) {
            this.data = data;
            this.childrens = new ArrayList<>();
        }
    }

    public static ArrayList<Integer> nArrayTreeTraversal(NArrTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<NArrTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            NArrTreeNode node = queue.poll();
            res.add(node.data);
            for(NArrTreeNode child : node.childrens) {
                if(child != null) {
                    queue.add(child);
                }
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        NArrTreeNode root = new NArrTreeNode(1);
        NArrTreeNode a = new NArrTreeNode(2);
        NArrTreeNode b = new NArrTreeNode(6);
        NArrTreeNode c = new NArrTreeNode(7);
        NArrTreeNode d = new NArrTreeNode(8);
        NArrTreeNode e = new NArrTreeNode(3);
        NArrTreeNode f = new NArrTreeNode(4);
        NArrTreeNode g = new NArrTreeNode(5);
        NArrTreeNode h = new NArrTreeNode(9);

        root.childrens.add(a);
        root.childrens.add(e);
        root.childrens.add(f);
        root.childrens.add(g);

        a.childrens.add(b);
        a.childrens.add(c);
        a.childrens.add(d);

        g.childrens.add(h);

        ArrayList<Integer> res = nArrayTreeTraversal(root);
        System.out.print(res + " ");

    }
}
