package steffan.deu.offer.Tecent;

import java.util.Scanner;

public class TeaCaffeProblem {


    public static class Person{
        int a;
        int b;
        boolean isVisited;

        public Person(int a,int b){
            this.a = a;
            this.b = b;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        Person[] queue = new Person[n];
        for (int i = 0; i <n ; i++) {
            queue[i] = new Person(sc.nextInt(),sc.nextInt());
        }
        best = Integer.MAX_VALUE;
        System.out.println(gen(queue,n,0,0));
    }

    private static int best=0;

    private static int gen(Person[] list,int n,int level,int cs){
        boolean isEnd = true;
        for (int i = 0; i < n; i++) {
            if (!list[i].isVisited){
                isEnd = false;
                list[i].isVisited = true;
                int c = list[i].a * level + list[i].b * (n-level-1);
                cs += c;
                gen(list,n,level+1,cs);
                cs -= c;//回溯法
                list[i].isVisited = false;
            }
        }
        if (level==n && isEnd && cs < best) best = cs;
        return best;

    }
}
