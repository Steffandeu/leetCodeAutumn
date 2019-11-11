import java.util.ArrayList;
import java.util.Scanner;

public class PAT {
    public static ArrayList<String> checkCommonString(String s1,String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
//        char[] result = new char[Math.max(s1.length(),s2.length())];
        for (int i = 0; i < chars1.length-1; i++) {
            for (int j = 0; j < chars2.length-1; j++) {
                if (chars1[i]==chars2[j]){
                    int returnValue = spiltArray(chars1,chars2,i,j);
                    if (returnValue!=0){
                        arrayList.add(new String(chars1).substring(i,returnValue));
                        i= returnValue;
                    }
//
                }

            }
        }
        return arrayList;
    }

    public static int spiltArray(char[] c1,char[] c2,int index1,int index2){
        int start = index1;
        int end = 0;
        while (index1<=c1.length-1 && index2<=c2.length-1){
//            if (index1==c1.length-1 || index2 == c2.length-1) break;
//            System.out.println("before: index1: "+ index1+"before: index2: "+ index2);
            if (c1[index1]==c2[index2]){
                index1++;
                index2++;
//                System.out.println("index1:  "+index1 + "index2:  "+index2);
            }else {
               end = index1;
               break;
            }
        }
        String result = (new String(c1)).substring(start,end);
        if (result.length()>2){
            return end;
        }else {
            return 0;
        }


    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
//        String s1 = "1234567";
//        String s2 = "12893457";
        ArrayList<String> result = new ArrayList<>();
//        System.out.println(spiltArray(s1.toCharArray(),s2.toCharArray(),0,0));
//        System.out.println(result.size());
        result = checkCommonString(s1,s2);
        for (String s: result) {
            System.out.println(s);
        }

    }
}
