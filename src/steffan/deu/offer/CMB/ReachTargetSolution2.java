package steffan.deu.offer.CMB;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReachTargetSolution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        queue.add(new Node(0,0));
        Node temp;
        int ans = 0;
        while (true){
            temp = queue.poll();
            if (temp.pos==target){
                ans = temp.times;
                break;
            }
            queue.offer(new Node(temp.pos + temp.times+1,temp.times+1));
            queue.offer(new Node(temp.pos-temp.times-1,temp.times+1));
        }
        System.out.println(ans);

    }

    public static Queue<Node> queue = new LinkedList<>();

    private static class Node{
        int pos;
        int times;
        public Node(int pos,int times){
            this.pos = pos;
            this.times = times;
        }
    }
}
