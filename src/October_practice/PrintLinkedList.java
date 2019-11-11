package October_practice;//import PrintListFromheadtoTail.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class PrintLinkedList {

    public class  ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val=val;
        }
    }
    public ArrayList<Integer> printListFromHeadToTail(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
}
