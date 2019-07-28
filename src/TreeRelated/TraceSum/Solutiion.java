package TreeRelated.TraceSum;

public class Solutiion {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root,int sum){
        if (root.val==sum){
            return true;
        }
        return hasPathSum(root.left,sum-root.val) ||  hasPathSum(root.right,sum-root.val);
    }
}
