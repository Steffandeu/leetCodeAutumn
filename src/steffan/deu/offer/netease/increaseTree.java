package steffan.deu.offer.netease;

import java.util.*;

public class increaseTree {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //T组测试样例
        int T = sc.nextInt();
        while (T > 0) {
            T--;
            // 二叉树节点数
            int N = sc.nextInt();
            int[] val = new int[N];
            int[] left = new int[N];
            int[] right = new int[N];
            for (int i = 0; i < N; i++) {
                val[i] = sc.nextInt();
                left[i] = sc.nextInt();
                right[i] = sc.nextInt();
            }
            boolean incTree = isIncTree(val, left, right);
            if (incTree) {
                System.out.println("YES");
            } else {
                System.out.println("No");
            }
        }
        sc.close();
    }

    /**
     * 判断二叉树是否是递增二叉树
     * @param val
     * @param left
     * @param right
     * @return
     */
    private static boolean isIncTree(int[] val, int[] left, int[] right) {
        int N = val.length;
        // 找出根节点，根节点必定不会出现在left或right数组中，不是其他节点的子节点
        Set<Integer> subNode = new HashSet<>();
        for (int i : left) {
            if (i != -1) {
                subNode.add(i);
            }
        }
        for (int i : right) {
            if (i != -1) {
                subNode.add(i);
            }
        }
        int rootIndex = 0;
        for (int i = 0; i < N; i++) {
            if (!subNode.contains(i)) {
                rootIndex = i;
            }
        }

        //存储每一层的节点
        List<List<Integer>> list = new ArrayList<>();
        // 每一层节点的索引
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(rootIndex);
        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                int cur = queue.poll();
                curList.add(val[cur]);
                if (left[cur] != -1) {
                    queue.add(left[cur]);
                }
                if (right[cur] != -1) {
                    queue.add(right[cur]);
                }
            }
            list.add(curList);
        }
        // 上一层节点权值和
        int pre = 0;
        List<Integer> preList = list.get(0);
        for (int i : preList) {
            pre += i;
        }
        for (int i = 1; i < list.size(); i++) {
            // 当前层节点权值和
            int cur = 0;
            List<Integer> curList = list.get(i);
            for (int j : curList) {
                cur += j;
            }
            if (cur <= pre) {
                return false;
            }
            pre = cur;
        }
        return true;
    }

}
