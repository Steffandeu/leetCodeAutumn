package TreeRelated.SonTree;

public class NewSolution {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

    public boolean checkSon(TreeNode t1,TreeNode t2){
        if (t1==null){
            return false;
        }
        return checkSonwithRoot(t1,t2) || checkSon(t1.left,t2) ||checkSon(t1.right,t2);

    }

    public boolean checkSonwithRoot(TreeNode t,TreeNode s){
        if (t==null && s==null){
            return true;
        }
        if (t==null || s==null){
            return false;
        }
        if (t.val!=s.val){
            return false;
        }
        return checkSonwithRoot(s.left,t.left) && checkSonwithRoot(s.right,t.right);
    }
}
