package steffan.deu.offer;

import steffan.deu.offer.No23MergeKSortedLinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class No23MergeKLists {

    public ListNode mergKList(ListNode[] lists){
        return partion(lists,0,lists.length);
    }


    public static ListNode partion(ListNode[] listNodes,int start,int end){
        if (start==end) return listNodes[start];
        if (start<end){
            int mid = (start+end)/2;
            ListNode l1  = partion(listNodes,start,mid);
            ListNode l2 = partion(listNodes,mid+1,start);
            return merge(l1,l2);
        }else {
            return null;
        }
    }

    public static ListNode merge(ListNode node1,ListNode node2){
        if (node1==null) return node2;
        if (node2==null) return node1;
        if (node1.val<node2.val){
            node1.next=merge(node1.next,node2);
            return node1;
        }
        if (node1.val >node2.val){
            node2.next = merge(node1,node2.next);
            return node2;
        }
        return null;
    }


    /**
     * 优先队列的问题 priority queue
     * 鸡皮疙瘩都有一点
     * 哈哈哈哈哈哈那你又在电影院看过恐怖片吗，有人陪着看要好一点
     */

    public static ListNode queueMerge(ListNode[] lists){
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        };
        //简历队列
        Queue<ListNode> listNodeQueue = new PriorityQueue<>(comparator);
        for (ListNode l :lists){
            if (l!=null){
                listNodeQueue.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!listNodeQueue.isEmpty()){
            point.next = listNodeQueue.poll();
            point = point.next;
            //判断列表是否为空，不为空就将新元素入队
            ListNode next = point.next;
            if (next!=null){
                listNodeQueue.add(next);
            }
        }
        return head.next;
    }
}
