package steffan.deu.offer.GreedyProblem;

public class No55JumpGame {
    public boolean canJump(int[] nums){
        return DFScanJumpWithBackTracing(0,nums);
    }

    public static boolean DFScanJumpWithBackTracing(int index,int[] nums){
        if (index == nums.length-1){
            return true;
        }
        int furestJump = Math.min(nums[index]+index,nums.length-1);
        for (int i = index+1; i <= furestJump ; i++) {
            if (DFScanJumpWithBackTracing(i,nums)){
                return true;
            }
        }
        return false;
    }

    // top to background dp

    public boolean checkCanJump(int[] nums){
        if (nums==null){
            return false;
        }
        boolean dp[] = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {//之前的节点能够到这一个点
                if (dp[j] && nums[j]+j>=i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }

    //贪心算法怎么来解决
    
    public boolean greedyCanJump(int nums[]){
        if (nums==null){
            return false;
        }
        int lastPosition = nums.length-1;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (nums[i]+i>lastPosition){
                lastPosition = i;
            }
        }
        return lastPosition==0;
    }

}
