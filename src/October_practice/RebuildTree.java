package October_practice;

public class RebuildTree {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

    public TreeNode rebuileTree(int[] pre,int[] in){
        if (pre==null || in==null || pre.length==0 || in.length==0) return null;
        return bulitTree(pre,in,0,pre.length-1,0,in.length-1);
    }

    public TreeNode bulitTree(int[] pre,int[] in,int preStart,int preEnd,int inStart,int inEnd){
        TreeNode root = new TreeNode(pre[preStart]);
        int rootIn = 0;
        for (rootIn = 0; rootIn < in.length; rootIn++) {
            if (in[rootIn]==root.val){//找到中序遍历的中间值
                break;
            }
        }
        int leftTreeLength =  rootIn-inStart;
        int rightTreeLength = inEnd - rootIn;
        if (leftTreeLength>0){
            root.left = bulitTree(pre,in,preStart+1,preStart+leftTreeLength,inStart,rootIn-1);
        }
        if (rightTreeLength>0){
            root.right=bulitTree(pre,in,preStart+leftTreeLength,preEnd,rootIn+1,inEnd);
        }
        return root;
    }

}
