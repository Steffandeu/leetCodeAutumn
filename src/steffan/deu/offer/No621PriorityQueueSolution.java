package steffan.deu.offer;

import java.util.*;

public class No621PriorityQueueSolution {
    public int leastInterval(char[] tasks,int n){
        if (n==0) return tasks.length;
        Map<Character,Integer> taskToCount = new HashMap<>();
        for (char c : tasks){
            taskToCount.put(c,taskToCount.getOrDefault(c,0)+1);
        }

//        Queue<Integer> queue = new PriorityQueue<>((i1,i2) -> i2 - i1);
        Queue<Integer> queue = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (char c : taskToCount.keySet()) queue.offer(taskToCount.get(c));

        Map<Integer,Integer> coolDown = new HashMap<>();
        int currTime = 0;
        while (!queue.isEmpty() || coolDown.isEmpty()){
            if (coolDown.containsKey(currTime-n-1)){
                queue.offer(coolDown.remove(currTime-n-1));
            }
            if (!queue.isEmpty()){
                int left = queue.poll() - 1;
                if (left!=0) coolDown.put(currTime,left);
            }
            currTime++;
        }
        return currTime;
    }

    //priorityqueue enables us to greedily select the task with the highest occurence to do
//    public int leastInterval2(char[] tasks,int n){
//        int[] asas = new int[n];
//        Queue<Integer> cooldown = new LinkedList<>();//cooldown tracker
//        PriorityQueue<Integer> queue = new PriorityQueue<>((i1,i2)->i2-i1);
//        int intervals = 0,taskDone = 0,taskToDo = tasks.length;
//
//    }

    public static void main(String[] args) {
        Queue<Integer> testQueue = new PriorityQueue<>((i1,i2) ->i2-i1);//descending order()降序排列
        int[] nums = new int[]{1,3,6,7,2,5};
        for (int i : nums){
            testQueue.offer(i);
        }
//        System.out.println(testQueue.size());
        for (int i = 0; i < 6; i++) {
            System.out.println(testQueue.poll());
        }
    }
}
