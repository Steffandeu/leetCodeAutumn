package steffan.deu.offer.CMB;

import java.util.Scanner;

public class geziJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[target]);
    }

}
