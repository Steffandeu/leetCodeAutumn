package Fibonaccisequence;

public class Fibonacci {
    //recursion realization
    public int Fibonacci(int num){
        if (num<2){
            return num;
        }else {
            return Fibonacci(num-1)+Fibonacci(num-2);
        }
    }

}
