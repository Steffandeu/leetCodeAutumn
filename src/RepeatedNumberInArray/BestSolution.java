package RepeatedNumberInArray;

public class BestSolution {
    public int findDup(int[] arrays,int length){
        for (int i = 0; i <length ; i++) {
            int index = arrays[i];
            if (index >=length){
                index-=length;
            }

        }
        return -1;
    }
}
