package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationII {

    class Solution{
        public List<List<Integer>> permuteUnique(int[] nums){
            List<List<Integer>> res = new ArrayList<>();
            if(nums == null || nums.length == 0){
                return res;
            }
            Arrays.sort(nums);
            boolean[] used = new boolean[nums.length];
            helper(res, nums, new ArrayList<>(), used);
            return res;
        }

        private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] used){
            if(list.size() == nums.length){
                res.add(new ArrayList<>(list));
                return;
            }
            for(int i = 0; i < nums.length; i++){

                if(used[i] || (i > 0 && nums[i] == nums[i -1] && !used[i - 1])){
                    continue;
                }
                used[i] = true;
                list.add(nums[i]);
                helper(res, nums, list, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}
