package steffan.deu.offer;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringOrganize {
    public ArrayList<String> Permutation(String str){
        ArrayList<String> resultList = new ArrayList<>();
        if (str.length()==0){
            return (ArrayList) resultList;
        }
        function(str.toCharArray(),resultList,0);
        Collections.sort(resultList);
        return (ArrayList)resultList;
    }

    private void function(char[] ch,List<String> list,int index){
        //这是递归的终止条件，就是i下标已经移到char数组的末尾的时候，考虑添加这一组字符串进入结果集中
        if(index == ch.length -1 ){
            if(!list.contains(new String(ch))){
                list.add(new String(ch));
            }
        }else{
            for(int j=index;j<ch.length;j++){
                swap(ch,index,j);
                function(ch,list,index+1);
                swap(ch,index,j);
            }
        }
    }

    public void swap(char[] ch,int i,int j){
        if (i!=j){
            char t = ch[i];
            ch[i] = ch[j];
            ch[j]=t;
        }
    }
}
