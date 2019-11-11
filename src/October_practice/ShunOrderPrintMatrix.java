package October_practice;

import java.util.ArrayList;

public class ShunOrderPrintMatrix {
    public static ArrayList<Integer> printMatrix(int[][] array){
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int row = array.length;
        System.out.println("row: "+row);//行
        int colum = array[0].length;
        System.out.println("colum: "+colum);//列
        while (row!=0){
            for (int i = 0; i < array[0].length; i++) {
                integerArrayList.add(array[0][i]);
            }
            if (row==1){
                break;
            }
            array = DropAndTurn(array);
            row = array.length;
        }
        return integerArrayList;
    }

    public static int[][] DropAndTurn(int[][] array){
        int[][] turnBefore = new int[array.length-1][array[0].length];
        for (int i = 0; i < turnBefore.length; i++) {
            for (int j = 0; j < turnBefore[0].length; j++) {
                turnBefore[i][j] = array[i+1][j];
            }
        }
        int[][] turnResult = new int[turnBefore[0].length][turnBefore.length];
        int temp = turnBefore[0].length-1;
        for (int i = 0; i < turnResult.length; i++) {
            for (int j = 0; j < turnResult[0].length ; j++) {
                turnResult[i][j] = turnBefore[j][temp];
            }
            temp--;
            if (temp<0){
                break;
            }
        }
        return turnResult;
    }

    public static void main(String[] args) {
        int[][] before = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] result = DropAndTurn(before);
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList = printMatrix(before);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }
    }
}
