package steffan.deu.offer.CMBCC;

import java.util.Scanner;

public class exam01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] inputs = input.toCharArray();
        int num = input.length();
        int[] result = new int[num];
        boolean[] flag = new boolean[num];
        for (int i = 0; i < num; i++) {
            result[i] = 1;
            if (i<num-1&&inputs[i]=='R'&&inputs[i+1]=='L'){
                flag[i] =true;
            }
        }
        for (int i = 0; i < num; i++) {
            if (inputs[i]=='R'&&!flag[i]){
                for (int j = i; j < num; j++) {
                    if (flag[j]){
                        if ((j-i)%2==0){
                            result[i] = 0;
                            result[j]++;
                        }else {
                            result[i] = 0;
                            result[j+1]++;
                        }
                        break;
                    }
                }
            }else if (inputs[i]=='L'&& !flag[i-1]){
                for (int j = i; j >=0 ; j--) {
                    if (flag[j]){
                        if ((j-i)%2==0){
                            result[i] = 0;
                            result[j]++;
                        }else {
                            result[i]=0;
                            result[j+1]++;
                        }
                        break;
                    }
                }
            }

        }
        for (int i = 0; i < num; i++) {
            System.out.print(result[i]);
            if (i<num-1){
                System.out.print(" ");
            }
        }



    }
}
