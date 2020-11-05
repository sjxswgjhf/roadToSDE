package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt78subsets {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums == null || nums.length == 0){
                return res;
            }
            List<Integer> list = new ArrayList<>();
            res.add(list);
            for(int i = 0; i < nums.length; i++){
                int size = res.size();
                for(int j = 0; j < size; j++){
                    List<Integer> cur = new ArrayList<>(res.get(j));
                    cur.add(nums[i]);
                    res.add(cur);
                }
            }
            return res;
        }
    }
}
