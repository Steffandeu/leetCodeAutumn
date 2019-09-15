package steffan.deu.offer.ctrip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RangeSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int logCount = sc.nextInt();
        int count = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < logCount; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (b<=count && c>=count){
                arrayList.add(a);
            }
            
        }
        if (arrayList.isEmpty()){
            System.out.println("null");
        }else {
            Collections.sort(arrayList);
            for (Integer integer : arrayList){
                System.out.println(integer);
            }
        }
    }
}
