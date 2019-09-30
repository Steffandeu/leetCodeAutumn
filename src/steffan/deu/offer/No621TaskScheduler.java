package steffan.deu.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class No621TaskScheduler {
    public int leastInterval(char[] tasks,int n){
      int[] freq = new int[26];
      for (char c :tasks) freq[c-'A']++;
      Arrays.sort(freq);
      int time = 0;
      while (freq[25]>0){//start from most freq task
          for (int i = 0,p=25; i <=n ; i++) {//n is the coolong down factor, p point to the next task to consume
              if (p>=0 && freq[p]>0){
                  freq[p]--;
                  p--;
                  time++;
              }else if (freq[25]!=0){
                  time++;
              }
          }
          Arrays.sort(freq);
      }
      return time;
    }
}
