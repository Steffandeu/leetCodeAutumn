package steffan.deu.offer;

public class FirstNotRepeatingChar {
    public int solution(String str){
        if (str==null){
            return -1;
        }
        char[] chars = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chars.length; i++) {
            map[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]]==1) return i;
            
        }
        return -1;
    }
}
