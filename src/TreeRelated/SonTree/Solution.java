package TreeRelated.SonTree;

public class Solution {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }
    public boolean HasStubtree(TreeNode root1,TreeNode root2){
        boolean result = false;
        //1 step:在树A中找到和树B的更节点一样的节点R//递归来遍历
        if (root1!=null && root2!=null){
            if (root1.val==root2.val){
                result = DoesTree1HaveTree2(root1,root2);
            }
            if (!result){
                result = HasStubtree(root1.left,root2);
            }
            if (!result){
                result = HasStubtree(root1.right,root2);
            }

        }
        return result;
    }
    public boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){
        if (root2==null){
            return true;
        }
        if (root1==null && root2!=null){
            return false;
        }
        if (root1.val!=root2.val){
            return false;
        }
        //三个不的情况，一直到root2没有根节点的情况
        return DoesTree1HaveTree2(root1.left,root2.left) && DoesTree1HaveTree2(root1.right,root2.right);
    }
}
