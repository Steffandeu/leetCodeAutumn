package steffan.deu.offer.CMB;

public class stockProblem {

    public static int maxProfit(int[] prices){
        int n =prices.length;
        if (n==0) return 0;
        int[][] dp = new int[n][2];
        //0 没有持有 1 持有
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(-prices[i],dp[i-1][1]);
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
//            dp[i][1] = Math.max(-prices[i],dp[i-1][1]);
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        int nums[]  = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
}
