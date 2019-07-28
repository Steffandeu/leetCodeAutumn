package steffan.deu.offer;

import steffan.deu.offer.No23MergeKSortedLinkedList.ListNode;


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

}
