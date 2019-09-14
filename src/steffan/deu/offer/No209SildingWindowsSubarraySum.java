package steffan.deu.offer;

public class No209SildingWindowsSubarraySum {

    public static int minSubArrayLen(int s,int[] nums){
        int left = 0;
        int right = 0;
        int ansLeft = 0;
        int ansRight = -1;
        int minLen  = Integer.MAX_VALUE;
        int numsLength = nums.length;
//        int[] sum  = new int[numsLength];
//        sum[0] = nums[0];
//        for (int i = 1; i < numsLength; i++) {
//            sum[i] = sum[i-1] + nums[i];
//        }
        while (right<numsLength){
//            int newLength = right-left+1;
            while (checkValue(s,nums,left,right)){
                int newLength = right-left+1;
                if (newLength<numsLength){

                    ansLeft = left;
                    ansRight = right;
                    minLen  = newLength;
                }
                left++;
            }
            right++;
        }
        System.out.println("left: " + left);
        System.out.println("right: "+ right);
        return minLen;
    }

    public static boolean checkValue(int tagret,int nums[],int left,int right){
        int temp = 0;
        for (int i = left; i <=right ; i++) {
            temp += nums[i];
        }
        if (temp>= tagret){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2,3,1,2,4,3};
        int k = 7;
        System.out.println(minSubArrayLen(k,nums));

    }
}
