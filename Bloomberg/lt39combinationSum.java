package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt39combinationSum {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if(candidates == null || candidates.length == 0){
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            helper(res, candidates, new ArrayList<>(), target, 0, 0);
            return res;
        }

        private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int target, int sum, int pos){
            if(sum == target){
                res.add(new ArrayList<>(list));
                return;
            }
            if(sum > target){
                return;
            }
            for(int i = pos; i < nums.length; i++){
                list.add(nums[i]);
                helper(res, nums, list, target, sum + nums[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
}
