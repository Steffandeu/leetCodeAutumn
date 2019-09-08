package steffan.deu.offer.netease;

public class CaffeDrink {
    //间隔不能小于k，一个月30天，M天是游戏发布的时候，必须要喝咖啡

    public int solution(int k,int[] gamesDay){
        if (gamesDay==null || gamesDay.length==0 || k==0){
            return 30/(k+1);
        }
        int maxDay = 0;
        //统计第一个游戏日期之前能喝几天
        if (gamesDay[0] % (k+1)==0){
            maxDay+=(gamesDay[0]/k+1)-1;
        }else {
            maxDay+=(gamesDay[0]/k+1)+1;
        }
        //统计最后一个游戏日之后还可以喝几杯
        maxDay += (30-gamesDay[gamesDay.length-1])/(k+1);
        //游戏第一天加入
        maxDay++;
        for (int i = 0; i < gamesDay.length; i++) {
            int cur = gamesDay[i];
            int pre = gamesDay[i-1];
            int curCount = (cur-pre)/(k+1)-1;
            maxDay+=curCount;
            maxDay++;
        }
        return maxDay;

    }

}
