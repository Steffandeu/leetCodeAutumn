package DP;

public class MaxForcingOpti {
    public int[] dp;

    public int cuting(int n) {
        int max = 0;
        dp = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= n/2; j++) {
                if (i>=j){
                    int result = dp[i - j] * dp[j];
                    System.out.println("i: "+i+" j: "+j+ " result: "+result);
                    if (result > max) {
                        max = result;
                        dp[i] = max;

                }
                }
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        MaxForcingOpti opti = new MaxForcingOpti();
        System.out.println(opti.cuting(12));
    }
}


