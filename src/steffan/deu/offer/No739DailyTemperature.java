package steffan.deu.offer;

import java.util.Arrays;
import java.util.Stack;

public class No739DailyTemperature {
    public static int[] dailyTemperature(int[] T){
        int length = T.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();//单调栈里面放非递增排序
        for (int i = length-1; i >=0 ; i--) {//从后往前遍历
            while(!stack.isEmpty() && T[stack.peek()]<=T[i]){//
                stack.pop();
            }
            res[i] = stack.empty() ? 0: stack.peek()-i;
            stack.push(i);
        }
        return res;
    }

    public static int[] dailyTemperatureZhengxu(int[] T){
        int length = T.length;
        int[] res = new int[length];
//        Arrays.fill(res,0);//默认为0可以不用加
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && T[i]>T[stack.peek()]){//stack.peek()出来的是上一轮的指标
//                res[stack.pop()]=T[i];
                int value = i-stack.peek();
                res[stack.pop()] = value;
            }
            stack.push(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int T[] = new int[]{73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatureZhengxu(T);
        for (int i = 0; i <res.length ; i++) {
            System.out.println(res[i]);
        }
    }
}
