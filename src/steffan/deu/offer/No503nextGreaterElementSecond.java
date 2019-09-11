package steffan.deu.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No503nextGreaterElementSecond {
    public static int[] nextGreaterElement(int[] nums){
        int length = nums.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>(); //stack 存放的是索引
        //假装数组翻倍了
        for (int i = 2*length-1; i >=0  ; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i%length]){
                stack.pop();
            }
            res[i%length] = stack.isEmpty() ? -1 : stack.peek();
//            System.out.println("i: "+ i);
//            if (stack.isEmpty()){
//                res[i%length] = -1;
//                System.out.println("arr index: "+i%length);
//            }else {
//                res[i%length] = stack.peek();
//                System.out.println("arr index: "+ i%length);
//                System.out.println(stack.peek());
//            }
            stack.push(nums[i%length]);
            
        }
        return res;
    }

    public static int[] nextGreaterElementii(int nums[]){
        int length = nums.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 2*length-1; i++) {
            while (!stack.isEmpty() && stack.peek()<nums[i%length]){
                res[stack.pop()] = nums[i%length];
            }
            if (i<length) stack.push(i);
          

        }
        return res;
    }

    //此处不能用map,因为有重复的值
    public static int[] nextGreaterElementiii(int[] nums){
        int length = nums.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 2*length; i++) {
            while (!stack.isEmpty() && stack.peek()<nums[i%length]){
//                map.put(stack.pop(),nums[i%length]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.getOrDefault(nums[i],-1); //

        }
        return res;
    }

    //测试成环
    public void circle(int[] arr){
        int length = arr.length;
        int index = 0;
        while (true){
            System.out.println(arr[index%length]);
            index++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,2,4,3};
        int[] result = nextGreaterElement(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
//        int[] result2 = nextGreaterElementii(nums);
//        for (int i = 0; i < result2.length; i++) {
//            System.out.println(result2[i]);
//        }
        //test 3
//        int[] result2 = nextGreaterElementiii(nums);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(result2[i]);

//        }
    }
}
