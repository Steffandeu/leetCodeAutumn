package steffan.deu.offer.CMB;

public class eatCatFood {

    public static int costTime(int[] nums,int k){
        int totalHour = 0;
        for (int i = 0; i < nums.length; i++) {
           totalHour+=(nums[i]+k-1)/k;
        }
        return totalHour;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{3,6,7,11};
        int h = 8;
        int total = 0;
        for (int i = 0; i <nums.length ; i++) {
            total += nums[i];
        }
        int k = total/h;
        while (costTime(nums,k)> h){
            k++;
        }
        System.out.println(k);

    }
}
