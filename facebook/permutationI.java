package facebook;

import java.util.ArrayList;
import java.util.List;

public class permutationI {

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums == null || nums.length == 0){
                return res;
            }
            List<Integer> list = new ArrayList<>();
            helper(res, list, nums);
            return res;
        }

        private void helper(List<List<Integer>> res, List<Integer> list, int[] nums){
            if(list.size() == nums.length){
                res.add(new ArrayList<>(list));
                return;
            }
            else{
                for(int i = 0; i < nums.length; i++){
                    if(list.contains(nums[i])){
                        continue;
                    }else{
                        list.add(nums[i]);
                        helper(res, list, nums);
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
    }

}
