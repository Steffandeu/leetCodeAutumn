package steffan.deu.offer;

/**
 * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
 * }
 */
public class No23MergeKSortedLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKList(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists == null) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return mergeTwoList(lists[0],lists[1]);

        int mid = lists.length/2;
        ListNode[] list1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            list1[i] = lists[i];
        }
        
        ListNode[] list2 = new ListNode[lists.length-mid];
        for (int i = mid,j=0; i < lists.length; i++,j++) {
            list2[j] = lists[i];
        }
        return mergeTwoList(mergeKList(list1),mergeKList(list2));

    }


    public ListNode mergeTwoList(ListNode n1,ListNode n2){
        if (n1==null) return n2;
        if (n2==null) return n1;
        ListNode head = null;
        if (n1.val<=n2.val){
            head = n1;
            head.next = mergeTwoList(n1.next,n2);
        }else {
            head = n2;
            head.next = mergeTwoList(n1,n2.next);
        }
        return head;
    }

}
