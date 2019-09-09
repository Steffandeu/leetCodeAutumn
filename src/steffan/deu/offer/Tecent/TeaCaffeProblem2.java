package steffan.deu.offer.Tecent;

import java.util.Scanner;

public class TeaCaffeProblem2 {
    static int res = Integer.MAX_VALUE;
    static int n = 0;
    static int bt[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        bt = arr;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] =i +1;
        }
        perm(a,0,a.length-1);
        System.out.println(res);

    }
    public static void perm(int[] buf,int start,int end){
        System.out.println("perm start end: "+ start + " "+ end);
        if (start==end){
            for (int i = 0; i < buf.length; i++) {
                System.out.println("if buf: "+ buf[i]);

            }
            int t = 0;
            for (int i = 0; i <=end ; i++) {
                t+=bt[i][0]*(buf[i]-1) + bt[i][1]*(n-buf[i]);
            }
            if (t<res){
                res = t;
            }
        }else {
            for (int i = start; i <=end; i++) {
                System.out.println("i: "+ i);
                System.out.println("start: "+start);
                int temp = buf[start];
                buf[start] = buf[i];
                buf[i] = temp;
                for(int j =0;j<n;j++){
                    System.out.println("buf[] before: "+ buf[j]);
                }
                //后续元素递归全排列
                perm(buf,start+1,end);
                //交换后的数组还原
                temp = buf[start];
                buf[start] = buf[i];
                buf[i] = temp;
                for(int j =0;j<n;j++){
                    System.out.println("buf[] after: "+ buf[j]);
                }
                
            }
        }
    }
}
