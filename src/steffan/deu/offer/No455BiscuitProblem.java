package steffan.deu.offer;

import java.util.Arrays;

public class No455BiscuitProblem {
    public static int findContentChildren(int[] g,int[] s){
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0,j=0; i < g.length && j<s.length;) {
            if (g[i]<=s[j]){
                count++;
                j++;
                i++;
            }else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] s = new int[]{1,3,2};
        int[] g = new int[]{1,2,3};
        System.out.println(findContentChildren(g,s));
    }
}
