package ReplaceSpace;

public class Test {
    public static void main(String[] args) {
        SpaceTrick st = new SpaceTrick();
        System.out.println(st.replaceSpaces("we are happy."));
        System.out.println(st.neureplacesSpaces(new StringBuilder("we are happy.")));
    }
}
