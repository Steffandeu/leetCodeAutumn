package steffan.deu.offer.CMB;

public class ChickenAndDuck {
    public static int solution(String s){
        char[] arr = s.toCharArray();
        int l=0;
        int r = 0;
        int reC = 0;
        int reD = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i]=='C'){
                reC += i-l;
                l++;
            }else {
                reD += i-r;
                r++;
            }
        }
        System.out.println(Math.min(reC,reD));
        return Math.min(reC,reD);
    }

    public static void main(String[] args) {
        String s = "CCCCDCCD";
        System.out.println(solution(s));
    }


}
