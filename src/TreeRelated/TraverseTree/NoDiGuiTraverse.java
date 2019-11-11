package TreeRelated.TraverseTree;

import java.util.*;

public class NoDiGuiTraverse {
    //通过模拟栈来实现
    public List<Integer> preOder(DiGuiTraverse.TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        Stack<DiGuiTraverse.TreeNode> stack = new Stack<>();
        DiGuiTraverse.TreeNode currentNode = root;
        while (currentNode!=null || !stack.isEmpty()){
            while (currentNode!=null){
                list.add(currentNode.val);//中
                stack.push(currentNode);//压栈
                currentNode=currentNode.left;//左
            }
            //中-->左--> 右
            if (!stack.isEmpty()){
                currentNode = stack.pop();
                currentNode = currentNode.right;
            }
        }
        return list;
    }

    public List<Integer> inOrder(DiGuiTraverse.TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<DiGuiTraverse.TreeNode> treeNodeStack = new Stack<>();
        DiGuiTraverse.TreeNode currentNode = root;
        while (currentNode!=null|| !treeNodeStack.isEmpty()){
            //中序遍历：左-->中-->右
            while (currentNode!=null){
                treeNodeStack.push(currentNode);
                currentNode = currentNode.left;
            }
            if (!treeNodeStack.isEmpty()){
                currentNode = treeNodeStack.pop();
                result.add(currentNode.val);
                currentNode = currentNode.left;
            }
        }
        return result;
    }

    public List<Integer> postOder(DiGuiTraverse.TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<DiGuiTraverse.TreeNode> treeNodeStack = new Stack<>();
        DiGuiTraverse.TreeNode currentNode = root;
        while (currentNode!=null || !treeNodeStack.isEmpty()){
            //后序遍历：左-->右-->中
            while (currentNode!=null){
                result.add(currentNode.val);
                treeNodeStack.push(currentNode);
                currentNode = currentNode.right;
            }
            if (!treeNodeStack.isEmpty()){
                currentNode = treeNodeStack.pop();
                currentNode = currentNode.left;
            }
        }
        Collections.reverse(result);
        return result;
    }

    //层次遍历
    public List<Integer> levelOrder(DiGuiTraverse.TreeNode root){
        List<Integer> levelOrderResult = new ArrayList<>();
        Deque<DiGuiTraverse.TreeNode> deque = new ArrayDeque<>();
        if (root==null){
            return  levelOrderResult;
        }
        deque.addLast(root);
        DiGuiTraverse.TreeNode currentNode = root;
        while (!deque.isEmpty()){
            currentNode = deque.pollFirst();
            if (currentNode.left!=null){
                deque.addLast(currentNode.left);
            }
            if (currentNode.right!=null){
                deque.addLast(currentNode.right);
            }
            levelOrderResult.add(currentNode.val);

        }
        return levelOrderResult;
    }

    public static void main(String[] args) {
       DiGuiTraverse traverse = new DiGuiTraverse();
//       traverse.TreeNode root == new
    }
}
