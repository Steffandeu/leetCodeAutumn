package PrintListFromheadtoTail;

import javax.xml.soap.Node;
import java.util.List;

public class TetsArrayList {
    public static void main(String[] args) {
        PrintArrayList testlist=  new PrintArrayList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        RecursiveSolution rs = new RecursiveSolution();
        PrintArrayList ps = new PrintArrayList();
        System.out.println(rs.printListFromTailToHead(node1));
//        System.out.println(ps.printListFromTailToHead(node1));

    }
}
