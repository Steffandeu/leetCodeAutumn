package steffan.deu.offer.netease;

import java.util.*;

public class BinaryTreeValue {

    private static class Node{
        Node leftChild;
        Node rightChild;
        int value;
        Node(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
//        Node root = new Node(1);
//        Node rootLeft = new Node(2);
//        Node rootRight = new Node(3);
//        Node rootLeftLeft = new Node(4);
//        Node rootLeftRight = new Node(5);
//        Node rootRightleft = new Node(6);
//        Node rootRightLeftleft = new Node(7);
//        root.rightChild = rootRight;
//        root.leftChild = rootLeft;
//        rootLeft.leftChild = rootLeftLeft;
//        rootLeft.rightChild = rootLeftRight;
//        rootRight.leftChild = rootRightleft;
//        rootRightleft.leftChild = rootRightLeftleft;
//        List<Integer> list = new ArrayList<>();
//        list = levelTraverse(root);
//        for (int i: list){
//            System.out.println(i);
//        }
        Scanner sc = new Scanner(System.in);
        List<ArrayList<Integer>> lists = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        int n = sc.nextInt();//几个测试用例
        for(int i = 0; i < n; i++){//几个用例
            int m = sc.nextInt();//几个节点
            ArrayList<Integer> arr = new ArrayList<>();
            count.add(m);
            ArrayList<Integer> list = new ArrayList<>();
            for (int k = 0; k < m; k++) {
                for(int j = 0; j < 3; j++){
                    int x = sc.nextInt();
                    list.add(x);
                }
                lists.add(list);
            }
        }
        //构建树
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            for (int j = i*count.get(i); j < i+count.get(i) ; j++) {

                Node node = new Node(lists.get(j).get(0));
                nodeList.add(node);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i*count.get(i); j < i+count.get(i); j++) {
                Node node  = new Node(lists.get(j).get(0));
                int rightValue = lists.get(j).get(2);
                int leftValue = lists.get(j).get(1);
                if (rightValue==-1){
                    node.rightChild = null;
                }
                else if (leftValue==-1){
                    node.leftChild= null;
                }else {
                    node.leftChild = new Node(lists.get(i*count.get(i)).get(1));
                    node.rightChild = new Node(lists.get(i*count.get(i)).get(2));
                }

            }

        }
        //获得root节点
        int rootValue = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < count.get(i); j++) {
                ArrayList<Integer> arr = new ArrayList<>();

                if (!arr.contains(j)){
                    rootValue = j;
                }

            }
        }
        System.out.println("rootValue为：" + rootValue);

        Node root = new Node(rootValue);
        List<Integer> result = new ArrayList<>();
        boolean resultFlag = false;
        result = levelTraverse(root);
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i)-result.get(i-1)<0){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }

        }



    }

    //层次遍历1 只允许在前端front进行删除，在表的rear进行插入

    /**
     * offer来进行元素的增加，poll获取并移出元素尽量少用add() 和 remove()在失败的时候会抛出异常
     * 使用前端而不删除元素用element和peek方法
     * @param root
     * @return
     */
    public List<Integer> levelOrder(Node root){
        List<Integer> list = new ArrayList<>();
        if (root==null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.leftChild!=null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild!=null){
                queue.offer(node.rightChild);
            }
            list.add(node.value);
        }
        return list;
    }

    public static List<Integer> levelTraverse(Node root){
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);//将根节点传进去
        if (root==null) return null;
        while (!queue.isEmpty()){
            int ans = 0;
            int n = queue.size();
            for (int i = 0; i <n ; i++) {
                Node cur = queue.poll();
                ans+=cur.value;
////                System.out.println("cur" +cur.value);
//                list.add(ans);

                if (cur.leftChild!=null){
                    queue.offer(cur.leftChild);
                }
                if (cur.rightChild!=null){
                    queue.offer(cur.rightChild);
                }
            }
            list.add(ans);

//            System.out.println();
        }
        return list;

    }
}
