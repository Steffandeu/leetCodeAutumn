package TreeRelated.BalanceBinaryTree;

public class Solution {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }
    private boolean result = true;
    public boolean checkBalance(TreeNode root){
        MaxDepth(root);
        return result;
    }

    private int MaxDepth(TreeNode root){
        if (root ==null){
            return 0;
        }
        int l = MaxDepth(root.left);
        int j = MaxDepth(root.right);
        if (Math.abs(l-j)>1){
            result = false;

        }
        return 1+ Math.max(l,j)+1;
    }
}