package October_practice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class CengciTraverse {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        if (root==null) return res;
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.getFirst();
            deque.pollFirst();
            res.add(node.val);

            if (node.left!=null) deque.addLast(node.left);
            if (node.right!=null) deque.addLast(node.right);
        }
        return res;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
//        deque.add(4);
        deque.add(4);
        deque.add(5);
        deque.addLast(9);
        deque.addLast(10);
        deque.pollFirst();
        for (Integer i: deque
             ) {
            System.out.println(i);

        }
    }
}
