package steffan.deu.offer.CMB;

import java.util.Scanner;

public class ReachNumber {

    public int reachTarget(int target){
        target = Math.abs(target);
        int count = 0;
        int sum = 0;
        while (sum<target){
            count++;
            sum += count;
        }
        if ((sum-target)%2!=0){
            if (count%2==0){
                count+=1;
            }else {
                count+=2;
            }
        }
        return count;

    }
}
