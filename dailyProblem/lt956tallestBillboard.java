package dailyProblem;

import java.util.HashMap;

public class lt956tallestBillboard {

    class Solution {
        public int tallestBillboard(int[] rods) {
            //key: sum of left part - right part
            //val: larget sum of left
            HashMap<Integer, Integer> dp = new HashMap<>();
            dp.put(0, 0);
            for(int rod : rods){
                HashMap<Integer, Integer> tmp = new HashMap<>(dp);
                for(int dif : dp.keySet()){
                    //add rod to left, diff increase,
                    //val需要更新，比较的是当前tmp里面存在的dif+rod的或者上一层中的dif的sum+当前的rod
                    tmp.put(dif + rod, Math.max(tmp.getOrDefault(dif + rod, 0), dp.get(dif) + rod));
                    //add rod to right, dif decrease,
                    //val更新
                    tmp.put(dif - rod, Math.max(tmp.getOrDefault(dif - rod, 0), dp.get(dif)));
                }
                dp = tmp;
            }
            //最后返回dp里面dif是0的最大sum
            return dp.get(0);
        }
    }
}
