package dailyProblem;

import java.util.*;

public class lt475findRadius {

    class Solution {
        /*
        houses找最近的heater在哪，
        每个house只要看两个heater，当前idx大于等于自己的那个跟当前的前一个
        */
        public int findRadius(int[] houses, int[] heaters) {

            Arrays.sort(houses);
            Arrays.sort(heaters);
            int res = 0;
            int idx = 0;
            for(int house : houses){
                int dis = Integer.MAX_VALUE;
                //每次都保证heater大于等于房子
                while(idx < heaters.length && heaters[idx] < house){
                    idx++;
                }
                if(idx != 0){
                    //跟前一个heater的距离
                    dis = Math.min(dis, house - heaters[idx-1]);
                }
                if(idx < heaters.length){
                    //前一个的距离比较当前的距离
                    dis = Math.min(dis, heaters[idx] - house);
                }
                res = Math.max(dis, res);

            }
            return res;
        }
    }
}
