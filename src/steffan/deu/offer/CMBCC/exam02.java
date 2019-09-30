package steffan.deu.offer.CMBCC;

import java.util.Scanner;

public class exam02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        boolean visit[] =new boolean[n];
        int[] dp = new int[n];
        for (int i = 0; i <n-1 ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            map[a-1][b-1] = map[b-1][a-1] = c;
        }

        for (int i = 0; i <n; i++) {
            dp[i] = dfs(map,dp,i,visit);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
//        System.out.println();
    }

    public static int dfs(int[][] map,int[] dp,int idx,boolean[] visit){
        int max = 0;
        visit[idx] = true;
        for (int i = idx+1; i <dp.length ; i++) {
            if (visit[i]) continue;
            if (map[idx][i]!=0){
                if (dp[i]!=0){
                    max= Math.max(max,map[idx][i]+dp[i]);
                }else {
                    max = Math.max(max,map[idx][i]+dfs(map, dp, i, visit));
                }
            }

        }
        visit[idx] = false;
        dp[idx] = max;
        return max;
    }
}
