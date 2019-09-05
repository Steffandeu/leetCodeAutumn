package steffan.deu.offer.ctrip;//package TwoDimensionArray;
//
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//public class Main {
//
//
//    /*请完成下面这个函数，实现题目要求的功能
//    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
//    ******************************开始写代码******************************/
//    static int schedule(int m,int[] array) {
//       int n = array.length;
//       int[][] dp = new int[n+1][m+1];
//       int[] sub = new int[n+1];
//        for (int i = 0; i <=n; i++) {
//            for (int j = 0; j <=m ; j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//            }
//        }
//        for (int i = 0; i <n ; i++) {
//            sub[i+1] = sub[i] + array[i];
//        }
//        dp[0][0] = 0;
//        for (int i = 1; i <=n; i++) {
//            for (int j = 0; j <=m ; j++) {
//                for (int k = 0; k < i; k++) {
//                    dp[i][j] = Math.min(dp[i][j],Math.min(dp[k][j-1],sub[i]-sub[k]));
//
//                }
//
//            }
//
//        }
//        return dp[n][m];
//
//    }
//    /******************************结束写代码******************************/
//
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int m = in.nextInt();
//        int size  = in.nextInt();
//        int[] array = new int[size];
//        for(int i = 0; i < size; i++) {
//            array[i] = in.nextInt();
//        }
//        int res = schedule(m,array);
//        System.out.println(String.valueOf(res));
//    }
//}
//
