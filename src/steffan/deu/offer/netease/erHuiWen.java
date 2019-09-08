package steffan.deu.offer.netease;

import java.util.ArrayList;
import java.util.Scanner;
public class erHuiWen {
    public static void main(String[] args) {
        boolean flag = false;
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int a = in.nextInt();
            String s = int2(a);
            if (isHuiWen(s)){
                arrayList.add("YES");
            }else {
                arrayList.add("NO");
            }
        }
        for(String s :arrayList){
            System.out.println(s);
        }
    }

    public static String int2(int i){
        String s = "";
        while (i>0){
            if (i%2!=0){
                s="1"+s;
            }else {
                s = "0" + s;
            }
            i = i/2;
        }
        return s;
    }

    public static boolean isHuiWen(String s){
        int i =0;
        int j = s.length()-1;
        while (i<j){
            if (!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}