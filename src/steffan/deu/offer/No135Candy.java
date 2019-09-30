package steffan.deu.offer;

import java.util.Arrays;

public class No135Candy {
    public int candy(int[] ratings){
        int sum = 0;
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < left.length; i++) {
            if (ratings[i]>ratings[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        for (int i = right.length-1; i >=1 ; i++) {
            if (ratings[i-1]>ratings[i]){
                right[i-1] = right[i]+1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i],right[i]);
        }
        return sum;
    }
}
