package TreeRelated.Symmetrical;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    boolean isSymmetrical(TreeNode pRoot){
        return checkSysmmterical(pRoot,pRoot);
    }

    public boolean checkSysmmterical(TreeNode node1,TreeNode node2){
        if (node1==null&& node2==null){//同理一直到叶子节点已经没有值
            return true;
        }
        if (node1==null || node2==null){
            return false;
        }
        if (node1.val!=node2.val){
            return false;
        }
        return checkSysmmterical(node1.right,node2.left) && checkSysmmterical(node1.right,node2.left);
    }
}