package MaximumWindows;

import java.util.ArrayList;
/*
两次循环
 */

public class ForceSolution {
    public ArrayList<Integer> MaxmimumWindow(int[] num,int size){
        ArrayList<Integer> result = new ArrayList<>();
        int windowsLength = num.length - size +1;
        for (int i = 0; i < windowsLength ; i++) {//不能超过那个长度
            int currentLength = i + size;
            int max = num[i];
            for (int j = i; j <currentLength ; j++) {
                if (num[j]>num[i]){
                    max = num[j];
                }
            }
            result.add(max);

        }
        return result;
    }
}
