package steffan.deu.offer;

public class No56Solution2 {
    public void FindNumsAppearOnce(int[] array,int[] nums1,int[] nums2){
        if (array == null || array.length == 0){
            nums1[0] = nums2[0]=0;
            return;
        }
        int bitResult = 0;
        for (int i = 0; i < array.length; i++) {
            bitResult ^= array[i];
        }

        int index = findFirst1(bitResult);
        for (int i = 0; i< array.length ; i++) {
            if (IsBit(array[i],index)){
                nums1[0]^=array[i];
            }else {
                nums2[0]^=array[i];
            }
            
        }
    }

    public int findFirst1(int num){
        int indexBit = 0;
        while((num & 1)==0 && (indexBit<32)){
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }


    public boolean IsBit(int num,int indexBit){
        num = num >> indexBit;
        return (num & 1)==1;
    }

}
