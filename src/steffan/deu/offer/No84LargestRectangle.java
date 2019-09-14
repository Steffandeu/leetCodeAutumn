package steffan.deu.offer;

public class No84LargestRectangle {
    //divide and conquer

    public int caculateArea(int[] nums,int start,int end){
        if (start>end) return 0;
        int minIndex = start;
        for (int i = start; i <=end ; i++) {
            if (nums[minIndex]>nums[i]){
                minIndex = i;
            }
        }
        return Math.max(nums[minIndex]*(end-start+1),Math.max(caculateArea(nums,start,minIndex-1),caculateArea(nums,minIndex+1,end)));
    }

    public int largestRectangleArea(int[] heights){
        return caculateArea(heights,0,heights.length-1);
    }


    //暴力搜索


    public static void main(String[] args) {
        int[] heights = new int[]{6,4,5,2,4,3,9};
        int minIndex = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[minIndex]>heights[i]){
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }
}
