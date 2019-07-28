package TreeRelated.ReconstructBinaryTree;

public class Solution {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

    /**
     *
     * @param pre 前序遍历
     * @param in 中序遍历
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre,int[] in){
        if (pre ==null || in == null || pre.length ==0 ||in.length==0){//前序和中序其中有一个为空
            return null;
        }
        return buildTree(pre,in,0,pre.length-1,0,in.length-1);
    }
    public TreeNode buildTree(int[] pre,int[] in,int preStart,int preEnd,int inStart,int inEnd){
        TreeNode root = new TreeNode(pre[preStart]);
        int rootIn = 0;
        for ( rootIn = 0; rootIn <in.length ; rootIn++) {
            if (in[rootIn]==root.val){//在中序遍历中找到root的值
                break;
            }
        }
        int leftLength = rootIn-inStart;//左子树的高度
        int rightLength = inEnd-rootIn;//右子树的高度
        if (leftLength>0){
            root.left = buildTree(pre,in,preStart+1,preStart+leftLength,inStart,rootIn-1);
        }
        if (rightLength>0){
            root.right = buildTree(pre,in,preStart+leftLength+1,preEnd,rootIn+1,inEnd);
        }
        return root;
    }
}
