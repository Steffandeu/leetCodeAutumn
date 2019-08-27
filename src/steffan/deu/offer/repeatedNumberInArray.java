package steffan.deu.offer;

/**
 * 不需要额外的空间来存储
 */

public class repeatedNumberInArray {
    public boolean duplicate(int numbers[],int length,int [] duplication){
        if (numbers==null || numbers.length==0) return false;

        //判断数组是否合法
        for (int i = 0; i < length; i++) {
            if (numbers[i]<0 || numbers[i]>length-1){
                return false;
            }
            
        }

        int[] hash = new int[length];
        for (int i = 0; i < length; i++) {
            hash[numbers[i]]++;
        }
        for (int i = 0; i < length; i++) {
            if (hash[i]>1){
                duplication[0]=i;
                return true;
            }
        }
        return false;

    }
}
