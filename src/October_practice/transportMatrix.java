package October_practice;

public class transportMatrix {
    public static int[][] change(int[][] matrix){
        int[][] temp = new int[matrix[0].length][matrix[1].length];
        int dst = matrix.length-1;
        for (int i = 0; i < matrix.length; i++,dst--) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j][dst] = matrix[i][j];
            }
        }
        return temp;
    }

    public static void zhuanzhi(int[][] matrix){
        int[][] tempmatrix = new int[matrix[0].length][matrix[1].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                if (i!=j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

        }
    }
}
