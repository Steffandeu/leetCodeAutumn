package steffan.deu.offer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * brute force
     * @param nums
     * @param target
     * @return
     */
    public  int[] twoSum(int[] nums,int target){
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public int[] TwoPassTwoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component)){
                return new int[]{map.get(component),i};
            }
        }
        throw  new IllegalArgumentException("no such two sum");
    }


    public int[] OnePassSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int componet = target - nums[i];
            if (map.containsKey(componet)){
                return new int[]{map.get(componet),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no such two sum");
    }

}
