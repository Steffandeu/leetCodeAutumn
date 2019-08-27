package steffan.deu.offer.CMB;

public class No14MaxMultipleOfN {
    public int maxMultioleOfN(int n){
        if (n<2){
            return 0;
        }
        if (n==2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        int[] results = new int[n+1];
        results[0] = 0;
        results[1] = 1;
        results[2]=2;
        results[3] = 3; //3的时候可以不用分了
        int max = 0;
        for (int i = 4; i <n ; i++) {
            max = 0;
            for (int j = 1; j < i/2; j++) {
                int result = results[j]*results[i-j];
                if (max<result) max = result;

                results[i] = max;
            }
        }
        max = results[n];
        return max;
    }


    public int maxProduct(int n){
        if (n<2) return 0;
        if (n==2) return 1;
        if (n==3) return 2;

        //greedy
        /**
         * 4 = 2 + 2= 2*2 == 4
         * 5 = 2 + 3 3*2 >5;
         */

        int timeOf3 = n/3;
        //当剪的绳子还剩下4的时候,不在找3了
        if (n-timeOf3*3==1) timeOf3 -= 1;

        int timesOf2 = (n-timeOf3*3)/2;

        return (int)Math.pow(3,timeOf3)*(int)Math.pow(2,timesOf2);

    }
}
