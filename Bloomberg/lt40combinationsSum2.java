package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt40combinationsSum2 {

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if(candidates == null || candidates.length == 0){
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            helper(res, candidates, new ArrayList<>(), new boolean[candidates.length], target, 0, 0);
            return res;
        }

        private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] used, int target, int sum, int start){
            if(sum == target){
                res.add(new ArrayList<>(list));
                return;
            }
            if(sum > target){
                return;
            }
            for(int i = start; i < nums.length; i++){
                if(used[i]){
                    continue;
                }else{
                    if(i != 0 && nums[i] == nums[i-1] && used[i-1] == false){
                        continue;
                    }
                    used[i] = true;
                    list.add(nums[i]);
                    helper(res, nums, list, used, target, sum + nums[i], i + 1);
                    used[i] = false;
                    list.remove(list.size() - 1);
                }
            }

        }

    }
}
