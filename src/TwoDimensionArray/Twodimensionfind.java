package TwoDimensionArray;
/*
[                 减少
[1,2,8,9]       <--------number
[2,4,9,12]                   | 增加，不断减少搜索范围；
[4,7,10,13]                  |
[6,8,11,15]                  |
]                            ^
从右上开始查找；
若小于targetnumber，去掉这一行 ++i
若大于targetnumber，去掉这一列 ——j
 */

public class Twodimensionfind {
    public boolean searchTwoDimension(int[][] array,int targetNumber){
        int m = array.length;//hang
        int n = array[0].length;//lie
        int i = 0;//行
        int j = n-1;//列
        while(i< m && j>=0) {
            if (array[i][j] == targetNumber) {
                return true;
            }
            if (array[i][j] < targetNumber) {
                ++i;
            } else {
                --j;
            }
        }
        return false;
    }

    public boolean searchTwoDimensionLeftDown(int[][] array,int target){
        int m = array.length;//行
        int n = array[0].length;//列
        int i = m-1;
        int j = 0;
        if (array == null||array.length<1){
            return false;
        }
        while (j< n && i>=0){
            if (array[i][j]==target){
                return true;
            }
            if (array[i][j]>target){
               i--;
            }else {
                j++;
            }
        }
        return false;
    }
}
