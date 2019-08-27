package steffan.deu.offer;

import java.util.HashMap;
import java.util.Map;

public class No56Solution {
    public void FindNumsAppearOnce(int[] array,int[] nums1,int[] nums2){
        if (array == null || array.length == 0){
            nums1[0] = nums2[0]=0;
            return;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                map.put(array[i],2);
            }else {
                map.put(array[i],1);
            }
        }
        nums1[0] = 0;//解决标志位的问题
        for (Map.Entry entry:map.entrySet()){
            if ((Integer)entry.getValue()==1){
                if (nums1[0]==0){
                    nums1[0] =(Integer)entry.getKey();
                }else {
                    nums2[0] = (Integer)entry.getKey();
                }
            }
        }
    }
}
