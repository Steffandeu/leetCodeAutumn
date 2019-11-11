package October_practice;

public class shuzhiZhengshuCiFang {
    public double Power(double base,int exponent){
//        if (base==0 && exponent==0) return 0;
        double res = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            res *=base;
        }
        if (exponent<0){
            res = 1/res;
        }
        return res;
    }

    //递归解析
    public double Power_2(double base,int exponent){
        int n = Math.abs(exponent);
        if (n==0) return 1;
        if (n==1) return base;
        double result = Power_2(base,n>>1);
        result *=result;
        if (n%2==1){
            result *= base;
        }
        if (exponent<0){
            result = 1/result;
        }
        return result;
    }
}
