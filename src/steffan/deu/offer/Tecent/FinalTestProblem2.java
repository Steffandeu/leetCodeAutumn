package steffan.deu.offer.Tecent;

import java.util.Scanner;

public class FinalTestProblem2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();//多少天
//        long[] score = new long[n+2];
//        for (int i = 1; i <=n ; i++) {
//            score[i] = sc.nextInt();
//        }
        int[] nums = new int[]{18,13,11,12,5,6,7,13,2,14};
//        System.out.println(leftCheck(nums,4));
        System.out.println(rightCheck(nums,4));

    }

    public static boolean leftCheck(int[] nums,int index){
        if (index==0) return true;
        boolean flag = true;
        if (index==1) return nums[0]>nums[index];
        for (int i = index-1; i >=1 ; i--) {
            flag =flag&&(nums[i]>=nums[index]);

        }
        return flag;
    }

    public static boolean rightCheck(int[] nums,int index){
        if (index==0) return true;
        boolean flag = true;
        for (int i = index+1; i < nums.length-1; i++) {
            flag = flag && (nums[i]>=nums[index]);
        }
        return flag;
    }
}
