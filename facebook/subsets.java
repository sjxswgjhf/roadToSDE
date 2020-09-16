package facebook;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0; i <= nums.length; i++){
                helper(nums, 0, i, res, new ArrayList<>());
            }
            return res;
        }

        private void helper(int[] nums, int start, int len, List<List<Integer>> res, List<Integer> list){
            if(len == list.size()){
                res.add(new ArrayList<>(list));
                return;
            }
            for(int i = start; i < nums.length; i++){
                list.add(nums[i]);
                helper(nums, i + 1, len, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
