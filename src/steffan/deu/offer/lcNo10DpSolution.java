package steffan.deu.offer;

public class lcNo10DpSolution {
    public static boolean isMatch(String s,String p){
        //    1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
//    2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
//    3, If p.charAt(j) == '*':
//    here are two sub conditions:
//    1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
//    2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
//      dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
//      or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
//      or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty


//        if (s==null || s==null) return false;
//        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
//        dp[0][0] = true;
//        for (int i = 0; i <s.length()+1; i++) {
//            for (int j = 1; j <p.length()+1; j++) {
//                if (i>0 && (p.charAt(j-1)=='.' || p.charAt(j-1)==s.charAt(i-1))){
//                    dp[i][j]=dp[i-1][j-1];//从左至右
//                }
//                if (p.charAt(j-1)=='*'){
//                    if (i==0 || (s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2)!= '.')){
//                        dp[i][j]=dp[i][j-2];
//                    }else {
//                        dp[i][j]=dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
//                    }
//                }
//            }
//
//        }
//        return dp[s.length()][p.length()];
        if (s==null || p==null) return false;
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < s.length()+1; i++) {
            for (int j = 1; j < p.length()+1; j++) {
                if (i>0 && (p.charAt(j-1)=='.' || p.charAt(j-1)==s.charAt(i-1))){
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j-1)=='*'){
                    if (i==0 || (s.charAt(i-1)!=p.charAt(j-2) && p.charAt(j-2)!='.')){
                        dp[i][j] = dp[i][j-2];
                    }else {
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                    }
                }

            }

        }
        return dp[s.length()][p.length()];

    }




    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
//        System.out.println(isMatch(s,p));
        System.out.println(isMatch(s,p));
    }

}
