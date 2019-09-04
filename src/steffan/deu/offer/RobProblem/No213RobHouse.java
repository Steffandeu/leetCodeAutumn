package steffan.deu.offer.RobProblem;

public class No213RobHouse {
    public static int rob(int[] nums){
        int length = nums.length;
        if (length==0) return 0;
        if (length==1) return nums[0];
        if (length==2) return Math.max(nums[0],nums[1]);
        int[] dp1 = new int[length-1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length-1; i++) {
            dp1[i] = Math.max(dp1[i-2]+nums[i],dp1[i-1]);
        }
        int[] dp2 = new int[length-1];
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1],nums[2]);
        for (int i = 2; i < length-1; i++) {
            dp2[i] = Math.max(dp2[i-2]+nums[i+1],dp2[i-1]);
        }
        System.out.println("dp1: "+ dp1[length-2]);
        System.out.println("dp2: "+ dp2[length-2]);
        return Math.max(dp1[length-2],dp2[length-2]);
    }

    public static int robBruteForce(int[] nums){
        if (nums.length==0 || nums==null) return 0;
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0],nums[1]);
        int start1 = 0;
        int start2 = 1;
        int end1 = nums.length-1;
        int end2 = nums.length;
        int m1 = helper(nums,start1,end1);
        System.out.println("m1:"+m1);
        int m2 = helper(nums,start2,end2);
        System.out.println("m2:"+m2);
        return Math.max(m1,m2);
    }

    private static int helper(int[] nums,int start,int end){
        if (start==0){
            if (end==1){
                return nums[0];
            }
            if (end==2){
                return Math.max(nums[0],nums[1]);
            }
        }
        if (start==1){
            if (end==2){
                return nums[1];
            }
            if (end==3){
                return Math.max(nums[1],nums[2]);
            }
        }
//        System.out.println("helper1: "+ helper(nums,start,end-1));
//        System.out.println("helper2: "+ helper(nums,start,end-1));
        int m = Math.max(helper(nums,start,end-2)+nums[end-1],helper(nums,start,end-1));
        return m;
    }

    //带备忘录的memo的

    public int robWithMemo(int[] nums){
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0],nums[1]);
        int[] memo1 = new int[nums.length+1];
        int[] memo2 = new int[nums.length+1];
        int start1 = 1;
        int start2 = 2;
        int end1 = nums.length - 1;
        int end2 = nums.length;
        int m1 = helperDFS(nums,start1,end1,memo1);
        int m2 = helperDFS(nums,start2,end2,memo2);
        return Math.max(m1,m2);
    }
    public int helperDFS(int[] nums,int start,int end,int[] memo){
        if (start==1){
            if (end==1){
                return nums[0];
            }
            if (end==2){
                return Math.max(nums[0],nums[1]);
            }
        }
        if (start==2){
            if (end==2){
                return nums[1];
            }
            if (end==3){
                return Math.max(nums[1],nums[2]);
            }
        }
        if (memo[end]!=0) return memo[end];
        memo[end] = Math.max(helperDFS(nums,start,end-2,memo)+nums[end-1],helperDFS(nums,start,end-1,memo));
        return memo[end];
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
//        System.out.println(rob(nums));
        System.out.println(robBruteForce(nums));
    }
}
