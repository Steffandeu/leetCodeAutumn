package steffan.deu.offer;

public class IntegerOneCount {
    //solution 1
    public int NumberOf1Between1AndN_Solution(int n){
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < n+1; i++) {
            sb.append(i);
        }
        String str = sb.toString();
        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
    //solution 2
    public int NumberOf1Between1AndN(int n){
        if (n<0){
            return 0;
        }
        int count = 0;
        for (long i = 0; i <=n; i++) {
            long divier = i * 10;
            count += (n/divier)*i + Math.min(Math.max(n % divier - i + 1, 0), i);
        }
        return count;
    }


}
