package steffan.deu.offer;

import java.util.ArrayList;
import java.util.List;

public class No46Permutations {
    public static List<List<Integer>> permute(int nums[]){
        int length = nums.length;
        List<List<Integer>> result  = new ArrayList<>();
        int start = 0;
        int end = length-1;
        dfsHelper(0,end,nums,result);
        return result;
    }

    public static void dfsHelper(int start,int end,int nums[],List<List<Integer>> result){
        if (start==end){
            List<Integer> lists = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                lists.add(nums[i]);
            }
            result.add(lists);
            return;
        }else {
            for (int i = start; i <=end ; i++) {
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                dfsHelper(start+1, end, nums, result);
                temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result.size());
        for (Integer integer: result.get(3)) {
            System.out.println(integer);
        }
    }
}
