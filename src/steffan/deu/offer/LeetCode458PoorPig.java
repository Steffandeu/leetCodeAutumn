package steffan.deu.offer;

public class LeetCode458PoorPig {
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest){
        //buckets为桶数，例子中是1000，minutesToDie是15，minutesToTest是60
        int base=minutesToTest/minutesToDie+1;
        double temp=Math.log(buckets)/Math.log(base);//log是以e为底的对数
        return (int)Math.ceil(temp);//ceil向上取整
    }

    public static void main(String[] args) {
        System.out.println(poorPigs(1000,15,60));
    }

}
