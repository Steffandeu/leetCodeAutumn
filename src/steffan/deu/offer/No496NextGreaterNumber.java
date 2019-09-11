package steffan.deu.offer;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No496NextGreaterNumber {

    public static int[] nextGreaterElement(int[] nums1,int[] nums2){
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length-1; i >=0 ; i--) {
            while (!stack.isEmpty()&&stack.peek()<=nums2[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1: stack.pop();
            stack.push(i);
        }
        return result;
    }

    public static int[] nextGreaterElement2(int[] nums1,int[] nums2){
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        for (int temp : nums2){
            while (!stack.isEmpty()&&stack.peek()<=temp){
                map.put(stack.pop(),temp);
            }
            stack.push(temp);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i],-1);
            
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,1,2,4};
        int[] nums2 = new int[]{3,1,2,4};
        int[] result = nextGreaterElement2(nums1,nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
