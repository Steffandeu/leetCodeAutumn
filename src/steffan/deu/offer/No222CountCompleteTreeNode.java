package steffan.deu.offer;

public class No222CountCompleteTreeNode {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public int countNodes(TreeNode root){
        if (root==null){
            return 0;
        }
        return countNodes(root.left)+1+countNodes(root.right);
    }
}
