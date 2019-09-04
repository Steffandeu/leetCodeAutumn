package steffan.deu.offer;

public class No334ReverseString {
    public void reverseString(char[] s){
        int i = 0;
        int j = s.length-1;
        while (i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    //双指针但是用异或来处理
    public void reverseString(String s){
        char[] word = s.toCharArray();
        int i = 0;
        int j = word.length-1;
        while (i<j){
            word[i] = (char)(word[i]^word[j]);
            word[j] = (char)(word[i]^ word[j]);
            word[i] = (char)(word[i]^word[j]);
            i++;
            j++;
        }
    }

    //递归来处理
    public void  reverseString2(char[] s){
        swap(0,s.length-1,s);
    }
    private void swap(int start,int end,char[] s){
        if (start>=end) return;
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        swap(start+1,end-1,s);
    }

}
