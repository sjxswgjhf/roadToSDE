package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSum {

    class SolutionTwoPointer {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++){
                if(i == 0 || nums[i] != nums[i-1]){
                    find(res, nums, i);
                }
            }
            return res;
        }

        private void find(List<List<Integer>> res, int[] nums, int idx){
            int lo = idx + 1, hi = nums.length - 1;
            while(lo < hi){
                int sum = nums[idx] + nums[lo] + nums[hi];
                if(sum == 0){
                    res.add(Arrays.asList(nums[idx], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    while(lo < hi && nums[lo] == nums[lo - 1]){
                        lo++;
                    }
                }else{
                    if(sum < 0){
                        lo++;
                    }else{
                        hi--;
                    }
                }
            }
        }
    }

    class SolutionHashSet {
        /*
        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            Arrays.sort(nums);
            for(int i = 0; i < nums.length ; i++){
                if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                    findThreeSum(nums, res, nums[i], i);
                }
            }
            return res;
        }

        private void findThreeSum(int[] nums, List<List<Integer>> res, int num, int idx){
            HashSet<Integer> set = new HashSet<>();
            for(int i = idx + 1; i < nums.length; i++){
                int target = -1 * (num + nums[i]);
                if(set.contains(target)){
                    res.add(Arrays.asList(num, nums[i], target));
                    while(i + 1 < nums.length && nums[i] == nums[i+1]){
                        i++;
                    }
                }else{
                    set.add(nums[i]);
                }
            }
        }
    }
}
