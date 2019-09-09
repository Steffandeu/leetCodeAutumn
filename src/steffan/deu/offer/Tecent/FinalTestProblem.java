package steffan.deu.offer.Tecent;

import java.util.Scanner;
import java.util.Stack;

//单调栈
public class FinalTestProblem {
    //当最低分固定时，为了使学习状态评分最高，应当把左右连续的并且大于等于当前最低分的都包含到区间内。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//多少天
        long[] score = new long[n+2];
        long[] sum = new long[n+2];
        for (int i = 1; i <=n ; i++) {
            score[i] = sc.nextInt();
            sum[i] = sum[i-1] + score[i];
        }
        score[n+1] = 0;
        for (int i = 0; i <score.length ; i++) {
            System.out.println(score[i]);

        }
        sum[n+1] = sum[n];
        for (int i = 0; i <sum.length ; i++) {
            System.out.println("sum: "+sum[i]);

        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int i =1;
        int ans = 0;
        while (!stack.isEmpty()){
            boolean flag = (i==n+1||(stack.peek()!=0)&&score[stack.peek()]>score[i]);
            System.out.println("flag: " + flag +" n+1: "+ (n+1) + " stack.peek(): "+ stack.peek() + " score[i]: "+ score[i]);
            System.out.println("i: " + i);
            while (i==n+1||(stack.peek()!=0)&&score[stack.peek()]>score[i]){
                int top = stack.pop();
                if (top==0) break;
                ans= (int) Math.max(ans,score[top]*(sum[i]-sum[stack.peek()]-score[i]));;
            }
            if (i<=n) stack.push(i++);
        }
        System.out.println(ans);

    }
}
