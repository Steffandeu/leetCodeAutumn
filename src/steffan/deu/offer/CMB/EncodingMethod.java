package steffan.deu.offer.CMB;

public class EncodingMethod {

    public static int encodingSolution(String s){
        char[] arr = s.toCharArray();
        System.out.println(arr.length);
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        //状态转移方程
//        dp[i] = dp[i-2]+dp[i-1];
        //i=0-6 1X 2X
        for (int i = 2; i <= s.length(); i++) {
            String sub = s.substring(i-2,i);
            int a = Integer.parseInt(sub);
            if (a==10){
                dp[i] = dp[i-2];
            }
            else if (a>10 && a<=26){
                dp[i] = dp[i-2]+dp[i-1];
            }else {
                dp[i] = dp[i-1];
            }
            
        }
        System.out.println(dp[s.length()]);
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "121";
        encodingSolution(s);
    }
}
