package steffan.deu.offer.RobProblem;

/**
 * definition of binary tree node
 */

public class No337RobHouse {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public int rob(TreeNode root){
        if (root==null) return 0;
        if (root.left==null && root.right==null) return root.val;
        return Math.max(robDFS(root,true),robDFS(root,false));
    }

    private int robDFS(TreeNode root,boolean vist){
        if (root.left==null && root.right== null){
            return vist ? root.val: 0;
        }
        int left = 0,rigth=0;
        if (vist){
            if (root.left!=null){
                left = robDFS(root.left,!vist);
            }
            if (root.right!=null){
                rigth = robDFS(root.right,!vist);
            }
        }else{
            if (root.left!=null){
                left = Math.max(robDFS(root.left,!vist),robDFS(root.left,vist));
            }
            if (root.right!=null){
                rigth = Math.max(robDFS(root.right,!vist),robDFS(root.right,vist));
            }
        }
        return left +rigth;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        System.out.println(nums.length);
    }

}
