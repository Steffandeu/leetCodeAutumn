package steffan.deu.offer.MonotonusStack;

import java.util.Stack;

public class POJ2796 {

    public static int myTry(int[] nums){
        int length = nums.length;
        int[] scores = new int[length+2];
        int[] sum = new int[length+2];
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
            scores[i] = nums[i-1];
        }
        scores[length+1] = 0;

        //test for score input
        for (int i = 0; i <  scores.length; i++) {
            System.out.println(scores[i]);
        }

        for (int i = 1; i <scores.length; i++) {
            sum[i] = sum[i-1] + scores[i];
        }
        //test for sum input;
        for (int i = 0; i < sum.length; i++) {
            System.out.println("sum" + sum[i]);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i <=length+1 ; i++) {
            while (i==length+1||!stack.isEmpty() && scores[stack.peek()]>scores[i]){
                int top = stack.pop();
                if (top==0) break;
                ans = Math.max(ans,scores[top]*(sum[i]-sum[stack.peek()]-scores[i]));
            }
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{8,2,4,6,5};
//        int[] nums1 = new int[]{1,2,3};
        System.out.println(myTry(nums));;
    }
}

