package RepeatedNumberInArray;

public class Duplicationzwei {
    public boolean repeatNumber(int[] array,int[] duplication){
        int length = array.length;
        for (int i = 0; i <length ; i++) {
            if (array[i]<0 || array[i]>length-1){
                return false;
            }
        }
        int[] hash = new  int[length];
        for (int i = 0; i < length; i++) {
            hash[array[i]]++;
        }
        for (int i = 0; i <length ; i++) {
            if (hash[i] >1){
                duplication[0] = i;
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,0,2,5,4};
        int[] duplication = {0,0,0,0};
        Duplicationzwei dz = new Duplicationzwei();
        dz.repeatNumber(array,duplication);
//        this.repeatNumber(array)
        System.out.println(duplication[0]);
    }
}
