package Jugeofquadraticsum;

import java.util.Scanner;

public class sqrt {
    public boolean judgeSquareSum(int c ){
        int i = 0;
        int j = (int)Math.sqrt(c);
        while (i<=j){
            int powsum = i*i + j*j;
            if (powsum == c){
                System.out.println("this number can be spilt to two numbers' pow");
                return true;
            }else if (powsum < c){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter a number for check: ");
        int number = input.nextInt();
        sqrt s = new sqrt();
        s.judgeSquareSum(number);
    }
}
