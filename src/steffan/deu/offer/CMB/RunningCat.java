package steffan.deu.offer.CMB;

import java.util.Scanner;

/**
 * 递归做猫跑步的问题
 */
public class RunningCat {
    public static int findMinStep(int target){
        target = Math.abs(target);
        if (target==0){
            return 0;
        }
        if (target==1){
            return 1;
        }else if (target%2==0){
            return findMinStep(target/2);
        }else {
            return Math.min(findMinStep(target-1)+1,findMinStep(target+1)+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(findMinStep(target));
    }
}
