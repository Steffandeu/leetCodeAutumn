package TwoDimensionArray;

public class TestTwodimension {
    public static void main(String[] args) {
        int array[][] = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(array.length);
        System.out.println(array[0].length);
        Twodimensionfind tdf = new Twodimensionfind();
        System.out.println(tdf.searchTwoDimension(array,7));
//        System.out.println(tdf.searchTwoDimensionLeftDown(array,11));
    }
}
