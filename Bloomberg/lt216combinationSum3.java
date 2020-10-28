package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt216combinationSum3 {

    class Solution {

        /*
        1 2 3 4 5 6 7 8 9

        n >= 46 return null
        */
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            if(n > 45){
                return res;
            }
            helper(res, k, n, new ArrayList<>(), 1);
            return res;
        }

        private void helper(List<List<Integer>> res, int k, int target, List<Integer> list, int num){
            if(k != 0 && target == 0){
                return;
            }
            if(k == 0 && target != 0){
                return;
            }
            if(k == 0 && target == 0){
                res.add(new ArrayList<>(list));
                return;
            }

            for(int i = num; i <= 9; i++){
                list.add(i);
                helper(res, k - 1, target - i, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
