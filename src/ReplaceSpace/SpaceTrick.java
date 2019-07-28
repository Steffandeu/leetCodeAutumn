package ReplaceSpace;

public class SpaceTrick {
    public String replaceSpaces(String str){
        if (str==null){
            return null;
        }else {
            return str.toString().replaceAll(" ","%20");
        }
    }

    public String neureplacesSpaces(StringBuilder string){
        if (string==null){
            return null;
        }else {
            return string.toString().replaceAll(" ","%20");
        }
    }
}
