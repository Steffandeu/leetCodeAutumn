package October_practice;

public class replaceSpace {
    public String replaceString(StringBuffer stringBuffer){
        if (stringBuffer==null){
            return null;
        }else {
            return stringBuffer.toString().replaceAll(" ","%20");
        }
    }
}
