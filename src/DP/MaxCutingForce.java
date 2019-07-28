package DP;

public class MaxCutingForce {
    public int cuting(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        return search(n);
    }
    public int search(int n){//分成两个来算
        int max =0;
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        if (n==3){
            return 3;
        }
        for (int i = 1; i <=n/2 ; i++) {
            int result =  search(n-i) * search(i);
            if (result>max){
                max = result;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        MaxCutingForce  mf = new MaxCutingForce();
        System.out.println(mf.cuting(5));
    }
}
