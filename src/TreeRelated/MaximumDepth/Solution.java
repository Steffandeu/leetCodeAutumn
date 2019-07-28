package TreeRelated.MaximumDepth;

public class Solution {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }
    public int MaxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(MaxDepth(root.left),MaxDepth(root.right))+1;
    }

}
