package steffan.deu.offer;


import java.util.ArrayList;

public class No49UglyNumberSolution {
    public int GetUglyNumber_Solution(int index){
        if (index<=0) return 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        int i2 = 0,i3 = 0,i5=0;
        while(arrayList.size()<index){
            int m2 = arrayList.get(i2)*2;
            int m3 = arrayList.get(i3)*3;
            int m5 = arrayList.get(i5)*5;
            int min = Math.min(m2,Math.min(m3,m5));
            arrayList.add(min);
            if (min==m2) i2++;
            if (min==m3) i3++;
            if (min==m5) i5++;

        }
        return arrayList.get(arrayList.size()-1);
    }
}
