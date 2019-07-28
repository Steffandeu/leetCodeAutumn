package Backtracking;

import java.util.ArrayList;

public class Palindromepartition {
    ArrayList<ArrayList<String>> arrResult = new ArrayList<>();
    public ArrayList<ArrayList<String>> partition(String str){
        if (str==null){
            return arrResult;
        }
        dfs(str,new ArrayList<String>(),0);
        return arrResult;
    }
    public void dfs(String str,ArrayList<String> contains,int index){
        if (index==str.length()){
            arrResult.add(new ArrayList<>(contains));
            return;
        }
        ArrayList<String> temp = new ArrayList<>(contains);
        for (int i=index+1;i<=str.length();i++){
            if (checkIsPalindrome(str.substring(index,i))){
                temp.add(str.substring(index,i));//temp=["a","a","b"];
                System.out.println(i+"字符串"+str.substring(index,i)+ " complete "+str); // "aab"--> i=1 "a"
                dfs(str,temp,i);//递归的: i=1=index 此时i为2,checkispalindrome(1,2) "a"此时递归借宿l i=index=2; i此时为3 substring(2,3)--> "b";
                temp.remove(temp.size()-1);// 目的是晴空矩阵
                System.out.println(temp.size());
                for (String s:temp){
                    System.out.println("=====" +s);
                }
            }
        }

    }
    public boolean checkIsPalindrome(String str){
        if (str==null){
            return false;
        }
        int l = 0;
        int r = str.length()-1;
        while (l<r){
            if (str.charAt(l++)!= str.charAt(r--)){
                return false;
            }
        }
        return true;
    }

    public boolean DpCheckPalindrome(String str){
        if (str==null){
            return false;
        }
        //dp[i][j] = 判断i-j之间的是不是回文串
        boolean[][] dp = new boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i <str.length() ; i++) {
            for (int j = 0; j < str.length(); j++) {
                if (j-1==1){
//                    dp[i][j] = str.charAt()
                }

            }

        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                dp[i][j] = dp[i+1][j-1] && str.charAt(i)==str.charAt(j);
            }

        }
        return dp[str.length()][str.length()];
    }

    public static void main(String[] args) {
        String str = "aab";
        Palindromepartition pp = new Palindromepartition();
        ArrayList<ArrayList<String>> lists = pp.partition(str);
        for(ArrayList<String> strings : lists){
            System.out.println(strings);
        }
    }
}
