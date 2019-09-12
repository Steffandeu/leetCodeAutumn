package steffan.deu.offer.MonotonusStack;

import java.util.Stack;

public class No84largestRechtangleArea {
    public static int largestArea(int[] height){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < height.length; ++i) {
            while (stack.peek()!=-1 && height[stack.peek()]>=height[i]){
                maxArea = Math.max(maxArea,height[stack.pop()]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
//        while (stack.peek()!=-1){
//            maxArea = Math.max(maxArea,height[stack.pop()]*(height.length-stack.peek()-1));
//        }
        return maxArea;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,5,6,2,3};
        System.out.println(largestArea(nums));
    }
}
