package steffan.deu.offer.Tecent;

import java.util.Map;
import java.util.Stack;

public class FinalTestProblemLeetCodeInput {

    public static int getBestScore(int[] scores){
        int sum[] = new int[scores.length];
//        int temp = 0;
        sum[0] = scores[0];
        for (int i = 1; i < scores.length; i++) {
            sum[i] = sum[i-1] + scores[i];
        }
        int length = scores.length;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (i==length || !stack.isEmpty() && scores[i]<scores[stack.peek()]){
                System.out.println("i:"+i);
                int top = stack.pop();
                if (stack.empty()) break;
                ans = Math.max(ans,scores[top]*(sum[top]-sum[stack.peek()]+scores[stack.peek()]));

//               f (stack.empty()) break;
//                stack.pop();
//                ans = Math.max(ans,scores[top]*(sum[i]-sum[stack.peek()]+scores[stack.peek()]));
            }
            stack.push(i);

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,4,6,5};
        int[] nums2 = new int[]{1,2,5};
//        System.out.println(getBestScore(nums2));
    }
}
