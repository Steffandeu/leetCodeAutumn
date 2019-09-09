package steffan.deu.offer.Tecent;

public class PermutationAndCombination {
    public static class Person{
        int pre;
        int rear;
        public Person(int pre,int rear){
            this.pre = pre;
            this.rear = rear;
        }
    }
    public static void generatePermutation(int[] nums){
        int length = nums.length;
        int start = 0;
        int end = length-1;
        helper(nums,start,end);
    }


    private static void helper(int[] nums,int start,int end){
        if (start==end){
            System.out.println("------------------");
            for (int i = 0; i < nums.length; i++) {

                System.out.println(nums[i]);
            }
            return;
        }else {
            for (int i = start; i < nums.length; i++) {
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
//                System.out.println("===========");
//                for (int j = 0; j < nums.length; j++) {
//                    System.out.println(nums[j]);
//                }
                helper(nums,start+1,end);
                temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;

            }
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = i+1;
        }
        Person[] personList = new Person[k];
        personList[0] = new Person(2,1);
        personList[1] = new Person(3,2);
        personList[2] = new Person(3,3);
        generatePermutation(nums);
    }

}
