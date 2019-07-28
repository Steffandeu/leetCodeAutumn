package TreeRelated.TraceSumCount;

public class Solution {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

    public int CountPathNumber(TreeNode root,int sum){
        if (root==null){
            return 0;
        }
        int ret = CountPathNumberFromRoot(root,sum)+ CountPathNumber(root.left,sum)+CountPathNumber(root.right,sum);
        return ret;
    }

    public int CountPathNumberFromRoot(TreeNode root,int sum){
        int ret = 0;
        if (root==null){
            return 0;
        }
        if (root.val==sum){
            ret++;
        }
        ret += CountPathNumberFromRoot(root,sum)+CountPathNumber(root.left,sum-root.val)+CountPathNumber(root.right,sum-root.val);
        return ret;

    }

}
