package steffan.deu.offer;

public class No53FindNumber {
    public int GetNumberOfK(int [] array , int k){
        if (array.length==0 || array==null) return 0;
        int firstK = getFirstK(array,k,0,array.length);
        int lastK = getLastK(array,k,0,array.length);
        if(lastK!=-1 && firstK!=-1){
            return lastK - firstK;
        }
        return -1;
    }

    private int getFirstK(int[] array,int k,int start,int end){
        if (start>end) return -1;
        int mid = (end-start) >> 1;
        if ((array[mid]>k)){
            return getFirstK(array,k,start,mid-1);
        }else if (array[mid]<k){
            return getFirstK(array,k,mid+1,end);
        }else if (mid-1>=0 &&array[mid-1]==k){
            return getFirstK(array,k,start,mid-1);
        }else {
            return mid;
        }
    }

    public int getLastK(int[] array,int k,int start,int end){
        int mid = (start + end) >> 1;
        while (start<=end){
            if (array[mid]>k){
                end = mid -1;
            }else if (array[mid]<k){
                start = mid +1;
            }else if (mid +1<array.length && array[mid+1]==k){
                start = mid +1;
            }else {
                return mid;
            }
            mid = (start +end) >>1;
        }
        return -1;
    }
}
