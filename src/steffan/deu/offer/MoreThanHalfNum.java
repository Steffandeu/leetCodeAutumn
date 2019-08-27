package steffan.deu.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int[] numbers){
        if (CheckInvalidArray(numbers)) return 0;

        int middle = numbers.length/2;
        int start = 0;
        int end = numbers.length-1;
        int index  = Partition(numbers,start,end);
        while (index!=middle){
            if (index>middle){
                end = index -1;
                index = Partition(numbers,start,end);
            }else{
                start = index +1;
                index = Partition(numbers,start,end);
            }
        }
        int result = numbers[middle];
        if (!CheckMoreThanHalf(numbers,result))
            result = 0;
        return result;
    }

    public boolean CheckInvalidArray(int[] numbers){
        boolean flag = false;

        if (numbers==null || numbers.length<=0) flag = true;
        return flag;
    }

    public boolean CheckMoreThanHalf(int[] numbers,int result){
        int times = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]==result) times++;
        }
        boolean flag = true;
        if (times*2 <= numbers.length){
            flag = false;
        }
        return flag;
    }

    public  static int Partition(int[] nums,int start,int end){
        int pivotKey = start + (int)Math.random()*(end-start);
        while (start < end){
            while (start<end && nums[end]>nums[pivotKey]){
                end--;
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end]= temp;
            }

            while(start<end && nums[start]>nums[pivotKey]){
                start++;
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end]= temp;

            }
        }
        return start;

    }
}
