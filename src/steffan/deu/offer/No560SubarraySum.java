package steffan.deu.offer;

import java.util.HashMap;

public class No560SubarraySum {
    //1: cumulative sum
    public int subarraySum(int[] nums,int k){
        if (nums.length==0 || nums==null){
            return 0;
        }
        int[] sum = new int[nums.length];
        int s = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            s+= nums[i];
            sum[i] = s;
            if (s==k){
                ans++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if (sum[i]-sum[j]==k){
                    ans++;
                }
            }
        }
        return ans;
    }

    //2:hashmap方法
    /**
     * 遍历数组nums，计算从第0个元素到当前元素的和，用哈希表保存出现过的累积和sum的次数。
     * 如果sum - k在哈希表中出现过，则代表从当前下标i往前有连续的子数组的和为sum。
     * 时间复杂度为O(n)，空间复杂度为O(n)。
     * sum[i]-sum[j] is continuous sum from index i to index j;
     */
    public int subarraySumHashMap(int[] nums,int k){
        if (nums.length==0 || nums==null){
            return 0;
        }
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i <nums.length ; i++) {
            sum += nums[i];
            //检查是否存在sum[i] + k = sum[j];
            if (map.containsKey(sum-k)){//index对应的值与target的
                count +=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;

    }
}
