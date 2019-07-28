package PrintListFromheadtoTail;

import java.util.ArrayList;

public class RecursiveSolution {




    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode!=null){
            if (listNode.next!=null){
                list = printListFromTailToHead(listNode.next);
            }
        }
        list.add(listNode.val);
        return list;
    }

}
