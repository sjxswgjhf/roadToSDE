package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt15threeSum {
    /*
    这题坑很多，首先要排序来，我们就可以通过比较后面两个跟第一个candidate的和来确认当前的解，并利用sort的特性降低complexity
    然后选第一个candidate，要保证这个candidate的同样的值没有选过，然后还要小于等于0
    然后helper里面，首先确定第二第三candidate的idx是idx+1跟最后一个idx，
    然后看sum，如果当前sum= 0，那么就是一组有效的解，加入res，然后我们移动第二第三个idx的，这里要避免重复解的话，要确保lowidx||highidx
    移动到下一个的idx的值跟之前的不一样了。需要while loop，这样才能避免重复，
    如果sum不为0，根据正负移动两个idx
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);  //avoid dup
            for(int i = 0 ; i < nums.length; i++){
                if(nums[i] > 0){
                    break;
                }
                if(i == 0 || nums[i] != nums[i - 1]){
                    helper(res, nums, i);
                }
            }
            return res;
        }

        private void helper(List<List<Integer>> res, int[] nums, int idx){
            int lowidx = idx + 1;
            int highidx = nums.length - 1;
            while(lowidx < highidx){
                int sum = nums[idx] + nums[lowidx] + nums[highidx];
                if(sum == 0){
                    // List<Integer> list = new ArrayList<>();
                    // list.add(nums[idx]);
                    // list.add(nums[lowidx]);
                    // list.add(nums[highidx]);
                    // res.add(list);
                    res.add(Arrays.asList(nums[idx], nums[lowidx], nums[highidx]));
                    lowidx++;
                    highidx--;
                    //注意避免重复的结果
                    while(lowidx < highidx && nums[lowidx] == nums[lowidx - 1]){
                        lowidx++;
                    }
                }else if(sum > 0){
                    highidx--;
                }else{
                    lowidx++;
                }
            }
        }
    }
}
