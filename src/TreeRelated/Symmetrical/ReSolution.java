package TreeRelated.Symmetrical;

public class ReSolution {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

    public boolean isSymeteric(TreeNode root){
        if (root == null){
            return true;
        }
        return checkNotRoot(root.right,root.left);

    }

    public boolean checkNotRoot(TreeNode node1,TreeNode node2){
        if (node1==null && node2 ==null){
            return true;
        }
        if (node1!=null&& node2!=null && node1.val==node2.val){
            return checkNotRoot(node1.left,node2.right)&&checkNotRoot(node1.right,node1.left);
        }
        return false;


    }


}
