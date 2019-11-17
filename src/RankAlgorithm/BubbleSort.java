package RankAlgorithm;

public class BubbleSort {

    public static void bubbleSort(int[] array){
        int length = array.length;
        if (length<=1) return;

        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length-i-1; j++) {
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,1,2,5,7,6,8,10,12,9,16};
        System.out.println("before: ");

    }
}
