package steffan.deu.offer;

public class KMPProblem {
    /**
     * String  str1=“abceacmk32acmzq”
     *
     * String str2=“acm”
     *
     * 可以看出，str1包含两处str2，下面红色地方：
     *长度为n的文本串S和长度为m模式串P，在文本串S中是否存在一个有效偏移i，其中 0≤ i < n - m + 1，使得 S[i… i+m - 1] = P[0 … m-1]（注：下标从0开始）
     */

    public static int bruteForcefindIndexOf(String source,String pattern){
        int i=0;
        int j =0;
        int slen = source.length();
        int plen = pattern.length();
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();
        while (i <slen && j<plen){
            if (src[i]==ptn[j]){
                //如果匹配一致的话，两者各自加一
                j++;
                i++;
            }else{
                //腐国匹配不成功，则i回溯到此次匹配开始的位置+1处，也就是i = i-j +1；
                //example：i=2,j=2; i = 2-2 + 1;
                i = i -j + 1;
                j = 0;
            }
        }
        //匹配成功，则返回模式字符串在原字符串中首次出现的位置，否则返回-1
        if (j==plen){
            return i-j;
        }else {
            return -1;
        }
    }


//    public static int kmpSolution(String source,String pattern){
//
//    }

    private int[] getNext(char[] p){
        // 已知next[j] = k,利用递归的思想求出next[j+1]的值
        // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
        // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
        // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
        // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
        int plen = p.length;
        int[] next = new int[plen];
        int k = -1;
        int j = 0;
        next[0]=-1;//next数组中next[0] = -1;
        while(j<plen-1){
            if (k==-1||p[j]==p[k]){
                k++;
                j++;
                next[j]=k;
            }else {
                k= next[k];
            }
        }
        return next;
    } 
}
