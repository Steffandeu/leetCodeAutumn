package RankAlgorithm;

public class QuickSort {
    public static int partition(int[] array,int low,int high){
        int base = array[low];
        int i = low;
        int j = high;
        while (i!=j){
            while (i<j && array[j]>base){
                j--;
            }
            if (i<j){
                array[i]=array[j];
                i++;
            }
            while (i<j && array[i]<base){
                i++;
            }
            if (i<j){
                array[j] = array[i];
                j--;
            }
            array[i] = base;
        }
        array[i] = base;
        return i;
    }
    public static void quickSortAlgorithm(int[] array,int low,int high){
        if (low<high){
            int i = partition(array,low,high);
            quickSortAlgorithm(array,low,i-1);
            quickSortAlgorithm(array,i+1,high);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,6,7,2,1,9,8,10,12,4,16,5};
        quickSortAlgorithm(array,0,array.length-1);
    }
}
