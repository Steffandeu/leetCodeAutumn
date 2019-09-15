package steffan.deu.offer.August360;

import java.util.Arrays;

public class ballonProblem {

    public static int party(int[] nums){
        Arrays.sort(nums);
//        System.out.println(nums[nums.length-1]);
        if (nums[nums.length-1]/2>nums[0]+nums[1]) return nums[0]+nums[1];
        else return (nums[0]+nums[1]+nums[2])/3;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3};
        System.out.println(party(nums));
    }

}
