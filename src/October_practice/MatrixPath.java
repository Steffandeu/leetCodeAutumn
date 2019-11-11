package October_practice;

public class MatrixPath {

    public static boolean hasPath(char[] matrix,int rows,int cols, char[] str){
        if(matrix == null || matrix.length != rows * cols
                || str == null || str.length == 0
                || str.length > matrix.length) return false;
        boolean[] visited = new boolean[matrix.length];
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {
                if (dfs(matrix,rows,cols,str,i,j,0,visited)) return true;
            }

        }
        return false;

    }

    public static boolean dfs(char[] matrix,int rows,int cols,char[] str,int i,int j,int k,boolean[] visited){
        if (i<0 || i>=cols || j<0 || j>=rows || visited[i+j*cols] || matrix[i+j*cols]!=str[k]){
            return false;
        }
        if (k==str.length-1) return true;
        visited[i+j*cols]=true;
        if (dfs(matrix,rows,cols,str,i+1,j,k+1,visited) ||
                dfs(matrix,rows,cols,str,i,j+1,k+1,visited)||
                dfs(matrix,rows,cols,str,i-1,j,k+1,visited)||
                dfs(matrix,rows,cols,str,i,j-1,k+1,visited)){
            return true;
        }
        visited[i+j*cols] = false;
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = new char[]{'a','b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str1 = new char[]{'b','c','c','e','d'};
        char[] str2 = new char[]{'a','b','c','b'};
        System.out.println(hasPath(matrix,3,4,str1));
        System.out.println(hasPath(matrix,3,4,str2));



    }
}
