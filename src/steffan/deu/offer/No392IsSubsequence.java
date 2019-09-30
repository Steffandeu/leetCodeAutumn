package steffan.deu.offer;

public class No392IsSubsequence {
    //greedy;
    public static boolean isSubsequence(String s,String t){
        if (t==null || t.length()==0) return true;
        for (int i = 0; i <s.length() ; i++) {
            if (t.charAt(0)==s.charAt(i)){
                return isSubsequence(s.substring(i),t.substring(1));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequenceDp2("abc","arpodgdc"));
    }

    //dp solution
    public static boolean isSubsequenceDp(String s,String t){
        if (s.length()==0) return true;
        if (t.length()==0) return false;
        int[] dp = new int[t.length()];
        int slength = s.length();
        for (int i = 1; i < t.length(); i++) {
            if (s.charAt(i-1)==t.charAt(i)){
                dp[i] = dp[i-1] + 1;
                if (dp[i]== slength){
                    return true;
                }
            }else {
                dp[i] = dp[i-1];
            }
        }
        return false;
    }
    //dp detail
    public static boolean isSubsequenceDp2(String s,String t){
        if (s.length()==0) return true;
        if (t.length()==0) return false;
        boolean[][] dp = new boolean[s.length()+1][t.length()+1];
        for (int j = 0; j < t.length(); j++) {
            dp[0][j] = true;
        }

        //dp
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 1; j <=t.length(); j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    //greedy solution
    public static boolean isSubsequenceGreedySolution(String s,String t){
        if (s.length()==0) return true;
        if (t.length()==0) return t.contains(s);

        if (s.length()>1){
            if (t.contains(s.substring(0,1))){
                return isSubsequence(s.substring(1),t.substring(t.indexOf(s.substring(0,1))+1));
            }
        }
        return false;
    }
}
