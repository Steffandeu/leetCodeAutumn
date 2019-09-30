package steffan.deu.offer;

import java.util.HashMap;

public class  No12RomanToInteger {
    private static HashMap<Character,Integer> roman = new HashMap<Character,Integer>(){{
        put('M', 1000);
        put('D', 500);
        put('C', 100);
        put('L', 50);
        put('X', 10);
        put('V', 5);
        put('I', 1);
    }

    };

    public static int romanToInt(String s) {
        int res = 0, pre = 0;
        for(Character c : s.toCharArray()){
            int cur = roman.get(c);
            System.out.println("cur: "+ cur);
            res += cur > pre ? cur - 2 * pre : cur;

            pre = cur;
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "IV";
        System.out.println(romanToInt(s));
    }

}
