package TreeRelated.BinarySearchTree;

import PrintListFromheadtoTail.RecursiveSolution;

public class Structure {

    public class Node{
        int key;
        int value;
        Node right;
        Node left;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    public class BST{
        Node root;

        public Node Find(int key){
            Node currentNode = root;
            while (currentNode!=null && currentNode.key !=key){
                if (key<currentNode.key){
                    currentNode = currentNode.left;
                }
                if (key>currentNode.key){
                    currentNode = currentNode.right;
                }
            }
            return currentNode;
        }

        public void insert(int key,int value){
            /*
             *root节点为null，插入的点就是root节点
             */
            if (root==null){
                root = new Node(key,value);
                return;
            }
            Node currentNode = root;
            Node parentNode = root;
            boolean isLeftChild = true;
            while (currentNode!=null){
                parentNode = currentNode;//parentNode是也在不同的变化的
                if (key < currentNode.key){
                    currentNode = currentNode.left;
                    isLeftChild = true;
                }else {
                    currentNode = currentNode.right;
                    isLeftChild = false;
                }
            }
            Node newNode = new Node(key,value);
            if (isLeftChild){
                parentNode.left = newNode;
            }else {
                parentNode.right = newNode;
            }
        }

        public Node RecursiveInsert(Node root,int key,int value){
            if (root==null){
                root = new Node(key,value);
                return root;
            }
            if (key<root.key){
                return RecursiveInsert(root.left,key, value);
            }
            if (key>root.key){
                return RecursiveInsert(root.right,key,value);
            }
            return root;
        }

        public boolean delete(int key){
            Node currentNode = root;
            Node parentNode = root;
            boolean isLeftChild = true;
            while(currentNode!=null && currentNode.key!=key){
                parentNode = currentNode;
                if (key<currentNode.key){
                    currentNode = currentNode.left;
                    isLeftChild = true;
                }
                else {
                    currentNode = currentNode.right;
                    isLeftChild = false;
                }
            }
            if (currentNode == null){
                return false;
            }
            if (currentNode.left==null&&currentNode.right==null){
                if (currentNode==root){
                    root = null;
                }else if (isLeftChild){
                    parentNode.left = null;
                }else {
                    parentNode.right = null;
                }
            }else if (currentNode.right==null){//删除的节点只有左孩子
                if (currentNode==root){
                    root = currentNode.left;
                }else if (isLeftChild){
                    parentNode.left = currentNode.left;
                }else {
                    parentNode.right = currentNode.left;
                }

            }else if (currentNode.left==null){//删除节点只有右孩子
                if (currentNode==root){
                    root = currentNode.right;
                }else if (isLeftChild){
                    parentNode.left=currentNode.right;
                }else {
                    parentNode.right = currentNode.right;
                }
            }else {//要删除的节点既有左孩子也有右孩子
                //思路：用待删除节点的右子树的key值
                Node directPostNode = getDirectPostNode(currentNode);
                currentNode.key = directPostNode.key;
                currentNode.value = directPostNode.value;
            }
            return true;
        }

        public Node getDirectPostNode(Node delNode){
            Node parentNode = delNode;
            Node directPostNode = delNode;
            Node currentNode = delNode.right;
            while (currentNode!=null){
                parentNode = directPostNode;
                directPostNode = currentNode;
                currentNode = currentNode.left;
            }
            if (directPostNode!=delNode.right){
                parentNode.left = directPostNode.right;
                directPostNode.right = null;
            }
            return directPostNode;
        }
    }
}