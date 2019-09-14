package steffan.deu.offer;

import java.util.HashMap;
import java.util.Map;

public class No76MinimumWindowsSubstring {
    //silding windows
    public String minWindows(String s,String t){
        if (s.length()==0 || t.length()==0) return "";

        //用一个hashmap来判定窗口内是否含有了所有的元素
        Map<Character,Integer> dict = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dict.getOrDefault(t.charAt(i),0);
            dict.put(t.charAt(i),count+1);
        }

        int requiredSize = dict.size();
        int left = 0;
        int right = 0;

        int formed = 0;
        Map<Character,Integer> windowsCount = new HashMap<>();
        //窗口长度 ，左，右
        int[] ans = {-1,0,0};
        while (right<s.length()){
            char c = s.charAt(right);
            int count = windowsCount.getOrDefault(c,0);
            if (dict.containsKey(c) && windowsCount.get(c).intValue()==dict.get(c).intValue()){
                formed++;
            }
            while(left<right && formed == requiredSize){
                c = s.charAt(left);
                if (ans[0] == -1||right-left+1<ans[0]){
                    ans[0] = right-left+1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowsCount.put(c,windowsCount.get(c)-1);
                if (dict.containsKey(c) && windowsCount.get(c).intValue()<dict.get(c).intValue()){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0]==-1 ? "" : s.substring(ans[1],ans[2]+1);
    }
}
