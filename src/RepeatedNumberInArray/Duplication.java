package RepeatedNumberInArray;

public class Duplication {
    public boolean duplicate(int array[],int length,int [] duplication){
        //先检验那个数组的范围
        for (int i = 0; i < length; i++) {
            if (array[i]<0 || array[i]> length-1){
                return false;
            }

        }
        int[] hash = new int[length];
        for (int i = 0; i < length; i++) {
            hash[array[i]]++;

        }
        for (int i = 0; i < length; i++) {
            if (hash[i]>1){
                duplication[0] = i;
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,0,2,5,1};
        int[] duplication = {-1};
        Duplication d = new Duplication();
        d.duplicate(array,7,duplication);
//        this.repeatNumber(array)
        System.out.println(duplication[0]);
    }
}
