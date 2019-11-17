package RankAlgorithm;

import java.util.Arrays;

public class InsertSort {

    public static void insertSort(int[] arrays){
        int length = arrays.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j >0 ; j--) {
                if (arrays[j]<arrays[j-1]){
                    sortUtils.swap(arrays,j,j-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{6,7,8,1,3,12,10,5,2,4,9,16};
        insertSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
