package RankAlgorithm;

import java.util.Arrays;

public class SelectSort {

    public static void selectSort(int[] arrays){
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            int index = i;
//            int j;
            for (int j = i+1; j < length; j++) {
                if (arrays[j]<arrays[index]) index = j;
            }
            sortUtils.swap(arrays,index,i);
            System.out.println(Arrays.toString(arrays));
        }
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{3,4,1,6,7,9,12,16,8,2,5};
        selectSort(arrays);
    }
}
