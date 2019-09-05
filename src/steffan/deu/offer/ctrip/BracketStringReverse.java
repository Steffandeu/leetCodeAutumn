package steffan.deu.offer.ctrip;

import java.util.Scanner;

/**
 * description：Hihocoder 1671
 */

/**
 * 首先将括号配对（用两个数组分别记录左括号对应右括号的的位置 和 右括号对应左括号的位置）
 * 然后就开始正序遍历，遇到普通非括号字符直接输出，
 * 遇到左括号，假装反转括号内的字符（添加rev标记并进入下次递归）
 * 如果有rev标记，逆序遍历，遇到普通非括号字符直接输出，
 * 遇到右括号，假装反转括号内的字符（去除rev标记并进入下次递归）
 */
public class BracketStringReverse {
    private int max = 5000010;
    char[] chars = new char[max];
    int[] st = new int[max];
    int[] ri = new int[max];
    int[] le = new int[max];
    int top =-1;


    public void dfs(int left,int right,boolean rev){
        int count = 0;
        if (!rev){//rev为false;
            for (int i = left; i <=right; i++) {
                if (chars[i]!='(') {
                    System.out.print(chars[i]);
                }else {
                    dfs(i+1,ri[i]-1,!rev);
                    i=ri[i];
                }
            }
        }else {//rev为true
            for (int i = right; i >=left; i--) {
                if (chars[i]!=')'){
                    System.out.print(chars[i]);
                }else {
                    dfs(le[i]+1,i-1,!rev);
                    i=le[i];
//                    System.out.println(i);
                }
                
            }
        }
    }

    public void reverse(String s){//括号配对
        chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len ; i++) {
            if (chars[i]=='('){
                st[++top] = i;
            }else if (chars[i]==')'){
                le[i] = st[top];
                ri[st[top]] = i;
                --top;
            }
        }
        dfs(0,len-1,false);
    }

    public static void main(String[] args) {
        String s = "a(bc(de)fg)hijk";
        BracketStringReverse reverse = new BracketStringReverse();
        reverse.reverse(s);
    }

}
