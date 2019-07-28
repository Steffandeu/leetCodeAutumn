package steffan.deu.offer;

public class No53MaxSubarray {
    public static int maxSubarray(int[] nums){
        int ans = nums[0];
        int sum = 0;
        for (int num : nums){
            if (sum > 0){
                sum += num;
            }else{
                sum = num;
            }
            ans = Math.max(sum,ans);
        }
        return ans;
    }

    //repeat work

    /**
     * 假设你是一个选择性遗忘的赌徒，数组表示你这几天来赢钱或者输钱， 你用sum来表示这几天来的输赢， 用ans来存储你手里赢到的最多的钱，
     *
     * 如果昨天你手上还是输钱（sum < 0），你忘记它，明天继续赌钱； 如果你手上是赢钱(sum > 0), 你记得，你继续赌钱； 你记得你手气最好的时候
     * @return
     */
    public static  int findMaxSubarray(int[] nums){
        int ans = nums[0];//ans 也是在不停变换的
        int sum = 0;
        for (int num :nums){
            if (sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }


    public static int DpMaxSubarray(int[] nums){
        if (nums.length==0) return 0;
        if (nums==null) return 0;

        int[] dp = new int[nums.length];
        dp[0]= 0;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1]>=0){
                dp[i] = dp[i-1]+nums[i];
            }else {
                dp[i] = nums[i];
            }
        }

        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    //根据状态转移方程2
    public static int DpMaxSubarray2(int[] nums){
        if (nums.length==0) return 0;
        if (nums==null) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 0;
        int res = nums[0];
        for (int i=1;i<nums.length;i++){
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    //分治法
    public int maxSubarrayFenzhi(int[] nums){
        if (nums.length==0) return  0;
        if (nums==null) return 0;
        return maxSubarraySumhelper(nums,0,nums.length-1);
    }

    public int maxSubarraySumhelper(int[] nums,int left,int right){
        if (left==right){
            return 0;
        }
        int mid = (left+right)/2;
        return Math.max(maxSubarraySumhelper(nums,left,mid),Math.max(maxSubarraySumhelper(nums,mid+1,right),maxSubarrayWhole(nums,left,mid,right)));
    }

    public int maxSubarrayWhole(int[] nums,int left,int mid,int right){
        int leftSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=mid;i>=left;i--){
            sum+=nums[i];
            if(sum>leftSum){
                leftSum=sum;
            }
        }
        sum=0;
        int rightSum=Integer.MIN_VALUE;
        for(int i=mid+1;i<=right;i++){
            sum+=nums[i];
            if(sum>rightSum){
                rightSum=sum;
            }
        }
        return leftSum+rightSum;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int ans = maxSubarray(nums);
//        System.out.println(ans);
        System.out.println(DpMaxSubarray(nums));
        System.out.println(DpMaxSubarray2(nums));
    }

}

