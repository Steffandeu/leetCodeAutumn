package steffan.deu.offer;

/**
 * 当前字符串s 和字符串p
 * s的话没有特殊符号
 * p的话只有单纯的字符串
 * s[i,...n] 匹配 p[j,...m]的子条件是1：s[i+1,...n]是否能匹配p[j+1,...m] 2:s[i]和s[j]是否匹配
 *
 * situation1: s[i]==p[j] 取决于s[i+1,...n]是否匹配p[j+1,...m]
 * situation2：s[i]=='.' 取决于s[i+1,...n]是否匹配p[j+1,...m]
 * situation3: s[i]='*' , 且s[i] != p[j],取决于s[i,...n]是否匹配p[j+2,...m]
 * situation4: s[i] = '*', 且s[i]=p[j]，取决于s[i+1,...n]是否匹配p[j,...m]
 */

public class leetcodeNo10Problem {
    public static boolean isMatch(String s,String p){
        if (s.equals(p)) return true;
        boolean isFirstMatch = false;
        if (!s.isEmpty()&&!p.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.')){
            isFirstMatch = true;
        }
        if (p.length()>=2 && p.charAt(1)=='*') return isMatch(s,p.substring(2))|| (isFirstMatch && isMatch(s.substring(1),p));
        return isFirstMatch && isMatch(s.substring(1),p.substring(1));
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
//        System.out.println(isMatch(s,p));
//        System.out.println(isMatch2(s,p));
        System.out.println(dpIsMatch(s,p));
    }

    public static  boolean isMatch2(String s,String p){
        if (s.equals(p)) return true;
        boolean memo[] = new boolean[s.length()+1];
        return helper(s.toCharArray(),p.toCharArray(),s.length()-1,p.length()-1,memo);
    }
    private static boolean helper(char[] s,char[] p,int i,int j,boolean[] memo){
        if (memo[i+1]) return true;
        if (i==-1 && j==-1){
            memo[i+1]=true;
            return true;
        }
        boolean isFirstMatching = false;
        if (i >= 0 && j >= 0 && (s[i] == p[j] || p[j] == '.'
                || (p[j] == '*' && (p[j - 1] == s[i] || p[j - 1] == '.')))) {
            isFirstMatching = true;
        }
        if (j>=2  && p[j]=='*'){
            boolean zero = helper(s,p,i-2,j,memo);
            boolean match = isFirstMatching && helper(s,p,i-1,j,memo);

            if (zero || match){
                memo[i+1]=true;
            }
            return memo[i+1];
        }

        if (isFirstMatching && helper(s,p,i-1,j-1,memo)){
            memo[i+1] = true;
        }
        return memo[i+1];
    }

//    1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
//    2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
//    3, If p.charAt(j) == '*':
//    here are two sub conditions:
//    1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
//    2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
//      dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
//      or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
//      or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty

    public static boolean dpIsMatch(String s,String p){
        if (s.equals(p)) return true;
        if (s==null || p==null) return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i)=='*' && dp[0][i-1]){
                dp[0][i+1]=true;
            }

        }
        for (int i = 0; i < p.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (p.charAt(j)=='.'){
                    dp[i+1][j+1]=dp[i][j];
                }
                if (s.charAt(i)==p.charAt(j)){
                    dp[i+1][j+1]=dp[i][j];
                }

                if (p.charAt(j)=='*'){
                    if (p.charAt(j-1)!=s.charAt(i) && p.charAt(j-1)!='.'){
                        dp[i+1][j+1]=dp[i+1][j-1];
                    }else {
                        dp[i+1][j+1]=(dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }

                }

            }
            
        }
        return dp[s.length()][p.length()];
    }

}
