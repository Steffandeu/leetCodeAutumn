package steffan.deu.offer;

public class No541ReverseString2 {
    public String reverseString(String s,int k){
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i=i+2*k) {
            if (i+k<=length || i+ 2*k<=length){
                swap(chars,i,i+k-1);
            }else {
                swap(chars,i,length-1);
            }
        }
        return new String(chars);

    }

    private void swap(char[] ch,int start,int end){
        if (start>=end) return;
        ch[start]^=ch[end];
        ch[end]^=ch[start];
        ch[start]^=ch[end];
        swap(ch,start+1,end-1);
    }
}
