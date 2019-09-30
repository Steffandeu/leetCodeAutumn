package steffan.deu.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No17LetterCombination {
//    HashMap<Character,String> map = new HashMap<Character, String>(){{
//        map.put('2',"abc");
//        map.put('3',"def");
//        map.put('4',"ghi");
//        map.put('5',"jkl");
//        map.put('6',"mno");
//        map.put('7',"pqrs");
//        map.put('8',"tuv");
//        map.put('9',"wxyz");
//    }};

    public static List<String> letterCombinations(String digits){
       
        List<String> result = new ArrayList<>();
        char[] chars = digits.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]> '9' || chars[i]< '2'){
                return result;
            }
        }
        dfsMakeString(digits,0,result,"");
        return result;
    }
    
    public static void dfsMakeString(String digit, int index, List<String> result, String prefix){
        HashMap<Character,String> map = new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if (index==digit.length()){
            result.add(prefix);
            return;
        }
        char digits = digit.charAt(index);
//        Integer
        String letters = map.get(digits);
        for (int i = 0; i < letters.length() ; i++) {
            String substr = letters.substring(i,i+1);
//            result.add(prefix.concat(substr));
            dfsMakeString(digit,index+1,result,prefix.concat(substr));
        }
    }

    public static void main(String[] args) {
        String digit = "23";
        List<String> result = letterCombinations(digit);
        System.out.println(result.size());
        for(String s : result){
            System.out.println(s);
        }
        System.out.println(digit.substring(0,1));
    }
}
