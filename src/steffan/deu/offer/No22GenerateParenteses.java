package steffan.deu.offer;

import java.util.ArrayList;
import java.util.List;

public class No22GenerateParenteses {

    //method1： without BackTracing
    public static List<String> generate(int n){
        int start = 0;
        char[] chars = new char[n*2];
        List<String> result = new ArrayList<>();
        dfs(chars,0,result);
        return result;
    }
    public static void dfs(char[] chars,int index,List<String> result){
        if (index==chars.length){
            if (vailidCheck(chars)){
                result.add(new String(chars));
            }
        }else {
            chars[index] = ')';
            dfs(chars,index+1,result);
            chars[index] = '(';
            dfs(chars,index+1,result);
        }

    }

    public static boolean vailidCheck(char[] chars){
        int balance = 0;
        for (char c : chars){
            if (c=='('){
                balance++;
            }else {
                balance--;
            }
            if (balance<0){
                return false;//判断是否是闭合的
            }
        }
        return (balance==0);
    }

    ///////////////////////////////////////////////////////////////
    //backTracing problem

    public static List<String> generateParenthesis(int n){
        List<String> combination = new ArrayList<>();
        backTracingDFS(combination,"",0,0,n);
        return combination;

    }

    public static void backTracingDFS(List<String> combination,String cur,int open,int end,int max){
        if (cur.length()==max*2){
            combination.add(cur);
            return;
        }
        if (open<max){
            backTracingDFS(combination,cur+"(",open+1,end,max);
        }
        if (end<open ){
            backTracingDFS(combination,cur+")",open,end+1,max);
        }
    }


    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        for(String s: result){
            System.out.println(s);
        }
    }

}
