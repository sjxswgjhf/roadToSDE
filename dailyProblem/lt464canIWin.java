package dailyProblem;

import java.util.Arrays;
import java.util.HashMap;

public class lt464canIWin {

    class Solution {
    /*
    每个人选数字，累积递减target，看谁选数字的时候正好能选一个大于等于target的数字
    一组boolean 用来维护选过的数字，然后map用来记录当前选法的结果，key为string，把boolean array变成str
    */

        HashMap<String, Boolean> map;
        public boolean canIWin(int max, int target) {
            if (target <= max)
                return true;
            if (((1 + max) / 2 * max) < target) {
                return false;
            }
            map = new HashMap<>();
            boolean[] used = new boolean[max + 1];
            return canwin(max, target, used);
        }

        private boolean canwin(int max, int target, boolean[] used){
            if(target <= 0){
                return false;
            }
            String str = Arrays.toString(used);
            if(map.containsKey(str)){
                return map.get(str);
            }
            for(int i = 1; i <= max; i++){
                if(used[i]){
                    continue;
                }
                used[i] = true;
                if(!canwin(max, target - i, used)){
                    map.put(str, true);
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
            map.put(str, false);
            return false;
        }

    }
}
