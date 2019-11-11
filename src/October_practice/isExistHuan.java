package October_practice;

public class isExistHuan {
    public class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead==null||pHead.next==null||pHead.next.next==null) return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast!=slow){
            if (fast.next!=null && fast.next.next!=null){
                fast=fast.next.next;
                slow = slow.next;
            }else {
                return null;//无环
            }
        }
        //计算环的入口
        fast = pHead;
        while (fast!=slow){
            fast = fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
