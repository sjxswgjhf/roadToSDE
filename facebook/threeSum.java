package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSum {

    class SolutionTwoPointer {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for(int i = 0; i < nums.length && nums[i] <= 0; i++){
                if(i == 0 || nums[i - 1] != nums[i]){
                    twoSum(nums, i, res);
                }
            }
            return res;
        }

        private void twoSum(int[] nums, int i, List<List<Integer>> res){
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                int sum = nums[l] + nums[r] + nums[i];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l - 1]){
                        l++;
                    }
                }
                else if(sum < 0){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
    }


    class SolutionHashSet {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            //to avoid dup
            Arrays.sort(nums);
            for(int i = 0; i < nums.length && nums[i] <= 0; i++){
                if(i == 0 || nums[i] != nums[i - 1]){
                    twoSum(nums, i, res);
                }
            }
            return res;
        }

        private void twoSum(int[] nums, int i, List<List<Integer>> res){
            HashSet<Integer> map = new HashSet<>();
            for(int j = i + 1; j < nums.length; j++){
                int complement = -nums[i] - nums[j];
                if(map.contains(complement)){
                    res.add(Arrays.asList(nums[i], nums[j], complement));
                    //avoid dups
                    while(j + 1 < nums.length && nums[j] == nums[j + 1]){
                        j++;
                    }
                }else{
                    map.add(nums[j]);
                }
            }
        }
    }
}
