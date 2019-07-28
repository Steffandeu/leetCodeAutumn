package TreeRelated.MirrorTree;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;


        public TreeNode(int val) {
            this.val = val;

        }
    }
    public void Mirror(TreeNode root) {//递归遍历所有的非叶子节点实现，
        if (root!=null){
            return;
        }if (root.left==null&root.right==null){//非叶子节点
            return;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        if (root.left!=null){
            Mirror(root.left);
        }
        if (root.right!=null){
            Mirror(root.right);
        }
    }


}
