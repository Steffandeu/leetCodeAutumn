package steffan.deu.offer.CMB;

import java.util.Arrays;
import java.util.Scanner;

public class PiaoLiuShip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1[] = sc.nextLine().split(" ");
        int limit = Integer.parseInt(sc.nextLine());
        int[] num = new int[s1.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(num);
        int left = 0;
        int right = num.length-1;
        int number = 0;
        while (left<right){
            if (num[left]+num[right]<=limit){
                left++;
                right--;
                number++;
            }else {
                right--;
            }
        }
        int shenyu = num.length -number*2;
        System.out.println(shenyu+number);
    }
}
