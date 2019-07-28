package MergeOrganizedArray;

public class Merge {
    public void merge(int[] nums1,int[] nums2,int m,int n){
        int index1 = m-1;
        int index2 = n-1;
        int mergeindex = m+n-1;
        while (index1>=0 || index2 >=0){
            if (index1<0){
                nums1[mergeindex--] = nums2[index2--];
            }else if (index2<0){
                nums1[mergeindex--] = nums1[index1--];
            }else if (nums1[index1]>nums2[index2]){
                nums1[mergeindex--] = nums1[index1--];

            }else{
                nums1[mergeindex--] = nums2[index2--];
            }
        }
    }

    public void merge2(int[] array1,int[] array2,int m,int n){
        while((m-1)>=0 || (n-1)>=0){
            if (n==0){
                break;
            }else if (m==0){
                array1[n-1] = array2[n-1];
                n--;
                continue;
            }else if (array1[m-1]>array2[n-1]){
                array1[m+n-1] = array1[m-1];
                --m;
            }else {
                array1[m+n-1] = array2[n-1];
                --n;
            }
        }
    }

    public static void main(String[] args) {
        Merge me = new Merge();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m =3;
        int n = 3;

//        me.merge(nums1,nums2,m,n);

        me.merge2(nums1,nums2,m,n);

        for (int value : nums1){
            System.out.println(value);
        }
    }
}
