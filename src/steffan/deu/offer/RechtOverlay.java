package steffan.deu.offer;

public class RechtOverlay {
    public int RectCover(int target){
        if (target<1){
            return 0;
        }
        if (target==1){
            return 1;
        }
        if (target==2){
            return 2;
        }else {
            return RectCover(target-1) + RectCover(target-2);
        }

    }
}
