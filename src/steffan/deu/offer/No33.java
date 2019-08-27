package steffan.deu.offer;

public class No33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null || sequence.length<=0) return false;
        int root = sequence[sequence.length-1];
        return verifySequenceOfBST(sequence,0,sequence.length-1);

    }
    private boolean verifySequenceOfBST(int[] sequence,int start,int end){
        if (start>=end)//最后为根
            return true;
        int root = sequence[end];
        int i = start;
        while (sequence[i]<root){
            i++;
        }
        int j = i;
        while (j<end){
            if (sequence[j]<root){
                return false;
            }
            j++;
        }

        boolean left = verifySequenceOfBST(sequence,start,i-1);
        boolean right = verifySequenceOfBST(sequence,i,end-1);
        return  left && right;

    }



}
