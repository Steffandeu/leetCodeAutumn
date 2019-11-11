package October_practice;

public class NiXuDuiArray {
    public int InversePair(int[] array){
        if (array==null|| array.length==0) return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairFindHelper(array,copy,0,array.length-1);
        return count;
    }

    public int InversePairFindHelper(int[] array,int[] copy, int low,int high){
        if (low==high){
            return 0;
        }
        int mid = (low+high)>>1;
        int leftCount = InversePairFindHelper(array,copy,low,mid)%1000000007;
        int rightCount = InversePairFindHelper(array,copy,mid+1,high)%1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i>=low && j>mid){
            if (array[i]>array[j]){
                count += j-mid;
                copy[locCopy--]=array[j--];
                if (count>=1000000007){
                    count=count%1000000007;
                }
            }
            else {
                copy[locCopy--] = array[j--];
            }
        }
        for(;i>=low;i--)
        {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;

    }
}
