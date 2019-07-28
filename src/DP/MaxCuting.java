package DP;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxCuting {

    public static int cutting(int n){

        if (n<=1){
            return 0;
        }
        if (n<=2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        int max = 0;
        int value[] = new int[n+1];
        value[0]=0;// 哈哈哈哈哈哈这个莫非也是从抖音上看到的
        value[1]=1;
        value[2]=2;
        value[3]=3;
        for (int i = 4; i <=n ; i++) {
            max =0;
            for (int j = 0; j <=i/2 ; j++) {
                int product = value[i]*value[i-j];
                if (product>max){
                    max =product;
                }
                value[i]=max;
            }
        }
        return value[n];
    }
}
