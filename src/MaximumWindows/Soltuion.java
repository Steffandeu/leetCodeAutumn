package MaximumWindows;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Soltuion {

    public ArrayList<Integer> maxWindows(int[] num,int size){
        ArrayList<Integer> result = new ArrayList<>();
        if (num ==null || num.length==0 || size==0 || size>num.length){
            return result;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[i]>num[queue.getLast()]){
                queue.removeLast();
            }
            queue.offer(i);
            if (i+1>=size){
                result.add(num[queue.getFirst()]);
            }
            if (i+1>size){

            }
        }
        return result;
    }

}
