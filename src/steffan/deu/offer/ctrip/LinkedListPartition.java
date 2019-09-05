package steffan.deu.offer.ctrip;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * description：
 * 输入 3 2 9 5 6 8 4
 *      m = 7；
 * 输出：
 *      3 2 5 6 4 9 8 要求保持原来的顺序不变，小于m的在大于m的左边
 */


public class LinkedListPartition {
        public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        List<Integer> listLower = new ArrayList<>();
        List<Integer> listUpper = new ArrayList<>();
        if (head==null) return null;

        while (head!=null){
            if (head.val<=m){
                listLower.add(head.val);
            }else {
                listUpper.add(head.val);
            }
            head = head.next;
        }
        listLower.addAll(listUpper);
        for (int i = 0; i < listLower.size(); i++) {
            head =insert(listLower.get(i));
        }
        return head;
    }

    public static ListNode insert(int value){
        ListNode head,tailer;
        head = tailer = null;
        ListNode newNode = new ListNode(value);
        if (head==null){
            head = tailer = newNode;
        }else {
            tailer.next = newNode;
            tailer = newNode;
        }
        return head;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
