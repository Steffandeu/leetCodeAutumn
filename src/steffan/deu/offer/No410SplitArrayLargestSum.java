package steffan.deu.offer;

public class No410SplitArrayLargestSum {
    private int ans;
    private int n,m;
    public int splitArray(int[] nums,int M){
        ans = Integer.MAX_VALUE;
        n = nums.length;
        m = M;
        dfs(nums,0,0,0,0);
        return ans;
    }

    private void dfs(int[] nums,int i,int cntSubarrays,int curSum, int curMax){
        if (i==n && cntSubarrays ==m){
            ans = Math.min(ans,curMax);
        }
        if (i==n) return;
        if (i>0){
            System.out.println("第一个类别的dfs...此时i为 "+i + " cntSubarrays: " + cntSubarrays);
            dfs(nums,i+1,cntSubarrays,curSum+nums[i],Math.max(curMax,curSum+nums[i]));
        }
        if (cntSubarrays<m){
            System.out.println("第二个类别的dfs...此时i为 "+i );
            dfs(nums,i+1,cntSubarrays+1,nums[i],Math.max(curMax,nums[i]));
        }
    }


    public static void main(String[] args) {
        No410SplitArrayLargestSum no410SplitArrayLargestSum = new No410SplitArrayLargestSum();
        int[] nums = new int[]{7,2,5,10,8};
        int m = 2;
        no410SplitArrayLargestSum.splitArray(nums,m);
    }
}
