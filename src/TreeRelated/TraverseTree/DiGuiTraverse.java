package TreeRelated.TraverseTree;



public class DiGuiTraverse {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public void preOrder(TreeNode root){
        if (root==null) return;
        System.out.println("root.val"+ root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root){
        if (root==null) return;
        inOrder(root.left);
        System.out.println("root.val"+root.val);
        inOrder(root.right);
    }

    public void postOder(TreeNode root){
        if (root==null) return;
        postOder(root.left);
        postOder(root.right);
        System.out.println("root.val"+root.val);
    }



}
