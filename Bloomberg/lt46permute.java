package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt46permute {

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if(nums == null || nums.length == 0){
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            helper(res, nums, new ArrayList<>());
            return res;
        }

        private void helper(List<List<Integer>> res, int[] nums, List<Integer> list){
            if(list.size() == nums.length){
                res.add(new ArrayList<>(list));
            }
            for(int i = 0; i < nums.length; i++){
                if(list.contains(nums[i])){
                    continue;
                }
                list.add(nums[i]);
                helper(res, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
