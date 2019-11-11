package October_practice;

public class erFenChaZhao {

    public static String search(int[] arrays,int target,int head,int tail){
        int center = (head+tail)/2;
        if (center < 0 || center > arrays.length-1){
            return "No result";
        }
        if (target == arrays[center]){
            String st = "Result Location: " + (center+1);
            int index = center;
            while (index<=tail){
                if (target==arrays[++index]){
                    st += "," + (index+1);
                }else {
                    break;
                }
            }
            while (index>=head){
                if (target==arrays[--index]){
                    st += ","+(index+1);
                }else {
                    break;
                }
            }
//            do {
//                if (target==arrays[--index]){
//                    st += ","+(index+1);
//                }else {
//                    break;
//                }
//            }while (index>=head);
//            do {
//                if (target==arrays[++index]){
//                    st += ","+(index+1);
//                }else {
//                    break;
//                }
//            }while (index<=head);
            return st;
        }else if (target<arrays[center]){
            return search(arrays,target,head,center-1);

        }else if (target>arrays[center]){
            return search(arrays,target,center+1,tail);
        }else {
            return "No result";
        }
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,2,2,3,4,4,7,7,8,9,9,10};
        int target = 7;
        System.out.println(search(arrays,target,0,arrays.length));

    }
}
