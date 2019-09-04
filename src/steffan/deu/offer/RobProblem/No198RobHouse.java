package steffan.deu.offer.RobProblem;

public class No198RobHouse {
    //first way dfs
    public static int robDFS1(int[] nums){
        int length = nums.length;
        if (length==0) return 0;
        if (length==1) return nums[0];
        if (length==2) return Math.max(nums[0],nums[1]);
        int start = 1;
        int end = length;
        return helper1(nums,start,end);
    }
    private static int helper1(int[] nums,int start,int end){
        if (start==1){
            if (end==1) return nums[0];
            if (end==2) return Math.max(nums[0],nums[1]);
        }
        return Math.max(helper1(nums,start,end-2)+nums[end-1],helper1(nums,start,end-1));
    }


    public static void main(String[] args) {
        int nums[] = {2,4,9};
        System.out.println(robDFS3(nums));
    }

    //dfs with memo
    public static int robDFS2(int[] nums){
        int length = nums.length;
        if (length==0) return 0;
        if (length==1) return nums[0];
        if (length==2) return Math.max(nums[0],nums[1]);
        int[] memo = new int[length+1];
        int start = 1;
        int end = length;
        return helper2(nums,start,end,memo);
    }
    private static int helper2(int[] nums,int start,int end,int[] memo){
        if (start==1){
            if (end==1) return nums[0];
            if (end==2) return Math.max(nums[0],nums[1]);
        }
        if (memo[end]!=0) return memo[end];
        memo[end] = Math.max(helper2(nums,start,end-2,memo)+nums[end-1],helper2(nums,start,end-1,memo));
        return memo[end];
    }

    //another dfs method

    public static int robDFS3(int[] nums){
        int length = nums.length;
        if (length==0) return 0;
        if (length==1) return nums[0];
        if (length==2) return Math.max(nums[0],nums[1]);
        int memo[] = new int[nums.length+1];
        for (int i = 0; i < nums.length+1; i++) {
            memo[i]=-1;
        }
        return helper3(nums,0,memo);
    }

    private static int helper3(int[] nums,int index,int[] memo){
        if (index>=nums.length){
            return 0;
        }
        if (memo[index]!=-1) return memo[index];

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res,nums[i]+helper3(nums,i+2,memo));
//            memo[index] = res;
        }
        memo[index] = res;
        return res;
//        return res;
    }

    //动态规划问题
    /**
     * dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1])
     */

    public int dpRob(int nums[]){
        int[] dp = new int[nums.length+1];
        int length = nums.length;
        if (length==0) return 0;
        if (length==1) return Math.max(nums[0],nums[1]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[length-1];
    }
}
