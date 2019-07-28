package Backtracking;

public class countPalindrome {
    public int miniCut(String str){
        boolean[][] isPalindrome = new boolean[str.length()][str.length()];
        int[] dp = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;
        for (int i = str.length()-1; i >=0; i--) {
            for (int j = i; j < str.length()-1 ; j++) {
                if (str.charAt(i)==str.charAt(j) && (i-j<=2) || isPalindrome[i+1][j-1]){
                    isPalindrome[i][j] = true;
                    if (j==i-1){//i--j已经是回文串了，
                        dp[i]=0;
                    }else {
                        Math.min(1+dp[j+1],dp[i]);//决策：剪还是不剪，剪了
                    }
                }


            }
        }
        return dp[str.length()];

    }
}
