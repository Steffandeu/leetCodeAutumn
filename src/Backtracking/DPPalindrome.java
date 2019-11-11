package Backtracking;

import java.util.ArrayList;

public class DPPalindrome {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    public ArrayList<ArrayList<String>> partition(String s) {
        int length = s.length();
        if (length<=1){
            return result;
        }
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i <length ; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < length; i++) {
            dp[i][i+1]=true;
        }
        return null;

    }

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        System.out.println(a/b);
    }


}
