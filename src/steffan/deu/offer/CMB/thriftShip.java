package steffan.deu.offer.CMB;

import java.util.Arrays;

public class thriftShip {
    //
    public int greedSolution(int[] nums,int maxLoad){
        Arrays.sort(nums);
        int length = nums.length;
        int count = 0;
        int left = 0;
        int right = length-1;
        while (left<right){
            if (nums[left]+nums[right]<maxLoad){
                left++;
                right++;
            }else {
                right--;
            }
            count++;
        }
        if (left==right){
            count++;
        }
        return count;
    }
}
