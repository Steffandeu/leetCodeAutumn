package steffan.deu.offer;

public class No121Stock {
    public int maxProfit(int[] prices){
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int profit = prices[j]-prices[i];
                if (profit>maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices){
        int n = prices.length;
        if (n==0) return 0;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            //处理特殊值
            if (i==0){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[n-1][0];
    }
    //双指针--->只遍历依次
    public int maxProifit2(int[] prices){
        int maxProfit = 0;
        int buy = 0;
        int sell = 0;
        for (; sell < prices.length; sell++) {
            if (prices[sell]<prices[buy]){
                buy =sell;
            }else {
                maxProfit = Math.max(maxProfit,prices[sell]-prices[buy]);
            }
        }
        return maxProfit;
    }
}
