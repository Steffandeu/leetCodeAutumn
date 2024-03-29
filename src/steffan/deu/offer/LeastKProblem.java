package steffan.deu.offer;

import java.util.ArrayList;

public class LeastKProblem {

    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<Integer>();
        while(input==null || k<=0 || k>input.length)
            return leastNumbers;
        int start=0;
        int end=input.length-1;
        int index=partition(input,start,end);
        while(index!=k-1){
            if(index<k-1){
                start=index+1;
                index=partition(input,start,end);
            }else{
                end=index-1;
                index=partition(input,start,end);
            }
        }
        for(int i=0;i<k;i++){
            leastNumbers.add(input[i]);
        }
        return leastNumbers;
    }

    private int partition(int[] arr, int start,int end){
        int i = 1;
        int pivotKey=arr[start];
        while(start<end){
            while(start<end && arr[end]>=pivotKey)
                end--;
                i++;
            System.out.println(end+"第"+i);
            swap(arr,start,end);
            while(start<end && arr[start]<=pivotKey)
                System.out.println(start+"第"+i);
                start++;
                i++;
            swap(arr,start,end);
        }
        return start;
    }

    private void swap(int[] arr, int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] input = {4,1,5,6,2};
        int k = 2;
        ArrayList<Integer> result = new ArrayList<>();
        LeastKProblem leastKProblem = new LeastKProblem();
        result = leastKProblem.GetLeastNumbers_Solution1(input,k);

    }
}
